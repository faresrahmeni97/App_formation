package com.example.App_formation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Formateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="formateur_id")
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int tel;
    private String type;

    @ManyToOne
    private Organisme organisme;

    @OneToMany
    private Set<Session> sessions;
}
