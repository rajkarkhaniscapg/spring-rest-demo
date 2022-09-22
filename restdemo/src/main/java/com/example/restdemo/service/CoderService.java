package com.example.restdemo.service;

import com.example.restdemo.advices.ResourceNotFoundException;
import com.example.restdemo.entity.Coder;

import java.util.List;

public interface CoderService {
    Coder getCoder(int coderId);
    List<Coder> getAllCoders();
    Coder addCoder(Coder coder);
    List<Coder> addAllCoders(List<Coder> coders);
    Coder updateCoder(Coder coder) throws ResourceNotFoundException;
    String deleteCoder(Coder coder);
    String deleteCoder(int coderId);
    Coder getCoderByCoderName(String coderName);
    List<Coder> getCoderByTechSorted(String tech);
}
