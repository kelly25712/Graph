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
@Table (name="COntact")
public class Contact {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContact")
    @JsonProperty("idContact")
    private int idContact;

    @Size(min=1, max =30, message="The name of contact must be at most 30 characters")
    @Column(name="name")
    @JsonProperty("name")
    private String name;
    
    @Column(name="noAccount")
    @JsonProperty("noAccount")
    private long noAccount;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount")
    @JsonProperty("idAccount")
    @JsonBackReference
    private Account idAccount;

}
