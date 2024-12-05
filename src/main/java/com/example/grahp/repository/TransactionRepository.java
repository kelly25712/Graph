package com.example.grahp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grahp.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}