package com.example.demo.repositories;

import com.example.demo.entities.Copie;
import com.example.demo.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CopieRepository extends JpaRepository<Copie,String>{

    @Query(value = "select c from Copie  as c " +
            "inner join Livre  as l On c.livre.isbn = :isbn"
    )
    List<Copie> getCopiesByLivre(@Param("isbn") String isbn);


    @Query(value = "select c from Copie  as c " +
            "where c.statutDeDisponibilite =\"emprunte\"" +
            "and c.livre.isbn=:isbn"
    )
    List<Copie> getCopiesEmpruntesByLivre(@Param("isbn") String isbn);






}
