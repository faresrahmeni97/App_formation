package com.example.App_formation.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Participant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="participant_id")
    private long id;
    private String nom;
    private String prenom;
    private long tel ;
    private String mail;
    @ManyToOne

    private Profil profil;

    /*@ManyToMany
    @JoinTable(name = "PARTICIPANT_SESSSIONS", joinColumns = {
            @JoinColumn(name = "PARTICIPANT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SESSION_ID") })
    private Set<Session> sessions;*/

    @ManyToOne
    private Pays pays;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
