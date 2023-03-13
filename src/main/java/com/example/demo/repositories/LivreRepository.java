package com.example.demo.repositories;

import com.example.demo.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LivreRepository extends JpaRepository<Livre,Long> {

    @Query("SELECT l FROM Livre  l")
    public List<Livre> findAllBooks();

/*
    String GET_books ="SELECT * FROM livre l " +
            "WHERE l.isbn IN (SELECT livre FROM copie WHERE copie.emprunteur = 'D112')";
              @Query(GET_books)
    public  List<Livre> getLivresByEmprunteur(@Param("emprinteur")String emprinteur);*/



    @Query(value = "select l from Livre  as l " +
            "inner join Copie  as c " +
            "On c.livre =l AND c.emprunteur.cin = :cin"
            )
    public List<Livre> getLivresByEmprunteur(@Param("cin") String cin);






}
