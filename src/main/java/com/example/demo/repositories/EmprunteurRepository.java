package com.example.demo.repositories;

import com.example.demo.entities.Emprunt;
import com.example.demo.entities.Emprunteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmprunteurRepository  extends JpaRepository<Emprunteur,String> {

    @Query(value = "select e from Emprunteur  as e " +
            "inner join Emprunt as em on e.cin = em.emprunteur.cin " +
            "And em.copie in (select c from Copie as c " +
            "where c.livre.isbn = :isbn)"
    )

    List<Emprunteur> getEmprunteursByLivre(@Param("isbn") String isbn);
}
