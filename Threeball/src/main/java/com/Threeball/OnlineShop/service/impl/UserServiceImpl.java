package com.Threeball.OnlineShop.service.impl;

import com.Threeball.OnlineShop.entities.Roles;
import com.Threeball.OnlineShop.entities.User;
import com.Threeball.OnlineShop.model.enums.Status;
import com.Threeball.OnlineShop.model.requestDTO.UserRequestDTO;
import com.Threeball.OnlineShop.repository.RolesRepository;
import com.Threeball.OnlineShop.repository.UserRepository;
import com.Threeball.OnlineShop.service.UserService;
import com.Threeball.OnlineShop.util.Encoder;
import com.Threeball.OnlineShop.util.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Encoder encoder;
    @Autowired
    private RolesRepository roleRepository;


    @Override
    public void Create(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setIdusers(0);
        user.setName(userRequestDTO.getName());
        user.setSurname(userRequestDTO.getSurname());
        user.setYear(userRequestDTO.getYear());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(encoder.encode(userRequestDTO.getPassword()));
        String verifyCode = GenerateToken.generateVerifyCode();
        user.setVerify(verifyCode);
        user.setStatus(Status.IN_ACTIVE);
        user.setRoles(roleRepository.getRolesByIdroles(1));
        userRepository.save(user);
    }
    @Override
    public void verifyUser(String email, String Code) {
        User user = userRepository.getByEmail(email);
        if (user.getVerify().equals(Code)) {
            user.setStatus(Status.ACTIVE);
            user.setVerify(null);
            userRepository.save(user);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.getByEmail(email);
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.getById(id);
        return user;
    }
}
