package com.example.scoala_generala.Services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ClasaServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Check if we can get all 'clase'")
    void canGetClase() throws Exception {
        mockMvc.perform(get("/api/v1/clase/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].numeClasa").value("5A"))
                .andExpect(jsonPath("$[1].numeClasa").value("5B"));


    }
}