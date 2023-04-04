package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Profesor;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@AutoConfigureMockMvc
@SpringBootTest
class ProfesorServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void canGetProfesori() throws Exception {
        mockMvc.perform(get("/api/v1/profesori/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName").value("Andrei"))
                .andExpect(jsonPath("$[1].phoneNumber").value("0755223377"));


    }
    @Test
    @Transactional
    @DisplayName("adauga un profesor pe HappyPath (trece toate validarile)")
    void canAddProfesoriHappyPath() throws Exception {
        Clasa C1 = new Clasa("5A");
        Clasa C2 = new Clasa("5B");
        List<Clasa> listaClase = new ArrayList<>();
        listaClase.add(C1);
        listaClase.add(C2);

        Profesor profesorInexistentInBazaDeDate = new Profesor(
                17,
                "Gabriel",
                "Spiridon",
                "0768543345",
                "g.spiridon@yahoo.com",
                "informatica",
                listaClase);
        mockMvc.perform(post("/api/v1/profesori/addProfesor")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(profesorInexistentInBazaDeDate)))
                .andExpect(status().isCreated());




    }
    @Test
    void canAddProfesorCandProfesorulExistaDeja () throws Exception {
        Clasa C1 = new Clasa("5A");
        Clasa C2 = new Clasa("5B");
        List<Clasa> listaClase = new ArrayList<>();
        listaClase.add(C1);
        listaClase.add(C2);
        Profesor profesorExistent = new Profesor(

                "Ionescuu",
                "George",
                "0755223377",
                "ipopescu.mihai.profesor@gmail.com",
                "iistorie",
                listaClase);

        mockMvc.perform(post("/api/v1/profesori/addProfesor")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profesorExistent)))
                .andExpect(status().isBadRequest());
    }
    {

    }
}