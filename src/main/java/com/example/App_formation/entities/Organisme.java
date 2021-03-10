package com.example.App_formation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
public class Organisme implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="organisme_id")
    private int id ;
    private String libelle;


    @OneToMany(mappedBy="organisme",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Session> sessions;

    @OneToMany(mappedBy="organisme",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Formateur> formateurs;

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

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Set<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(Set<Formateur> formateurs) {
        this.formateurs = formateurs;
    }
}
