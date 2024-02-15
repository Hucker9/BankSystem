package com.Threeball.OnlineShop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idroles")
  private int idroles;
  @Column(name = "role_name")
  private String rolesName;
}
