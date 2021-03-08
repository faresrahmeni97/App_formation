package com.example.App_formation.controller;


import com.example.App_formation.entities.User;
import com.example.App_formation.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    UserRepository userRep;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> userss = userRep.findAll();
        return userss;
    }
    @GetMapping("/user/{code}")
    public User getUserById(@PathVariable(value = "code") Long Code) {
        return userRep.findById(Code).orElseThrow(null);
    }

    @PostMapping("/adduser")
    public User createUser(@Valid @RequestBody User user) {
        return userRep.save(user);
    }
    @DeleteMapping("/user/{code}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "code") Long userCode) {
        User user = userRep.findById(userCode).orElseThrow(null);
        userRep.delete(user);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/user/{code}")
    public User updateUser(@PathVariable(value = "code") Long code,
                           @Valid @RequestBody User userUpdated) {

        User user = userRep.findById(code).orElseThrow(null);
        user.setLogin(userUpdated.getLogin());
        user.setPassword(userUpdated.getPassword());
        User updatedUser = userRep.save(user);
        return updatedUser;
    }



}
