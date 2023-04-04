package com.example.scoala_generala.Controllers;


import com.example.scoala_generala.Services.ProfesorService;
import com.example.scoala_generala.entities.Profesor;
import com.example.scoala_generala.repositories.ProfesorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> addProfesor(@Valid @RequestBody Profesor profesor, BindingResult bindingResult)
    {
       return profesorService.addProfesor(profesor, bindingResult);
    }
}
