package com.example.App_formation.controller;

import com.example.App_formation.entities.Participant;
import com.example.App_formation.repository.ParticipantRepository;
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
public class ParticipantController {
    private static final Logger logger = LogManager.getLogger(ParticipantController.class);
    @Autowired
    ParticipantRepository participantRep;

    @GetMapping("/participants")
    public List<Participant> getAllParticipants() {
        List<Participant> participantss = participantRep.findAll();
        return participantss;
    }

    @GetMapping("/participant/{id}")
    public Participant getParticipantById(@PathVariable(value = "id") Long Id) {
        return participantRep.findById(Id).orElseThrow(null);
    }

    @PostMapping("/addparticipant")
    public Participant createParticipant(@Valid @RequestBody Participant participant) {
        return participantRep.save(participant);
    }

    @DeleteMapping("/deleteparticipant/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable(value = "id") Long participantId) {
        Participant participant = participantRep.findById(participantId).orElseThrow(null);
        participantRep.delete(participant);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateparticipant/{id}")
    public Participant updateParticipant(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Participant participantUpdated) {

        Participant participant = participantRep.findById(id).orElseThrow(null);
        participant.setMail(participantUpdated.getMail());
        participant.setPays(participantUpdated.getPays());
        participant.setNom(participantUpdated.getNom());
        participant.setPrenom(participantUpdated.getPrenom());
        participant.setTel(participantUpdated.getTel());
        participant.setProfil(participantUpdated.getProfil());
        Participant updatedParticipant = participantRep.save(participant);
        return updatedParticipant;
    }
}
