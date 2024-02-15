package com.Threeball.OnlineShop.entities;
import com.Threeball.OnlineShop.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusers;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "year")
    private int year;
    @Email
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "verify")
    private String verify;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
    @Column(name = "reset_token")
    private String resetToken;
    @OneToOne
    @JoinColumn(name = "rolesid", referencedColumnName = "idroles")
    private Roles roles;
}
