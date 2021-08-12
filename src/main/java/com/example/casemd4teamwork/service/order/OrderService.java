package com.example.casemd4teamwork.service.order;

import com.example.casemd4teamwork.model.Order;
import com.example.casemd4teamwork.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository iOrderRepository;
    @Override
    public Iterable<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return iOrderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return iOrderRepository.save(order);
    }

    @Override
    public void remove(Long id) {
        iOrderRepository.deleteById(id);
    }
}
