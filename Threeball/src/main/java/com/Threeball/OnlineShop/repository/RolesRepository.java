package com.Threeball.OnlineShop.repository;

import com.Threeball.OnlineShop.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
     Roles getRolesByIdroles(int id);
}

