package com.Threeball.OnlineShop.controller;
import com.Threeball.OnlineShop.model.requestDTO.UserRequestDTO;
import com.Threeball.OnlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ThreeBall")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String Hello() {
        return "hello";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO){
        userService.Create(userRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/main")
    public String Main() {
        return "main";
    }

    @GetMapping("/login")
    public String rLogin() {
        return "login";
    }

    //@PostMapping("/rLogin")
    //public ResponseEntity<?> login(@RequestParam String email) {
        //customUserDetails.loadUserByUsername(email);
       // return new ResponseEntity<>(HttpStatus.OK);
  // }
}
