package com.digi.banksystem.service;
import com.digi.banksystem.exception.BadRequest;
import com.digi.banksystem.exception.NotFoundException;
import com.digi.banksystem.exception.ValidationException;
import com.digi.banksystem.model.User;
import com.digi.banksystem.model.requestdto.UserDTO;
import java.util.List;

public interface UserService {
    void create(UserDTO userDTO);
    User getByEmail(String email);
    void verifyUser(String email,String verifyCode) throws NotFoundException;
    void updateUser(Integer id, UserDTO userDTO) throws BadRequest, NotFoundException;
    void changePassword(String email,String oldPassword,String newPassword,String confirmPassword) throws ValidationException, NotFoundException;
    void getEmail(String email) throws NotFoundException;
    Boolean getToken(String email, String token) throws ValidationException;
    void forgetPassword(String email,String newPassword, String confirmPassword) throws NotFoundException, ValidationException;
    User getUser(int id) throws NotFoundException;
    List<?> getAllUsers();
    List<User> searchUser(String name);
}
