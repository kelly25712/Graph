package com.example.grahp.model;

import java.sql.Time;
import java.util.Date;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="RetreatCL")
public class RetreatCL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRetreatCL")
    @JsonProperty("idRetreatCL")
    private Integer idRetreatCL;
    

    @Column(name = "date")
    @JsonProperty("date")
    private String date;

    @Column(name = "amount")
    @JsonProperty("amount")
    private float amount;

    @Column(name = "time")
    @JsonProperty("time")
    private String time;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;
}
