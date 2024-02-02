package com.digi.banksystem.controller;

import com.digi.banksystem.exception.BadRequest;
import com.digi.banksystem.exception.NotFoundException;
import com.digi.banksystem.exception.ValidationException;
import com.digi.banksystem.model.User;
import com.digi.banksystem.model.requestdto.UserDTO;
import com.digi.banksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        service.create(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping("/verify")
    public ResponseEntity<?>verifyUser(@RequestParam String email,@RequestParam String verify) throws NotFoundException {
        service.verifyUser(email,verify);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/change")
    public ResponseEntity<?>updateUser(@RequestParam Integer id,@RequestBody UserDTO userDTO) throws BadRequest, NotFoundException {
        service.updateUser(id,userDTO);
        return  ResponseEntity.ok().build();
    }
    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam String oldPassword,@RequestParam String newPassword,@RequestParam String confirmPassword, Principal principal) throws ValidationException, NotFoundException {
        String email = principal.getName();
        service.changePassword(email, oldPassword, newPassword, confirmPassword);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-email")
    public ResponseEntity<?>getEmail(@RequestParam String email) throws NotFoundException {
        service.getEmail(email);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-token")
    public ResponseEntity<?>getToken(@RequestParam String email,@RequestParam String token) throws ValidationException {
        Boolean token1 = service.getToken(email, token);
        return ResponseEntity.ok(token1);
    }
    @PatchMapping("/forget-password")
    public ResponseEntity<?>forgetPassword(@RequestParam String email,@RequestParam String newPassword,@RequestParam String confirmPassword) throws ValidationException, NotFoundException {
        service.forgetPassword(email,newPassword,confirmPassword);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getUserById(@RequestParam int id) throws NotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam String name) {
        List<User> users = service.searchUser(name);
        return ResponseEntity.ok(users);
    }
}