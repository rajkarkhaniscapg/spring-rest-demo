package com.example.restdemo.controller;

import com.example.restdemo.advices.ResourceNotFoundException;
import com.example.restdemo.entity.Coder;
import com.example.restdemo.service.CoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/coder")
public class CoderController {

    @Autowired
    CoderService service;

    @GetMapping(value = "/get/{id}")
    public Coder getCoder(@PathVariable int id) {
        return service.getCoder(id);
    }

    @GetMapping(value = "/get")
    public List<Coder> getAllCoders() {
        return service.getAllCoders();
    }

    @PostMapping(value = "/add")
    public Coder addCoder(@RequestBody Coder coder) {
        return service.addCoder(coder);
    }

    @PostMapping(value = "/addAll")
    public List<Coder> addAllCoders(@RequestBody List<Coder> coders) {
        return service.addAllCoders(coders);
    }

    @PutMapping(value = "/update")
    public Coder updateCoder(@RequestBody Coder coder) throws ResourceNotFoundException {
        return service.updateCoder(coder);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteCoder(@RequestBody Coder coder) {
        return new ResponseEntity<String>(service.deleteCoder(coder), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCoder(@PathVariable int id) {
        return new ResponseEntity<String>(service.deleteCoder(getCoder(id)), HttpStatus.OK);
    }

    @GetMapping(value = "/getbyname/{name}")
    public Coder getCoder(@PathVariable String name) {
        return service.getCoderByCoderName(name);
    }

    @GetMapping(value = "/getbytechsorted/{tech}")
    public List<Coder> getCoderByTechSorted(@PathVariable String tech){
        return service.getCoderByTechSorted(tech);
    }
}
