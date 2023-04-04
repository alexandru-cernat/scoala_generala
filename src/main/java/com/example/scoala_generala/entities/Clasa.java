package com.example.scoala_generala.entities;



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
    private String numeClasa;

    @OneToMany(mappedBy = "clasa")
    @JsonManagedReference
    private List<Elev> eleviiClasei = new ArrayList<>();

    public Clasa(Clasa nouaClasa) {
        this.setNumeClasa(nouaClasa.getNumeClasa());
        this.setEleviiClasei(nouaClasa.getEleviiClasei());
        this.setProfesoriiClasei(nouaClasa.getProfesoriiClasei());
    }



    public void appendEleviiClasei(Elev e) {
        this.eleviiClasei.add(e);
    }

    public void stergeEleviiClasei(Elev e)
    {
        eleviiClasei.remove(e);
    }

    @ManyToMany (mappedBy = "claseleProfesorului")
    private List<Profesor> profesoriiClasei = new ArrayList<>();

    public Clasa(String numeClasa) {
        this.numeClasa = numeClasa;
    }
}
