package com.example.casemd4teamwork.service;


import com.example.casemd4teamwork.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save (T t);

    void remove(Long id);

    Page<User> findAll(Pageable pageable);
}
