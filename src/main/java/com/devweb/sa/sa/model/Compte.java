package com.devweb.sa.sa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "partenaire")

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 15)
    private String numCompte;
    @Column(length = 30)
    private Long solde;

    @JoinColumn(name = "partenaire_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("comptes")
    //@JsonManagedReference
    private Partenaire partenaire;

    public Compte(String numCompte, Long solde, Partenaire partenaire) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.partenaire = partenaire;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="compte")
    @JsonIgnoreProperties("compte")
    private List<Depot> depots;

    public Compte() {
        this.setSolde(solde);
    }


    public List<Depot> getDepots() {
        return depots;
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Long getSolde() {
        return solde;
    }

    public void setSolde(Long montant) {
        this.solde = montant;
    }

}
