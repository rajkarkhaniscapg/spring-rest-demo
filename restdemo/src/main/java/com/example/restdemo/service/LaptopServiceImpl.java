package com.example.restdemo.service;

import com.example.restdemo.entity.Laptop;
import com.example.restdemo.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopServiceImpl implements LaptopService{

    @Autowired
    LaptopRepository repository;

    @Override
    public Laptop addLaptop(Laptop laptop) {
        return repository.save(laptop);
    }
}
