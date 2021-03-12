package com.example.App_formation.controller;

import com.example.App_formation.entities.Domaine;
import com.example.App_formation.repository.DomaineRepository;
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
public class DomaineController {
    private static final Logger logger = LogManager.getLogger(DomaineController.class);
    @Autowired
    DomaineRepository domaineRep;

    @GetMapping("/domaines")
    public List<Domaine> getAllDomaines() {
        List<Domaine> domainess = domaineRep.findAll();
        return domainess;
    }

    @GetMapping("/domaine/{id}")
    public Domaine getDomaineById(@PathVariable(value = "id") Long Id) {
        return domaineRep.findById(Id).orElseThrow(null);
    }

    @PostMapping("/adddomaine")
    public Domaine createDomaine(@Valid @RequestBody Domaine domaine) {
        return domaineRep.save(domaine);
    }

    @DeleteMapping("/deletedomaine/{id}")
    public ResponseEntity<?> deleteDomaine(@PathVariable(value = "id") Long domaineId) {
        Domaine domaine = domaineRep.findById(domaineId).orElseThrow(null);
        domaineRep.delete(domaine);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatedomaine/{id}")
    public Domaine updateDomaine(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Domaine domaineUpdated) {

        Domaine domaine = domaineRep.findById(id).orElseThrow(null);
        domaine.setLibelle(domaineUpdated.getLibelle());
        Domaine updatedDomaine = domaineRep.save(domaine);
        return updatedDomaine;
    }
}