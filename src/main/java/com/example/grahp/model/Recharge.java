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
@Table (name="Recharge")
public class Recharge {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRecharge")
    @JsonProperty("idRecharge")
    private int idRecharge;

    @Size(min=1, max =50, message="The name of company must be at most 50 characters")
    @Column(name="company")
    @JsonProperty("company")
    private String company;
    
    @Column(name="amount")
    @JsonProperty("amount")
    private float amount;
    
    @Column(name="number")
    @JsonProperty("number")
    private long number;    

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;


}
