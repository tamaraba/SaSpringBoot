package com.devweb.sa.sa.repository;

import com.devweb.sa.sa.model.Compte;
import com.devweb.sa.sa.model.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {
}