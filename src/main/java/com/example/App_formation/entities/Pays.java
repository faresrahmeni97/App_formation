package com.example.App_formation.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Pays implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pays_id")
    private int id;
    private String libelle;

    @OneToMany(mappedBy="pays",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Participant> participants;
}
