package com.example.App_formation.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pays implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pays_id")
    private int id;
    private String libelle;

}
