package com.example.practise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.practise.model.Pracmodel;

import com.example.practise.repository.PracRepository;

@Service
public class Pracservice {
    @Autowired
    PracRepository repo;

    public Pracmodel create(Pracmodel j) {
        return repo.save(j);
        // return true;
    }
    

    public Pracmodel find(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Pracmodel> findA() {
        return repo.findAll();
    }

    public Pracmodel update(int id, Pracmodel j) {
        Pracmodel p1 = repo.findById(id).orElse(null);
        if (p1 != null) {
            p1.setName(j.getName());
            repo.save(p1);
            return p1;
        } else {
            return j;
        }
    }

    public void delete(int id) {
        repo.deleteById(id);

    }

    // public Object save(Pracmodel j) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'save'");
    // }
    public List<Pracmodel>pagination(int  pageNo, int pageSize){
        return  repo.findAll(PageRequest.of(pageNo, pageSize)).getContent();
    }

}