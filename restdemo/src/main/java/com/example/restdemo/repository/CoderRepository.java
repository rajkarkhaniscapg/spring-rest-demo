package com.example.restdemo.repository;

import com.example.restdemo.entity.Coder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoderRepository extends JpaRepository<Coder, Integer> {
    Coder getCoderByCoderName(String coderName);

    @Query("select c from Coder c where tech = ?1 order by coderName")
    List<Coder> getCoderByTechSorted(String tech);
}
