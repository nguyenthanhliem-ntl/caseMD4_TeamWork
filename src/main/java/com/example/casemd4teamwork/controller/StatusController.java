package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Status;
import com.example.casemd4teamwork.repository.IStatusRepository;
import com.example.casemd4teamwork.service.status.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private IStatusRepository statusRepository;

    @Autowired
    private IStatusService statusService;

    @GetMapping("/allStatus")
    public List<Status> findAll(){
        return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> findById(@PathVariable Long id){
        Optional<Status> statusOptional = statusService.findById(id);
        if (!statusOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(statusOptional.get(), HttpStatus.OK);
    }



}
