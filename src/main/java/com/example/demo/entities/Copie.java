package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Copie {
    @Id
    private String codeBarre;
    @Column(length = 200)
    private String etat;
    private String statutDeDisponibilite;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "livre", referencedColumnName = "isbn")
    private Livre livre;

    @OneToMany(mappedBy = "copie")
    private List<Emprunt> emprunts;
    @ManyToOne
    @JoinColumn(name = "emprunteur")
    Emprunteur emprunteur;

}
