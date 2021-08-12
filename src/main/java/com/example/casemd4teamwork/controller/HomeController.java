package com.example.casemd4teamwork.controller;


import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.service.home.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/homes")
@CrossOrigin("*")
public class HomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping
    public ResponseEntity<Iterable<Home>> showListHome(){
        List<Home> homes = (List<Home>) homeService.findAll();
        if (homes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Home home) {
        homeService.save(home);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Home> findById(@PathVariable Long id){
        Optional<Home> homeOptional = homeService.findById(id);
        if (!homeOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(homeOptional.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> editHome(@PathVariable Long id, @RequestBody Home home){
        Optional<Home> homeOptional = homeService.findById(id);
        if (!homeOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        home.setId(id);
        homeService.save(home);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Home> delete(@PathVariable Long id){
        Optional<Home> home = homeService.findById(id);
        if (!home.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        homeService.remove(id);
        return new ResponseEntity<>(home.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search/{value}")
    public ResponseEntity<Iterable<Home>> findByAllAdress(@PathVariable String value) {
        return new ResponseEntity<>(homeService.findAllByAddress("%" + value + "%"), HttpStatus.OK);
    }
    @GetMapping("/find/{price1},{price2}")
    public ResponseEntity<Iterable<Home>> findAllByPrice(@PathVariable Long price1, @PathVariable Long price2) {
        List<Home> homes = (List<Home>) homeService.findAllByPrice(price1, price2);
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
    @GetMapping("/find/{price1},{price2},{address},{num_Bedroom},{num_Bathroom}")
    public ResponseEntity<Iterable<Home>> findAllByHome(@PathVariable Long price1, @PathVariable Long price2, @PathVariable String address, @PathVariable int num_Bedroom, @PathVariable int num_Bathroom) {
        return new ResponseEntity<>(homeService.findByHome(price1, price2,"%" + address + "%", num_Bedroom, num_Bathroom), HttpStatus.OK);
    }
}
