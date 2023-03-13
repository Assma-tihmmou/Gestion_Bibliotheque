package com.example.demo.repositories;

import com.example.demo.entities.Copie;
import com.example.demo.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmpruntRepository extends JpaRepository<Emprunt,Integer> {

    @Query(value = "select e from Emprunt  as e " +
            "where e.dateRetour is null  " +
            "And e.copie.codeBarre = :codeBarre"
    )
    List<Emprunt> getCopiesEmpruntesByExemplaire(@Param("codeBarre") String codeBarre);

}
