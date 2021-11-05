package com.lib.system.controller;


import com.lib.system.services.BoughtBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bought-books")
@CrossOrigin(origins = "*")
public class BoughtBookController {
    private BoughtBookService boughtBookService;

    @Autowired
    public BoughtBookController(BoughtBookService boughtBookService) {
        this.boughtBookService = boughtBookService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveBoughtBook(@RequestParam Map<String, String> params) {
        boughtBookService.saveBoughtBook(params);
        return  ResponseEntity.ok(HttpStatus.CREATED);
    }


}
