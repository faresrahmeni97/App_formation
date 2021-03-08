package com.example.App_formation.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Profil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profil_id")
    private int id;
    private String libelle;


    @OneToMany
    private Set<Participant> participants;
}
