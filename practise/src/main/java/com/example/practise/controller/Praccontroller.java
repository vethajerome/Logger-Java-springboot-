package com.example.practise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import com.example.practise.model.Pracmodel;

import com.example.practise.service.Pracservice;

// @RestController
@RequestMapping("/api")
public class Praccontroller {
    @Autowired
    Pracservice obj;

    // @PostMapping("/insert")
    // public Pracmodel insert(@RequestBody Pracmodel j) {
    // return obj.create(j);
    // }
    @PostMapping("/insert")
    public ResponseEntity<Pracmodel> insert(@RequestBody Pracmodel j) {
        return new ResponseEntity<>(obj.create(j), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Pracmodel fin(@PathVariable int id) {
        return obj.find(id);
    }

    @GetMapping("/all")
    public List<Pracmodel> findA() {
        return obj.findA();
    }

    @PutMapping("/update/{id}")
    public Pracmodel update(@PathVariable int id, @RequestBody Pracmodel u) {
        return obj.update(id, u);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        obj.delete(id);

    }
    // @PostMapping("/insert2")
    // public Pracmodel2 insert(@RequestBody Pracmodel2 k) {
    // return obj.create2(k);
    // }
    @GetMapping("/pagination/{pageno}/{pagesize}")
    List <Pracmodel>pagination(@PathVariable int pageno,@PathVariable int pagesize)
    {
        return obj.pagination(pageno,pagesize);
    }
}