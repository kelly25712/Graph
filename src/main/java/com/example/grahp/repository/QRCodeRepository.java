package com.example.grahp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grahp.model.QRCode;

public interface QRCodeRepository extends  JpaRepository <QRCode,Integer>{
    
}
