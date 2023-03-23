package com.example.scoala_generala.Controllers;


import com.example.scoala_generala.Services.ClasaService;
import com.example.scoala_generala.entities.Clasa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clase")
@AllArgsConstructor
public class ClasaController {

    @Autowired
    private final ClasaService clasaService;

    @GetMapping(path="/getAll")
    public List<Clasa> getClase(){return clasaService.getClase();}
}
