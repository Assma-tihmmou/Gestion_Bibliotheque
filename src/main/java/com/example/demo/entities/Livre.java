package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn;
    @Column(length = 200)
    private String titre;
    @Column(length = 200)
    private String auteur;
    private  int AnneePublication;
    @OneToMany(mappedBy="codeBarre",fetch = FetchType.LAZY)
    private List<Copie> copies;




}
