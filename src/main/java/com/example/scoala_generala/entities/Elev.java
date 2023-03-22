package com.example.scoala_generala.entities;

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
    private String SSN; //social security number (CNP)

    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String phoneNumber;

//    // chiar daca am folosit lombok, am generat constructorul asta pentru ca vreau sa fie fara SSN
//    public Elev(String firstName, String lastName, String address, String emailAddress, String phoneNumber) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.emailAddress = emailAddress;
//        this.phoneNumber = phoneNumber;
//    }
}
