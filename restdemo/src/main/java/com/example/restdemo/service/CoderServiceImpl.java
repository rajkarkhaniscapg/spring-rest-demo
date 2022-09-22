package com.example.restdemo.service;

import com.example.restdemo.advices.ResourceNotFoundException;
import com.example.restdemo.entity.Coder;
import com.example.restdemo.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class CoderServiceImpl implements CoderService {

    @Autowired
    CoderRepository repository;

    Supplier<ResourceNotFoundException> notFound = () -> new ResourceNotFoundException("Resource Does Not Exist");

    @Override
    public Coder getCoder(int coderId) {
        return repository.findById(coderId).orElseThrow();
    }

    @Override
    public List<Coder> getAllCoders() {
        return repository.findAll();
    }

    @Override
    public Coder addCoder(Coder coder) {
        return repository.save(coder);
    }

    @Override
    public List<Coder> addAllCoders(List<Coder> coders) {
        return repository.saveAll(coders);
    }

    @Override
    public Coder updateCoder(Coder coder) throws ResourceNotFoundException {
        Coder newCoder = repository.findById(coder.getCoderId()).orElseThrow(notFound);
        newCoder.setCoderName(coder.getCoderName());
        newCoder.setTech(coder.getTech());
        newCoder.setLaptops(coder.getLaptops());
        return repository.save(newCoder);
    }

    @Override
    public String deleteCoder(Coder coder) {
        repository.delete(coder);
        return "Deleted";
    }

    @Override
    public String deleteCoder(int coderId) {
        repository.deleteById(coderId);
        return "Deleted";
    }

    @Override
    public Coder getCoderByCoderName(String coderName) {
        return repository.getCoderByCoderName(coderName);
    }

    @Override
    public List<Coder> getCoderByTechSorted(String tech) {
        return repository.getCoderByTechSorted(tech);
    }
}
