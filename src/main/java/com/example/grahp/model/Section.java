package com.example.grahp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="Sections")
public class Section {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSections")
    @JsonProperty("idSections")
    private int idSections;
    
    @Size(min=1, max =100, message="The name of contact must be at most 30 characters")
    @Column(name="name")
    @JsonProperty("name")
    private String name;
    
    @Column(name = "amount")
    @JsonProperty("amount")
    private Double amount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;


}
