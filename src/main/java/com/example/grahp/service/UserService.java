package com.example.grahp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grahp.model.User;
import com.example.grahp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Integer idUser) {
        // Devuelve el usuario con el ID especificado
        return userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + idUser));
    }
}
