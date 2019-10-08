package com.devweb.sa.sa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "comptes")

public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 15)
    private String formJuri;
    @Column(length = 50)
    private String nomComplet;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String tel;
    @Column(length = 100)
    private String adresse;
    @Column(length = 15)
    private String cni;
    @Column(length = 10)
    private String ninea;
    @Column(length = 10)
    private String denomSocial;
    @Column(length = 50)
    private String localite;
    @Column(length = 10)
    private String activitePrin;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="partenaire")
    @JsonIgnoreProperties("partenaire")
    private List <Compte> comptes;

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormJuri() {
        return formJuri;
    }

    public void setFormJuri(String formJuri) {
        this.formJuri = formJuri;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getDenomSocial() {
        return denomSocial;
    }

    public void setDenomSocial(String denomSocial) {
        this.denomSocial = denomSocial;
    }

    public String getLovalite() {
        return localite;
    }

    public void setLovalite(String lovalite) {
        this.localite = lovalite;
    }

    public String getActivitePrin() {
        return activitePrin;
    }

    public void setActivitePrin(String activitePrin) {
        this.activitePrin = activitePrin;
    }
}
