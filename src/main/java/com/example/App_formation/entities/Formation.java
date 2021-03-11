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
    private long id;
    private String titre;
    private String type_formation;
    private int nbSession;
    private int duree;
    private int budget;

    @ManyToOne
    private Domaine domaine;

    /*@ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "FORMATION_SESSION", joinColumns = {
            @JoinColumn(name = "FORMATION_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SESSION_ID") })
    @JsonIgnore
    private Set<Session> sessions;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType_formation() {
        return type_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public int getNbSession() {
        return nbSession;
    }

    public void setNbSession(int nbSession) {
        this.nbSession = nbSession;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
}
