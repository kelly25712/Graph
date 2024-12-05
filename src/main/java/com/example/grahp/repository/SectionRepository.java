package com.example.grahp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grahp.model.Section;
public interface  SectionRepository extends JpaRepository<Section,Integer>{
    
}
