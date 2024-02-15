package com.Threeball.OnlineShop.controller;

import com.Threeball.OnlineShop.model.requestDTO.LoginRequest;
import com.Threeball.OnlineShop.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class AuthenticationController {

    @Autowired
    private TokenService service;

    @PostMapping("/token")
    public String getToken(@RequestBody LoginRequest request) {
        return service.getToken(request);
    }
}
