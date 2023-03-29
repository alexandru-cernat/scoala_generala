package com.example.scoala_generala.Services;


import com.example.scoala_generala.entities.Profesor;
import com.example.scoala_generala.repositories.ProfesorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public List<Profesor> getProfesori() { return (List<Profesor>) profesorRepository.findAll();}

    public ResponseEntity<Object> addProfesor(Profesor profesor, BindingResult bindingResult) {

        List<String> errors = new ArrayList<>();

        if(profesorRepository.findByPhoneNumber(profesor.getPhoneNumber()).isPresent()){
            errors.add("Acest numar de telefon exista deja!");
            return ResponseEntity.badRequest().body(errors);
        }
        if(profesorRepository.findByEmailAddress(profesor.getEmailAddress()).isPresent()){
            errors.add("Acest e-mail exista deja!");
            return ResponseEntity.badRequest().body(errors);
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
        URI location = URI.create("/api/v1/profesori/addProfesor/"+profesor.getId());
        return ResponseEntity.created(location).build();

    }
}
