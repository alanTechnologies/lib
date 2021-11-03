package com.lib.system.controller;


import com.lib.system.services.BoughtBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BoughtBookController {
    private BoughtBookService boughtBookService;
    @Autowired
    public BoughtBookController(BoughtBookService boughtBookService){
        this.boughtBookService = boughtBookService;
    }

    @PostMapping("bought-book")
public void saveBoughtBook(@RequestParam Map<String,String> params){

    boughtBookService.saveBoughtBook(params);
}




}
