package com.Threeball.OnlineShop.service.impl;

import com.Threeball.OnlineShop.config.JwtUtil;
import com.Threeball.OnlineShop.entities.User;
import com.Threeball.OnlineShop.model.requestDTO.LoginRequest;
import com.Threeball.OnlineShop.repository.UserRepository;
import com.Threeball.OnlineShop.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository repository;

    @Override
    public String getToken(LoginRequest loginRequest) {
        String token = null;
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            String email = authentication.getName();
            User userByEmail = repository.getByEmail(email);
            token = jwtUtil.createToken(userByEmail);

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while getting token");
        }
        return token;
    }
}
