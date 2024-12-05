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
@Table (name="Transaction")
public class Transaction {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTransaction")
    @JsonProperty("idTransaction")
    private int idTransaction;

    @Column(name="type")
    @JsonProperty("type")
    private char type;
    
    @Column(name="date")
    @Size(min=1, max=25)
    @JsonProperty("date")
    private String date;
    
    @Column(name="time")
    @Size(min=1, max=25)
    @JsonProperty("time")
    
    private String time;
    @Column(name="amount")
    @JsonProperty("amount")
    
    private double amount;
    @Column(name="concept")
    @Size(min=1, max=50, message="The concept must be at most 50 characters")
    @JsonProperty("concept")
    
    private String concept;
    @Column(name="destinationAccount")
    @JsonProperty("destinationAccount")
    private long destinationAccount;
    
    @Column(name="sourceAccount")
    @JsonProperty("sourceAccount")
    private long sourceAccount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;

    
}
