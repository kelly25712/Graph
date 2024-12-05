package com.example.grahp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="Account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAccount")
    @JsonProperty("idAccount")
    @JsonManagedReference
    private Integer idAccount;

    @Column(name = "accountNumber")
    @JsonProperty("accountNumber")
    private Float accountNumber;

    @Column(name = "balance")
    @JsonProperty("balance")
    private Double balance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idUser")
    @JsonProperty("idUser")
    @JsonBackReference

    private User idUser;

    @Column(name = "pointBBVA")
    @JsonProperty("pointBBVA")
    public Integer pointBBVA;

    @Column(name = "keyAccount")
    @JsonProperty("keyAccount")
    private Integer keyAccount;
}