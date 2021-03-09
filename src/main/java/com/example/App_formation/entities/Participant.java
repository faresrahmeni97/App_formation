package com.example.App_formation.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Participant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="participant_id")
    private int id;
    private String nom;
    private String prenom;
    private int tel ;
    private String mail;
    @ManyToOne
    private Profil profil;

    @ManyToMany
    @JoinTable(name = "PARTICIPANT_SESSSIONS", joinColumns = {
            @JoinColumn(name = "PARTICIPANT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SESSION_ID") })
    private Set<Session> sessions;

    @ManyToOne
    private Pays pays;


}
