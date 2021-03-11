package com.example.App_formation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Formateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="formateur_id")
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private int tel;
    private String type;

    @ManyToOne
    @JsonIgnore
    private Organisme organisme;

    @OneToMany(mappedBy="formateur",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Session> sessions;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }
}
