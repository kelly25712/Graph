package com.example.grahp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grahp.model.Contact;

public interface ContactRepository extends JpaRepository <Contact, Integer>{
    
}
