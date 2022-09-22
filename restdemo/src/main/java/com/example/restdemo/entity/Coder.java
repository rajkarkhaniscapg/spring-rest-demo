package com.example.restdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Coder {
    @Id @GeneratedValue
    private int coderId;
    private String coderName;
    private String tech;

    @OneToMany(mappedBy = "coder", cascade = CascadeType.ALL)
    private List<Laptop> laptops;

    public Coder() {}


    public int getCoderId() {
        return coderId;
    }

    public void setCoderId(int id) {
        this.coderId = id;
    }

    public String getCoderName() {
        return coderName;
    }

    public void setCoderName(String name) {
        this.coderName = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
