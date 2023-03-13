package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Emprunteur {
    @Id
    @Column(name = "cin", nullable = false)
    private String cin;
    @JsonIgnore
    @OneToMany(mappedBy = "emprunteur",fetch = FetchType.LAZY)
    private List<Emprunt> emprunts;
    @JsonIgnore
    @OneToMany(mappedBy = "emprunteur",fetch = FetchType.LAZY)
    private List<Copie> copies;



}
