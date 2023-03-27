package com.example.scoala_generala.Services;


import com.example.scoala_generala.entities.Profesor;
import com.example.scoala_generala.repositories.ProfesorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfesorService {

    @Autowired
    private final ProfesorRepository profesorRepository;

    public List<Profesor> getProfesori() { return (List<Profesor>) profesorRepository.findAll();}

    public ResponseEntity<Object> addProfesor(Profesor profesor, BindingResult bindingResult) {

        List<String> errors = new ArrayList<>();

        if(profesorRepository.findByPhoneNumber(profesor.getPhoneNumber()).isPresent()){
            errors.add("Acest numar de telefon exista deja!");
        }
        if(profesorRepository.findByEmailAddress(profesor.getEmailAddress()).isPresent()){
            errors.add("Acest e-mail exista deja!");
        }

        if (bindingResult.hasErrors()) {
            errors.addAll(bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList()));
        }
        if(!errors.isEmpty())
            return ResponseEntity.badRequest().body(errors);
        profesorRepository.save(profesor);
        return ResponseEntity.ok().build();

    }
}
