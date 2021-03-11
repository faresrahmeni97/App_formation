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
    private long id;
    private Date date_deb;
    private Date date_fin;
    private long nbparticipant;
    private String lieu;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "SESSION_FORMATION", joinColumns = {
            @JoinColumn(name = "SESSION_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "FORMATION_ID") })
    private Set<Formation> formations;

    @ManyToOne
    private Organisme organisme;

    @ManyToOne
    private Formateur formateur;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "SESSION_PARTICIPANT", joinColumns = {
            @JoinColumn(name = "SESSION_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "PARTICIPANT_ID") })
    private Set<Participant> participants;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public long getNbparticipant() {
        return nbparticipant;
    }

    public void setNbparticipant(long nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }
}
