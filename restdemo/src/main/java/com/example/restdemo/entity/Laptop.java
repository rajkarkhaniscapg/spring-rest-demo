package com.example.restdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id @GeneratedValue
    private int laptopId;
    private String model;
    private String company;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "coderId", referencedColumnName = "coderId")
    private Coder coder;

    public Laptop() {}

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Coder getCoder() {
        return coder;
    }

    public void setCoder(Coder coder) {
        this.coder = coder;
    }
}
