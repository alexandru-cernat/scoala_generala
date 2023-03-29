package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@AutoConfigureMockMvc
@SpringBootTest
class ElevServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void canGetElevBySSN() throws Exception {
        mockMvc.perform(get("/api/v1/elevi/getBySSN/3111111111152"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.emailAddress").value("marian2.ion@gmail.com"))
                .andExpect(jsonPath("$.phoneNumber").value("0767707246"));
    }

    @Test
    void canGetElevi() throws Exception {
        mockMvc.perform(get("/api/v1/elevi/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].emailAddress").value("marian3.ion@gmail.com"))
                .andExpect(jsonPath("$[2].ssn").value("3111111111152"));
    }

    @Test
    void canAddElevElevDejaExista () throws Exception {

        String stringElevExistaInBazaDeDate ="{\"firstName\":\"GMarian\",\"lastName\":\"Ion\",\"address\":\"Bucuresti\",\"emailAddress\":\"marian2.ion@gmail.com\",\"phoneNumber\":\"0767707246\",\"ssn\":\"3111111111152\",\"clasa\":{\"numeClasa\":\"5A\"}}\"";
        mockMvc.perform(post("/api/v1/elevi/Add")
                .contentType(APPLICATION_JSON)
                .content(stringElevExistaInBazaDeDate))
                .andExpect(status().isBadRequest());


    }
    @Test
    @Transactional
    void canAddElevHappyPath () throws  Exception{
        String stringElevCareNuExista = "{\"firstName\":\"Daria\",\"lastName\":\"Mihaiescu\",\"address\":\"Timisoara\",\"emailAddress\":\"daria.m2000@yahoo.com\",\"phoneNumber\":\"0767894325\",\"ssn\":\"1111111111111\",\"clasa\":{\"numeClasa\":\"6A\"}}";
        mockMvc.perform(post("/api/v1/elevi/Add")
                .contentType(APPLICATION_JSON)
                .content(stringElevCareNuExista))
                .andExpect(status().isCreated());
    }


    @Test
    @Transactional
    @Rollback
    void canMoveElevHappyPath() throws Exception{

        int idExistent = 4;
        String clasaNoua = "{\"numeClasa\":\"5B\"}";
        mockMvc.perform(put("/api/v1/elevi/MoveElev/" + idExistent)
                .contentType(APPLICATION_JSON)
                .content(clasaNoua))
                .andExpect(status().isOk());
    }
    @Test
    @Transactional
    @Rollback
    void canMoveElevDejaEsteLaClasaAceea() throws Exception{

        int idExistent = 4;
        String clasaNoua = "{\"numeClasa\":\"5A\"}";
        mockMvc.perform(put("/api/v1/elevi/MoveElev/" + idExistent)
                .contentType(APPLICATION_JSON)
                .content(clasaNoua))
                .andExpect(status().isBadRequest());
    }
    @Test
    @Transactional
    @Rollback
    void canMoveElevClasaNuExista() throws Exception{

        int idExistent = 4;
        String clasaNoua = "{\"numeClasa\":\"10F\"}";
        mockMvc.perform(put("/api/v1/elevi/MoveElev/" + idExistent)
                .contentType(APPLICATION_JSON)
                .content(clasaNoua))
                .andExpect(status().isBadRequest());
    }

    @Test
    void canDeleteElevInexistent() throws Exception {

        int idInexistent = -1;

        mockMvc.perform(delete("/api/v1/elevi/Delete/" + idInexistent))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    @Rollback
    void canDeleteElevCareExista () throws Exception {
        int idExistent = 4;
        mockMvc.perform(delete("/api/v1/elevi/Delete/" + idExistent))
                .andExpect(status().isOk());
    }
}