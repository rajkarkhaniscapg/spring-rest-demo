package com.example.restdemo.controller;

import com.example.restdemo.entity.Laptop;
import com.example.restdemo.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/laptop")
public class LaptopController {

    @Autowired
    LaptopService service;

    @PostMapping(value = "/add")
    public Laptop addLaptop(@RequestBody Laptop laptop){
        return service.addLaptop(laptop);
    }
}
