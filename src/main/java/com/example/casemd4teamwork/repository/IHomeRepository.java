package com.example.casemd4teamwork.repository;

import com.example.casemd4teamwork.model.Home;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHomeRepository extends PagingAndSortingRepository<Home, Long> {
}
