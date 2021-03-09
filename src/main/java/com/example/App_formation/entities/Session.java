package com.example.App_formation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Session implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="session_id")
    private int id;
    private Date date_deb;
    private Date date_fin;
    private int nbparticipant;
    private String lieu;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "SESSION_FORMATION", joinColumns = {
            @JoinColumn(name = "SESSION_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "FORMATION_ID") })
    @JsonIgnore
    private Set<Formation> formations;

    @ManyToOne
    private Organisme organisme;

    @ManyToOne
    private Formateur formateur;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "SESSION_PARTICIPANT", joinColumns = {
            @JoinColumn(name = "SESSION_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "PARTICIPANT_ID") })
    @JsonIgnore
    private Set<Participant> participants;
}
