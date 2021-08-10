package com.example.casemd4teamwork.repository;

import com.example.casemd4teamwork.model.Order;
import com.example.casemd4teamwork.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
}
