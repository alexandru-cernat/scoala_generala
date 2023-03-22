package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Elev;
import com.example.scoala_generala.repositories.ElevRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ElevService {

    @Autowired
    private final ElevRepository elevRepository;

    public Optional<Elev> getElevBySSN (String SSN)
    {
        return elevRepository.findBySSN(SSN);
    }

    public List<Elev> getElevi(){
        return (List<Elev>) elevRepository.findAll();
    }
}
