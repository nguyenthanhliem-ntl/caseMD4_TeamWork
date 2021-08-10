package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Home_Time;
import com.example.casemd4teamwork.service.home_time.Home_TimeService;
import com.example.casemd4teamwork.service.home_time.IHome_TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/times")
@CrossOrigin("*")
public class Home_TimeController {

    @Autowired
    private IHome_TimeService home_timeService;

    @GetMapping
    public ResponseEntity<Iterable<Home_Time>> showListHomeTime(){
        List<Home_Time> home_times = (List<Home_Time>) home_timeService.findAll();
        if (home_times.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(home_times, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Home_Time home_time) {
        home_timeService.save(home_time);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Home_Time> findById(@PathVariable Long id){
        Optional<Home_Time> home_timeOptional = home_timeService.findById(id);
        if (!home_timeOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(home_timeOptional.get(), HttpStatus.OK);
    }
}
