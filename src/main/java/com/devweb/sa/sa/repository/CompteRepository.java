package com.devweb.sa.sa.repository;

import com.devweb.sa.sa.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Compte findCompteByNumCompte(String numCompte);
}