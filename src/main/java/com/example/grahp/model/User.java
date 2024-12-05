package com.example.grahp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="User")
public class User {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    @JsonProperty("idUser")
    private int idUser;

    @Column(name="name")
    @Size(min=2,max=45,message="The name must be at most 45 characters")
    @JsonProperty("name")
    private String name;

    @Column(name="dateOfBirth")
    @Size(min=2,max=35,message="The date of birth must be at most 35 characters")
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

    @Column(name="address")
    @Size(min=2,max=50,message="The addres must be at most 50 characters")
    @JsonProperty("address")
    private String address;
}
