package com.example.App_formation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Domaine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="domaine_id")
    private int id ;
    private String libelle;

    @OneToMany(mappedBy="domaine",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Formation> formations;

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

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }
}
