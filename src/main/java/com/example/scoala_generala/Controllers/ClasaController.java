package com.example.scoala_generala.Controllers;


import com.example.scoala_generala.Services.ClasaService;
import com.example.scoala_generala.entities.Clasa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clase")
@AllArgsConstructor
public class ClasaController {

    @Autowired
    private final ClasaService clasaService;

    // afiseaza toate clasele si implicit elevii si profesorii din fiecare
    @GetMapping(path="/getAll")
    public List<Clasa> getClase(){return clasaService.getClase();}

}
