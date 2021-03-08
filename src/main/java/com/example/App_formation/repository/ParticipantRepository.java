package com.example.App_formation.repository;

import com.example.App_formation.entities.Domaine;
import com.example.App_formation.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {}
