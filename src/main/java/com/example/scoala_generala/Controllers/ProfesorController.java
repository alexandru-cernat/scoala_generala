package com.example.scoala_generala.Controllers;


import com.example.scoala_generala.Services.ProfesorService;
import com.example.scoala_generala.entities.Profesor;
import com.example.scoala_generala.repositories.ProfesorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path="api/v1/profesori")
public class ProfesorController {

    @Autowired
    private final ProfesorService profesorService;

    @GetMapping(path="/getAll")
    public List<Profesor> getProfesori()
    {
        return (List<Profesor>) profesorService.getProfesori();
    }

    @PostMapping(path="addProfesor")
    public void addProfesor(@RequestBody Profesor profesor)
    {
        profesorService.addProfesor(profesor);
    }
}
