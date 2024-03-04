package com.example.practise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pracmodel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int fid;
    private String name;
    Pracmodel(){}
    public Pracmodel(int fid, String name) {
        this.fid = fid;
        this.name = name;
    }
    public int getId() {
        return fid;
    }
    public void setId(int fid) {
        this.fid = fid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}