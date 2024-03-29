package com.example.scoala_generala.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.*;

@Entity
@Table(name="elevi")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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

    public Elev(String firstName, String lastName, String address, String emailAddress, String phoneNumber, String SSN, Clasa clasa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.SSN = SSN;
        this.clasa = clasa;
    }
}
