package com.devweb.sa.sa.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min=2, max = 50)
    private String nom;
    @NotBlank
    @Size(min=3, max = 100)
    private String username;
    @NaturalId
    @NotBlank
    @Size(max = 100)
    @Email
    private String email;
    @NotBlank
    @Size(min=5, max = 100)
    private String password;
    @NotBlank
    @Size(min=6, max = 100)
    private String cni;
    @NotBlank
    @Size(min=6, max = 15)
    private String telephone;
    @NotBlank
    @Size(min=6, max = 50)
    private String prenom;
    @NotBlank
    @Size(min=6, max = 50)
    private String adresse;
    private String status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(@NotBlank @Size(min = 3, max = 50) String nom, @NotBlank @Size(min = 3, max = 100) String username, @NotBlank @Size(max = 100) @Email String email, @NotBlank @Size(min = 6, max = 100) String password, @NotBlank @Size(min = 6, max = 100) String cni, @NotBlank @Size(min = 6, max = 15) String telephone, @NotBlank @Size(min = 6, max = 50) String prenom, @NotBlank @Size(min = 6, max = 50) String adresse, String status) {
        this.nom = nom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cni = cni;
        this.telephone = telephone;
        this.prenom = prenom;
        this.adresse = adresse;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}