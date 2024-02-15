package com.Threeball.OnlineShop.model.requestDTO;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String surname;
    private int year;
    private String email;
    private String password;
}
