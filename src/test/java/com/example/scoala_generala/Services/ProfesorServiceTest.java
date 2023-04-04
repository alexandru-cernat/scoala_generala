package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Profesor;
import com.example.scoala_generala.repositories.ClasaRepository;
import com.example.scoala_generala.repositories.ProfesorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.naming.Binding;
import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProfesorServiceTest {

    @Mock
    private ProfesorRepository profesorRepository;
    @InjectMocks
    private ProfesorService profesorService ;



    @Test
    void canGetProfesori() {
        //given
        Clasa C1 = new Clasa("5A");
        Clasa C2 = new Clasa("5B");
        List<Clasa> listaClaselor = new ArrayList<>();
        listaClaselor.add(C1);
        listaClaselor.add(C2);

        Profesor profesor = new Profesor(1,
                "Ion",
                "Dolanescu",
                "0767794356",
                "ion.dolanescu@yahoo.com",
                "informatica",listaClaselor );
        when(profesorRepository.findAll()).thenReturn(List.of(profesor));

        //when
        List<Profesor> result = profesorService.getProfesori();

        //then
        assertEquals(1,result.size());
        assertEquals(profesor,result.get(0));
    }


    @Test
    void canAddProfesorCandNrTelefonExistaDeja(){

        //given
        Clasa C1 = new Clasa("5A");
        Clasa C2 = new Clasa("5B");
        List<Clasa> listaClaselor = new ArrayList<>();
        listaClaselor.add(C1);
        listaClaselor.add(C2);

        Profesor profesor = new Profesor(1,
                "Ion",
                "Dolanescu",
                "0767794356",
                "ion.dolanescu@yahoo.com",
                "informatica",listaClaselor );
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add("Acest numar de telefon exista deja!");
        when(profesorRepository.findByPhoneNumber(profesor.getPhoneNumber())).thenReturn(Optional.of(profesor));
        BindingResult bindingResult = mock(BindingResult.class);
        //when

        ResponseEntity<Object> response = profesorService.addProfesor(profesor, bindingResult);
        //then
        assertTrue(response.getBody().equals(expectedErrors));
        assertTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));


    }

    @Test
    void canAddProfesorCandeMailExistaDeja()
    {

        //given
        Clasa C1 = new Clasa("5A");
        Clasa C2 = new Clasa("5B");
        List<Clasa> listaClaselor = new ArrayList<>();
        listaClaselor.add(C1);
        listaClaselor.add(C2);

        Profesor profesor = new Profesor(1,
                "Ion",
                "Dolanescu",
                "0767794356",
                "ion.dolanescu@yahoo.com",
                "informatica",listaClaselor );
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add("Acest e-mail exista deja!");
        when(profesorRepository.findByEmailAddress(profesor.getEmailAddress())).thenReturn(Optional.of(profesor));
        BindingResult bindingResult = mock(BindingResult.class);
        //when

        ResponseEntity<Object> response = profesorService.addProfesor(profesor, bindingResult);
        //then
        assertTrue(response.getBody().equals(expectedErrors));
        assertTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));


    }
    @Test
    @Transactional
    void canAddProfesorHappyPath(){
        //given
        Clasa C1 = new Clasa("5A");
        Clasa C2 = new Clasa("5B");
        List<Clasa> listaClaselor = new ArrayList<>();
        listaClaselor.add(C1);
        listaClaselor.add(C2);

        Profesor profesor = new Profesor(10,
                "Mihai",
                "Cristescu",
                "0765244752",
                "mihai.cristescuu@gmail.com",
                "istorie",listaClaselor );

        BindingResult bindingResult = mock(BindingResult.class);
        when(profesorRepository.findByEmailAddress(profesor.getEmailAddress())).thenReturn(Optional.empty());
        when(profesorRepository.findByPhoneNumber(profesor.getPhoneNumber())).thenReturn(Optional.empty());

        //when
        ResponseEntity<Object> response = profesorService.addProfesor(profesor,bindingResult);

        //then
        assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
        verify(profesorRepository, times(1)).save(profesor);

    }
}