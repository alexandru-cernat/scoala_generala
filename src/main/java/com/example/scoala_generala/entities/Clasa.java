package com.example.scoala_generala.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clase")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Clasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numeClasa;

    @OneToMany(mappedBy = "clasa")
    @JsonManagedReference
    private List<Elev> eleviiClasei = new ArrayList<>();


    public void appendEleviiClasei(Elev e) {
        this.eleviiClasei.add(e);
    }
}
