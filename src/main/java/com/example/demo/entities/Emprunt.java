package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String DateEmprunt;
    private String dateEcheance;
    private String dateRetour;

    @ManyToOne
    @JoinColumn(name = "emprunteur", referencedColumnName = "cin")
    private Emprunteur emprunteur;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "copie", referencedColumnName = "codeBarre")
    private Copie copie;




}
