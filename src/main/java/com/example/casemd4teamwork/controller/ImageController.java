package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Image;
import com.example.casemd4teamwork.service.home.IHomeService;
import com.example.casemd4teamwork.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    IImageService imageService;

    @Autowired
    IHomeService homeService;

    @GetMapping
    public ResponseEntity<Iterable<Image>> showListImage(){
        List<Image> images = (List<Image>) imageService.findAll();
        if (images.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }



}

