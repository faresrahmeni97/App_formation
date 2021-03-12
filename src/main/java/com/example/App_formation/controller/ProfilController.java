package com.example.App_formation.controller;

import com.example.App_formation.entities.Profil;
import com.example.App_formation.repository.ProfilRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfilController {
    private static final Logger logger = LogManager.getLogger(ProfilController.class);
    @Autowired
    ProfilRepository profilRep;

    @GetMapping("/profils")
    public List<Profil> getAllProfils() {
        List<Profil> profilss = profilRep.findAll();
        return profilss;
    }

    @GetMapping("/profil/{id}")
    public Profil getProfilById(@PathVariable(value = "id") Long Id) {
        return profilRep.findById(Id).orElseThrow(null);
    }

    @PostMapping("/addprofil")
    public Profil createProfil(@Valid @RequestBody Profil profil) {
        return profilRep.save(profil);
    }

    @DeleteMapping("/deleteprofil/{id}")
    public ResponseEntity<?> deleteProfil(@PathVariable(value = "id") Long profilId) {
        Profil profil = profilRep.findById(profilId).orElseThrow(null);
        profilRep.delete(profil);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateprofil/{id}")
    public Profil updateProfil(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Profil profilUpdated) {

        Profil profil = profilRep.findById(id).orElseThrow(null);
        profil.setLibelle(profilUpdated.getLibelle());
        Profil updatedProfil = profilRep.save(profil);
        return updatedProfil;
    }
}