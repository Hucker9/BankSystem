package com.Threeball.OnlineShop.service;

import com.Threeball.OnlineShop.entities.User;
import com.Threeball.OnlineShop.model.requestDTO.UserRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void verifyUser(String email, String Code);
    void Create(UserRequestDTO userRequestDTO);
    User getUserByEmail(String email);
    User getUserById(int id);
}
