package com.example.App_formation.controller;

import com.example.App_formation.entities.Formateur;
import com.example.App_formation.repository.FormateurRepository;
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
public class FormateurController {
    private static final Logger logger = LogManager.getLogger(FormateurController.class);
    @Autowired
    FormateurRepository formateurRep;

    @GetMapping("/formateurs")
    @JsonIgnore
    public List<Formateur> getAllFormateurs() {
        List<Formateur> formateurss = formateurRep.findAll();
        return formateurss;
    }

    @GetMapping("/formateur/{id}")
    @JsonIgnore
    public Formateur getFormateurById(@PathVariable(value = "id") Long Id) {
        return formateurRep.findById(Id).orElseThrow(null);
    }

    @PostMapping("/addformateur")
    public Formateur createFormateur(@Valid @RequestBody Formateur formateur) {
        return formateurRep.save(formateur);
    }

    @DeleteMapping("/deleteformateur/{id}")
    public ResponseEntity<?> deleteFormateur(@PathVariable(value = "id") Long formateurId) {
        Formateur formateur = formateurRep.findById(formateurId).orElseThrow(null);
        formateurRep.delete(formateur);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateformateur/{id}")
    public Formateur updateFormateur(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Formateur formateurUpdated) {

        Formateur formateur = formateurRep.findById(id).orElseThrow(null);
        formateur.setEmail(formateurUpdated.getEmail());
        formateur.setNom(formateurUpdated.getNom());
        formateur.setPrenom(formateurUpdated.getPrenom());
        formateur.setTel(formateurUpdated.getTel());
        formateur.setType(formateurUpdated.getType());
        formateur.setSessions(formateurUpdated.getSessions());
        formateur.setOrganisme(formateurUpdated.getOrganisme());
        Formateur updatedFormateur = formateurRep.save(formateur);
        return updatedFormateur;
    }
}