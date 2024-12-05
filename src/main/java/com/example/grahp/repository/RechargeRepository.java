package com.example.grahp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grahp.model.Recharge;
public interface  RechargeRepository extends JpaRepository<Recharge, Integer> {
    
}
