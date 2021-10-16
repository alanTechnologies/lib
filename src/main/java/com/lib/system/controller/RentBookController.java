package com.lib.system.controller;

import com.lib.system.services.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class RentBookController {
    RentBookService rentBookService;

    @Autowired
    public RentBookController(RentBookService rentBookService) {

        this.rentBookService = rentBookService;

    }

    @PostMapping("rent-a-book")
    public void saveRentBook(@RequestParam Map<String, String> params) {
        Long idBook = Long.parseLong(params.get("idBook"));

        String startDay = params.get("startDay");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDayFormatted = LocalDate.parse(startDay, formatter);

        String endDay = params.get("endDay");

        LocalDate endDayFormatted = LocalDate.parse(endDay, formatter);

        String cnp = params.get("cnp");

        rentBookService.save(idBook, startDayFormatted, endDayFormatted, cnp);
    }

}
