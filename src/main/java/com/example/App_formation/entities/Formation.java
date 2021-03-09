package com.example.App_formation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="formation_id")
    private int id;
    private String titre;
    private String type_formation;
    private int nbSession;
    private int duree;
    private int budget;

    @ManyToOne
    private Domaine domaine;

    @ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "FORMATION_SESSION", joinColumns = {
            @JoinColumn(name = "FORMATION_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SESSION_ID") })
    @JsonIgnore
    private Set<Session> sessions;


}
