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

@Controller
//@RestController
//@RequestMapping("/api/images")
//@CrossOrigin("*")
public class ImageController {

//    @Autowired
//    IImageService imageService;
//
//    @Autowired
//    IHomeService homeService;
//
//    @GetMapping
//    public ResponseEntity<Iterable<Image>> showListImage(){
//        List<Image> images = (List<Image>) imageService.findAll();
//        if (images.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(images, HttpStatus.OK);
//    }

    @RequestMapping(value = "/")
    public String homePage() {

        return "index";
    }



    @GetMapping(value = "/uploadOneFile")
    public String uploadOneFileHandler(Model model) {

        Image image = new Image();
        model.addAttribute("image", image);

        return "image";
    }


    @PostMapping(value = "/uploadOneFile")
    public String uploadOneFileHandlerPOST(HttpServletRequest request,
                                           Model model,
                                           @ModelAttribute("image") Image image) {
        return this.doUpload(request, model, image);
    }

    @GetMapping(value = "/uploadMultiFile")
    public String uploadMultiFileHandler(Model model) {

        Image image = new Image();
        model.addAttribute("image", image);

        return "/image/uploadMutilFile";
    }

    @PostMapping(value = "/uploadMutilFile")
    public String uploadMultiFileHandlerPOST(HttpServletRequest request,
                                             Model model,
                                             @ModelAttribute("image") Image image) {

        return this.doUpload(request, model, image);

    }

    private String doUpload(HttpServletRequest request, Model model,
                            Image image) {

        String description = image.getDescription();
        System.out.println("Description: " + description);


        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);

        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        MultipartFile[] files = image.getFiles();
        List<File> uploadedFiles = new ArrayList<File>();
        List<String> failedFiles = new ArrayList<String>();

        for (MultipartFile fileData : files) {

            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = " + name);

            if (name != null && name.length() > 0) {
                try {
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    uploadedFiles.add(serverFile);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                    failedFiles.add(name);
                }
            }
        }
        model.addAttribute("description", description);
        model.addAttribute("uploadedFiles", uploadedFiles);
        model.addAttribute("failedFiles", failedFiles);
        return "uploadResult";
    }

}

