package com.example.scoala_generala.Services;


import com.example.scoala_generala.entities.Profesor;
import com.example.scoala_generala.repositories.ProfesorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfesorService {

    @Autowired
    private final ProfesorRepository profesorRepository;

    public List<Profesor> getProfesori() { return (List<Profesor>) profesorRepository.findAll();}
    
    public void addProfesor(Profesor profesor) { profesorRepository.save(profesor);}
}
