package com.devweb.sa.sa.repository;

import com.devweb.sa.sa.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    static void findPartenaireById(Long id) {
    }
}