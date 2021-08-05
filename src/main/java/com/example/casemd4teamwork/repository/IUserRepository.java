package com.example.casemd4teamwork.repository;

import com.example.casemd4teamwork.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Page<User> findAllByFirstNameContaining(String username, Pageable pageable);

}
