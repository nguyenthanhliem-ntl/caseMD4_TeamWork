package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.User;
import com.example.casemd4teamwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public ModelAndView showListUser(){
        Iterable<User> users= userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateUser(){
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("city",new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveUser(@ModelAttribute("city") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "thêm thành công!");
        return modelAndView;
    }


    @GetMapping("delete-user/{id}")
    public ModelAndView deleteUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/user/delete");
            modelAndView.addObject("city",user.get());
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteUser(@ModelAttribute ("user") User user){
        userService.remove((user.getId()));
        return "redirect:user";
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditUser(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/user/edit");
            modelAndView.addObject("city",userOptional.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/edit-user")
    public ModelAndView updateCity(@ModelAttribute("user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/user/edit");
        modelAndView.addObject("user",user);
        modelAndView.addObject("message","Cập nhật thành công!");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView listUsers(@RequestParam("user") Optional<String> s, Pageable pageable){
        Page<User> users;
        if(s.isPresent()){
            users = userService.findAllByFirstNameContaining(s.get(), pageable);
        } else {
            users = userService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("user", users);
        return modelAndView;
    }
}
