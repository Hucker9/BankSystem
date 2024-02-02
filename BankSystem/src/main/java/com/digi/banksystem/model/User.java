package com.digi.banksystem.model;

import com.digi.banksystem.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    @NotBlank()
    private String name;
    @Column(name = "last_name")
    @NotBlank
    private String surname;
    private int year;
    @Email
    private String email;
    @NotBlank
    private String password;
    @Column(name = "verificatione_code")
    private String verify;
    @Enumerated(value = EnumType.ORDINAL)
    private Status status;
    @Column(name = "reset_token")
    private String reset_token;
}