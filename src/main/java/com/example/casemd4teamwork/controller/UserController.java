package com.example.casemd4teamwork.controller;

import com.example.casemd4teamwork.model.User;
import com.example.casemd4teamwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/user")
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

//    @GetMapping("/users")
//    public ModelAndView listUsers(@RequestParam("user") Optional<String> s, Pageable pageable){
//        Page<User> users;
//        if(s.isPresent()){
//            users = userService.findAllByFirstNameContaining(s.get(), pageable);
//        } else {
//            users = userService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("/user/list");
//        modelAndView.addObject("user", users);
//        return modelAndView;
//    }
//=======
//import com.example.casemd4teamwork.service.jwt.JwtService;
//import com.example.casemd4teamwork.service.user.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;

//@RestController
//@RequestMapping("")
//@CrossOrigin("*")
//public class UserController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private IUserService userService;
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User user){
//        Optional<User> userOptional = userService.findById(id);
//        if (!userOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        user.setId(userOptional.get().getId());
//        userService.save(user);
//        return new ResponseEntity<>(userService.findById(user.getId()).get(), HttpStatus.OK);
//    }


    /// API
@GetMapping
public ResponseEntity<Iterable<User>> findAllUser() {
    List<User> customers = (List<User>) userService.findAll();
    if (customers.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(customers, HttpStatus.OK);
}

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        Optional<User> customerOptional = userService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveCustomer(@RequestBody User customer) {
        return new ResponseEntity<>(userService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateCustomer(@PathVariable Long id, @RequestBody User user) {
        Optional<User> customerOptional = userService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(customerOptional.get().getId());
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteCustomer(@PathVariable Long id) {
        Optional<User> customerOptional = userService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
