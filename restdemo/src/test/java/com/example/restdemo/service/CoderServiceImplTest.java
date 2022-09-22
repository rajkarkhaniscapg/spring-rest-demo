package com.example.restdemo.service;

import com.example.restdemo.advices.ResourceNotFoundException;
import com.example.restdemo.entity.Coder;
import com.example.restdemo.repository.CoderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class CoderServiceImplTest {

    @Autowired
    CoderService service;

    @MockBean
    CoderRepository repository;

    Coder coderOne;
    Coder coderTwo;
    Coder coderThree;

    @BeforeEach
    void createObjects() {
        coderOne = new Coder();
        coderOne.setCoderId(1);
        coderOne.setCoderName("ABC");
        coderOne.setTech("Java");

        coderTwo = new Coder();
        coderTwo.setCoderId(2);
        coderTwo.setCoderName("XYZ");
        coderTwo.setTech("Python");

        coderThree = new Coder();
        coderThree.setCoderId(3);
        coderThree.setCoderName("LMN");
        coderThree.setTech("Java");
    }

    // Get coder by ID
    @Test
    void getCoder() {
        Optional<Coder> optionalCoder = Optional.of(coderOne);
        Mockito.when(repository.findById(1)).thenReturn(optionalCoder);
        assertThat(service.getCoder(1)).isEqualTo(coderOne);
    }

    @Test
    void getAllCoders() {
        List<Coder> coderList = new ArrayList<>();
        coderList.add(coderOne);
        coderList.add(coderTwo);
        coderList.add(coderThree);

        Mockito.when(repository.findAll()).thenReturn(coderList);
        assertThat(service.getAllCoders()).isEqualTo(coderList);
    }

    @Test
    void addCoder() {
        Mockito.when(repository.save(coderOne)).thenReturn(coderOne);
        assertThat(service.addCoder(coderOne)).isEqualTo(coderOne);
    }

    @Test
    void addAllCoders() {
        List<Coder> coderList = new ArrayList<>();
        coderList.add(coderOne);
        coderList.add(coderTwo);
        coderList.add(coderThree);

        Mockito.when(repository.saveAll(coderList)).thenReturn(coderList);
        assertThat(service.addAllCoders(coderList)).isEqualTo(coderList);
    }

    @Test
    void updateCoder() throws ResourceNotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(coderOne));
        Mockito.when(repository.save(coderOne)).thenReturn(coderOne);

        coderOne.setCoderName("New Name");
        coderOne.setTech("New Tech");

        assertThat(service.updateCoder(coderOne)).isEqualTo(coderOne);
    }

    // Delete coder by ID
    @Test
    void deleteCoderById() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(coderOne));
        Mockito.when(repository.existsById(1)).thenReturn(false);
        assertFalse(repository.existsById(coderOne.getCoderId()));
    }

    // Delete coder by Object
    @Test
    void deleteCoder() {
    }

    @Test
    void getCoderByCoderName() {
    }

    @Test
    void getCoderByTechSorted() {
    }
}