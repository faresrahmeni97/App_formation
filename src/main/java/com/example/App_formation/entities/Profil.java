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


    @OneToMany(mappedBy="profil",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Participant> participants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }
}
