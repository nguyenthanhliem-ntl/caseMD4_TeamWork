package com.example.casemd4teamwork.repository;

import com.example.casemd4teamwork.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Long> {
//    Optional<Status> findByStatus(Status status);
    List<Status> findAll();


}
