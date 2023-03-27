package com.example.scoala_generala.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

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
    @Email(message = "e-mail invalid")
    private String emailAddress;
    @Pattern(regexp="^\\+?(40|0)?7[0-9]{8}$", message="numar de telefon invalid")
    private String phoneNumber;
    @NotNull(message = "CNP-ul trebuie specificat")
    @NotBlank(message = "CNP-ul este obligatoriu")
    @Size( min = 13, max = 13, message = "CNP-ul trebuie sa fie de 13 cifre")
    private String SSN; //social security number (CNP)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clasa_nume")
    @JsonBackReference
    private Clasa clasa;

}
