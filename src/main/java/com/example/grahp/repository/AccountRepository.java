package com.example.grahp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.grahp.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    
}
