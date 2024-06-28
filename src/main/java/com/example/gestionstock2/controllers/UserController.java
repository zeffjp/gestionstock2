package com.example.gestionstock2.controllers;

import com.example.gestionstock2.modele.User;
import com.example.gestionstock2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/read")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/read/{id}")
    public Optional<User> getById(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User user) {
        Optional<User> existingUser = userService.getUser(id);
        if (!existingUser.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}
