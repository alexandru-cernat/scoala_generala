package com.example.scoala_generala.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="profesori")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profesor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String firstName;
    private String lastName;
    @Pattern(regexp="^\\+?(40|0)?7[0-9]{8}$", message="numar de telefon invalid")
    private String phoneNumber;
    @Email(message = "email invalid")
    private String emailAddress;
    private String specialty;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="profesor_preda_la_clasa",
            joinColumns=@JoinColumn(name="profesor_id"),
            inverseJoinColumns=@JoinColumn(name="clasa_id"))
    @JsonBackReference
    private List<Clasa> claseleProfesorului = new ArrayList<>();

    public Profesor(String firstName, String lastName, String phoneNumber, String emailAddress, String specialty, List<Clasa> claseleProfesorului) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.specialty = specialty;
        this.claseleProfesorului = claseleProfesorului;
    }

    public Profesor(String firstName, String lastName, String phoneNumber, String emailAddress, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.specialty = specialty;;
    }
}

