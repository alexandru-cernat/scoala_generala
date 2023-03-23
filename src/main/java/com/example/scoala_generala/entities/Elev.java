package com.example.scoala_generala.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="elevi")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Elev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String phoneNumber;
    private String SSN; //social security number (CNP)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clasa_id")
    @JsonBackReference
    private Clasa clasa;

}
