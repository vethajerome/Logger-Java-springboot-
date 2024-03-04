package com.example.practise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practise.model.Pracmodel;

@Repository
public interface PracRepository extends JpaRepository<Pracmodel,Integer> {

    
}