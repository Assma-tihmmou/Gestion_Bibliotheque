package com.example.demo.controllers;

import com.example.demo.entities.Copie;
import com.example.demo.entities.Emprunt;
import com.example.demo.entities.Emprunteur;
import com.example.demo.entities.Livre;
import com.example.demo.repositories.CopieRepository;
import com.example.demo.repositories.EmpruntRepository;
import com.example.demo.repositories.EmprunteurRepository;
import com.example.demo.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    CopieRepository copieRepository;

    @Autowired
    EmpruntRepository empruntRepository;
    @Autowired
    EmprunteurRepository emprunteurRepository;


    @GetMapping("/livres")
    public List<Livre> getAllLivres(){
        return livreRepository.findAll();
    }

    @GetMapping("/livres/{emprinteur_cin}")
        public List<Livre> getAllBookByEmprunteur(@PathVariable String emprinteur_cin ){
      return  livreRepository. getLivresByEmprunteur(emprinteur_cin);
    }

    @GetMapping("/copies/{livre}")
    public List<Copie> getCopiesByLivre(@PathVariable String livre){
        return copieRepository.getCopiesByLivre(livre);
    }

    @GetMapping("/emprunts/{CodeBarre}")
    public List<Emprunt> getEmpruntsEnCoursByCopie(@PathVariable String CodeBarre){
        return empruntRepository.getCopiesEmpruntesByExemplaire(CodeBarre);
    }

    @GetMapping("/emprunteurs/{isbn}")
    List<Emprunteur> getEmprunteursByExemplaire(@PathVariable String isbn){
        return emprunteurRepository.getEmprunteursByLivre(isbn);
    }

    @GetMapping("/copies/emprunts/{livre}")
    List<Copie> getCopiesEmpruntesByLivre(@PathVariable String livre){
        return copieRepository.getCopiesEmpruntesByLivre(livre);
    }




}
