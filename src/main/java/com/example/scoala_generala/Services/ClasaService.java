package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.repositories.ClasaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasaService {

    ClasaRepository clasaRepository;

    public List<Clasa> getClase(){return clasaRepository.findAll();}

}
