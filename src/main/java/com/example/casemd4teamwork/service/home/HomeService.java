package com.example.casemd4teamwork.service.home;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.User;
import com.example.casemd4teamwork.repository.IHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public  class HomeService implements IHomeService{

    @Autowired
    IHomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public Home save(Home home) {
     return homeRepository.save(home);
    }

    @Override
    public void remove(Long id) {
        homeRepository.deleteById(id);
    }



}
