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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="QRCode")
public class QRCode {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCode")
    @JsonProperty("idCode")
    private int idCode;

    @Column(name="code")
    @JsonProperty("code")
    private int code;
    
    @Column(name="amount")
    @JsonProperty("amount")
    private float amount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;

}
