package com.digi.banksystem.repository;

import com.digi.banksystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);
    @Query(nativeQuery = true, value = "select * from user where id = ?")
    User getById(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM user where if (?1 is not null, lower(first_name) like concat(lower (?1), '%'), true)")
    List<User> searchUser(String name);

}
