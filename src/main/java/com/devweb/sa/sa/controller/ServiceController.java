package com.devweb.sa.sa.controller;

import com.devweb.sa.sa.model.*;
import com.devweb.sa.sa.repository.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class ServiceController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public User add(@RequestBody(required = false) User u){
        u.setStatus("Actif");
        u.setPassword(encoder.encode(u.getPassword()));
        return userRepository.save(u);
    }
    @Autowired
    PartenaireRepository partenaireRepository;
    @PostMapping(value = "/add/partenaire",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public Partenaire add(@RequestBody(required = false) Partenaire p){
        return partenaireRepository.save(p);
    }
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    DepotRepository depotRepository;
    @Autowired
    private UserRepository userRepositoryL;
    @Autowired
    private PartenaireRepository partenaireRepositoryL;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(value = "/add/compte",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public Compte add(@RequestBody(required = false) Compte c){
        DateFormat formate = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String compt = ""+formate.format(date);
        c.setNumCompte(compt);
        return compteRepository.save(c);
    }

    @PostMapping(value = "/depot",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_CAISSIER')")
    public Depot add(@RequestBody(required = false)DepotForm depotForm){
        //Instancier un objet de type depot
        Depot depot = new Depot();
        //recupperer le montant dans depotForm
        Long montant = depotForm.getMontant();
        //transferer le montant dans depot
        depot.setMontant(montant);
        //appeler la fonction depuis le repository
        Compte compte = compteRepository.findCompteByNumCompte(depotForm.getCompte());
        //augmentation du solde dans compte
        compte.setSolde(compte.getSolde()+depot.getMontant());
        depot.setCompte(compte);
        //pour gerer la dates
        Date datedepot = new Date();
        depot.setDate(datedepot);
        compteRepository.save(compte);
        return depotRepository.save(depot);
        //return depotRepository.save();
    }
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public List<User> liste(){
        return userRepository.findAll();
    }
    @GetMapping(value = "/liste/partenaires")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public List<Partenaire> liste1(){
        return partenaireRepositoryL.findAll();
    }
    @GetMapping(value = "/liste/roles")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public List<Role> liste2(){
        return roleRepository.findAll();
    }
}
