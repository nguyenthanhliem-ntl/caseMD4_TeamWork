package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.Form;
import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Image;
import com.example.casemd4teamwork.service.home.IHomeService;
import com.example.casemd4teamwork.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
//    @PostMapping
//    public ResponseEntity<Void> create(@RequestBody Image image) {
//        imageService.save(image);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
    @PostMapping("/rest/upload")
    public ResponseEntity<?> multiUploadFileModel2(Form form) {
        Image image1 = new Image();
        image1.setHome(form.getHome());
        image1.setImage(form.getImage().getOriginalFilename());
        MultipartFile image = form.getImage();
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(),
                    new File(UPLOAD_DIR + fileName)); // coppy ảnh từ ảnh nhận được vào thư mục quy định,
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageService.save(image1);
        return new ResponseEntity<>(image1, HttpStatus.CREATED);
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
    @GetMapping("/search/{value}")
    public ResponseEntity<Iterable<Image>> findByAllAdress(@PathVariable String value) {
        return new ResponseEntity<>(imageService.findAllByImageAddress("%" + value + "%"), HttpStatus.OK);
    }
    @GetMapping("/find/{price1},{price2}")
    public ResponseEntity<Iterable<Image>> findAllByPrice(@PathVariable Long price1, @PathVariable Long price2) {
        return new ResponseEntity<>(imageService.findAllByImagePrice(price1, price2), HttpStatus.OK);
    }
    @GetMapping("/tim/{price1},{price2},{address},{num_Bedroom},{num_Bathroom}")
    public ResponseEntity<Iterable<Image>> findAllByHome(@PathVariable Long price1, @PathVariable Long price2, @PathVariable String address, @PathVariable int num_Bedroom, @PathVariable int num_Bathroom) {
        return new ResponseEntity<>(imageService.findByImageHome(price1, price2,"%" + address + "%", num_Bedroom, num_Bathroom), HttpStatus.OK);
    }
}
