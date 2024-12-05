package com.example.grahp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grahp.model.User;
public interface  UserRepository extends JpaRepository<User, Integer>{
    
}
