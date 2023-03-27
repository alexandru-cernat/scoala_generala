package com.example.scoala_generala;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DemoEndpoint.class)
class DemoEndpointTest {

    @Autowired
    private MockMvc mvc;
    @Test
    void firstEndpoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/demo");
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("This is the first Endpoint!", result.getResponse().getContentAsString());
    }
}