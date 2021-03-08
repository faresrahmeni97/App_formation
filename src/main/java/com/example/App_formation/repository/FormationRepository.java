package com.example.App_formation.repository;

import com.example.App_formation.entities.Formation;
import com.example.App_formation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface FormationRepository extends JpaRepository<Formation,Long> {}
