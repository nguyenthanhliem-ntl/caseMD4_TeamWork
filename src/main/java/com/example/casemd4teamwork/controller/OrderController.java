package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Order;
import com.example.casemd4teamwork.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping
    public ResponseEntity<Iterable<Order>> showListHome(){
        List<Order> orders = (List<Order>) iOrderService.findAll();
        if (orders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Order order) {
        iOrderService.save(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Optional<Order> optionalOrder = iOrderService.findById(id);
        if (!optionalOrder.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> delete(@PathVariable Long id){
        Optional<Order> order = iOrderService.findById(id);
        if (!order.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iOrderService.remove(id);
        return new ResponseEntity<>(order.get(), HttpStatus.NO_CONTENT);
    }
}
