package com.example.App_formation.controller;

import com.example.App_formation.entities.Session;
import com.example.App_formation.entities.Session;
import com.example.App_formation.repository.SessionRepository;
import com.example.App_formation.repository.SessionRepository;
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
public class SessionController {
    private static final Logger logger = LogManager.getLogger(SessionController.class);
    @Autowired
    SessionRepository sessionRep;

    @GetMapping("/sessions")
    public List<Session> getAllSessions() {
        List<Session> sessionss = sessionRep.findAll();
        return sessionss;
    }
    @GetMapping("/session/{id}")
    public Session getSessionById(@PathVariable(value = "id") Long Id) {
        return sessionRep.findById(Id).orElseThrow(null);
    }

    @PostMapping("/addsession")
    public Session createSession(@Valid @RequestBody Session session) {
        return sessionRep.save(session);
    }
    @DeleteMapping("/deletesession/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable(value = "id") Long sessionId) {
        Session session = sessionRep.findById(sessionId).orElseThrow(null);
        sessionRep.delete(session);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/updatesession/{id}")
    public Session updateSession(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody Session sessionUpdated) {

        //--- sans associations ---//
        Session session = sessionRep.findById(id).orElseThrow(null);
        session.setDate_deb(sessionUpdated.getDate_deb());
        session.setDate_fin(sessionUpdated.getDate_fin());
        session.setLieu(sessionUpdated.getLieu());
        session.setNbparticipant(sessionUpdated.getNbparticipant());
        //----- avec associations -----//
        session.setFormateur(sessionUpdated.getFormateur());
        session.setOrganisme(sessionUpdated.getOrganisme());
        session.setParticipants(sessionUpdated.getParticipants());
        session.setFormations(sessionUpdated.getFormations());

        Session updatedSession = sessionRep.save(session);
        return updatedSession;
    }
}