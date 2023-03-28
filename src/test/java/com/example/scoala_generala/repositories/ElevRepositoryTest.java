package com.example.scoala_generala.repositories;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest // it spins up the database
class ElevRepositoryTest {


    @Autowired
    private ElevRepository elevRepositoryTest;
    @Autowired
    private ClasaRepository clasaRepositoryTest;


    @Test
    void itShouldfindBySSN() {
        //given
        Clasa clasa = new Clasa("5A");


        clasaRepositoryTest.save(clasa);
        Elev elev = new Elev(
                "Mihai",
                "Popescu",
                "Bucuresti",
                "mihai.popescu@gmail.com",
                "0767001145",
                "1111111111111",
                clasa);
        elevRepositoryTest.save(elev);
        //when
        Optional<Elev> elevCautat = elevRepositoryTest.findBySSN("1111111111111");
        //then
        assertTrue(elevCautat.isPresent());
        assertEquals(elev.getSSN(),elevCautat.get().getSSN());
        assertEquals(elev.getClasa().getNumeClasa(),elevCautat.get().getClasa().getNumeClasa());
        assertEquals(elev.getLastName(),elevCautat.get().getLastName());
        assertEquals(elev.getFirstName(),elevCautat.get().getFirstName());
        assertEquals(elev.getPhoneNumber(),elevCautat.get().getPhoneNumber());
        assertEquals(elev.getEmailAddress(),elevCautat.get().getEmailAddress());
        assertEquals(elev.getAddress(),elevCautat.get().getAddress());

    }


    @Test
    void findById() {
        //given
        Clasa clasa = new Clasa("5A");


        clasaRepositoryTest.save(clasa);
        Elev elev = new Elev(
                "Mihai",
                "Popescu",
                "Bucuresti",
                "mihai.popescu@gmail.com",
                "0767001145",
                "1111111111111",
                clasa);
        elevRepositoryTest.save(elev);
        //when
        Optional<Elev> elevCautat = elevRepositoryTest.findById(1);
        //then
        assertTrue(elevCautat.isPresent());
        assertEquals(elev.getSSN(),elevCautat.get().getSSN());
        assertEquals(elev.getClasa().getNumeClasa(),elevCautat.get().getClasa().getNumeClasa());
        assertEquals(elev.getLastName(),elevCautat.get().getLastName());
        assertEquals(elev.getFirstName(),elevCautat.get().getFirstName());
        assertEquals(elev.getPhoneNumber(),elevCautat.get().getPhoneNumber());
        assertEquals(elev.getEmailAddress(),elevCautat.get().getEmailAddress());
        assertEquals(elev.getAddress(),elevCautat.get().getAddress());

    }

    @Disabled
    @Test
    void findByEmailAddress() {
        //given
        Clasa clasa = new Clasa("5A");


        clasaRepositoryTest.save(clasa);
        Elev elev = new Elev(
                "Mihai",
                "Popescu",
                "Bucuresti",
                "mihai.popescu@gmail.com",
                "0767001145",
                "1111111111111",
                clasa);
        elevRepositoryTest.save(elev);
        //when
        Optional<Elev> elevCautat = elevRepositoryTest.findByEmailAddress("mihai.popescu@gmail.com");
        //then
        assertTrue(elevCautat.isPresent());
        assertEquals(elev.getSSN(),elevCautat.get().getSSN());
        assertEquals(elev.getClasa().getNumeClasa(),elevCautat.get().getClasa().getNumeClasa());
        assertEquals(elev.getLastName(),elevCautat.get().getLastName());
        assertEquals(elev.getFirstName(),elevCautat.get().getFirstName());
        assertEquals(elev.getPhoneNumber(),elevCautat.get().getPhoneNumber());
        assertEquals(elev.getEmailAddress(),elevCautat.get().getEmailAddress());
        assertEquals(elev.getAddress(),elevCautat.get().getAddress());

    }

    @Disabled
    @Test
    void findByPhoneNumber() {
        //given
        Clasa clasa = new Clasa("5A");


        clasaRepositoryTest.save(clasa);
        Elev elev = new Elev(
                "Mihai",
                "Popescu",
                "Bucuresti",
                "mihai.popescu@gmail.com",
                "0767001145",
                "1111111111111",
                clasa);
        elevRepositoryTest.save(elev);
        //when
        Optional<Elev> elevCautat = elevRepositoryTest.findByPhoneNumber("0767001145");
        //then
        assertTrue(elevCautat.isPresent());
        assertEquals(elev.getSSN(),elevCautat.get().getSSN());
        assertEquals(elev.getClasa().getNumeClasa(),elevCautat.get().getClasa().getNumeClasa());
        assertEquals(elev.getLastName(),elevCautat.get().getLastName());
        assertEquals(elev.getFirstName(),elevCautat.get().getFirstName());
        assertEquals(elev.getPhoneNumber(),elevCautat.get().getPhoneNumber());
        assertEquals(elev.getEmailAddress(),elevCautat.get().getEmailAddress());
        assertEquals(elev.getAddress(),elevCautat.get().getAddress());

    }
}