package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Image;
import com.example.casemd4teamwork.service.home.IHomeService;
import com.example.casemd4teamwork.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
public class ImageController {
    private static String UPLOAD_DIR = "C:\\Users\\Admin\\WebstormProjects\\castudy_modul4_ajax\\image\\";

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
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Image image) {
        imageService.save(image);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Image> findById(@PathVariable Long id){
        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(imageOptional.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> editImage(@PathVariable Long id, @RequestBody Image image){
        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        image.setId(id);
        imageService.save(image);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Image> delete(@PathVariable Long id){
        Optional<Image> image = imageService.findById(id);
        if (!image.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        imageService.remove(id);
        return new ResponseEntity<>(image.get(), HttpStatus.NO_CONTENT);
    }
}
