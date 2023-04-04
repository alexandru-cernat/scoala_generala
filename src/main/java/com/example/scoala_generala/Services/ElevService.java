package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import com.example.scoala_generala.repositories.ClasaRepository;
import com.example.scoala_generala.repositories.ElevRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElevService {

    private final ElevRepository elevRepository;
    private final ClasaRepository clasaRepository;

    public ResponseEntity<?> getElevBySSN (String SSN)
    {
        Optional<Elev> elevOptional = elevRepository.findBySSN((SSN));
        if (!elevOptional.isPresent()){
            String error = "Elevul cu CNP-ul specificat NU exista!";
            return ResponseEntity.badRequest().body(error);

        }
    return ResponseEntity.ok().body(elevOptional.get());
    }

    public List<Elev> getElevi() {
        return (List<Elev>) elevRepository.findAll();
    }


public ResponseEntity<Object> addElev( Elev elev, BindingResult bindingResult) {
    List<String> errors = new ArrayList<>();

    if (elevRepository.findByEmailAddress(elev.getEmailAddress()).isPresent()) {
        errors.add("e-mail deja existent");
    }
    if (elevRepository.findBySSN(elev.getSSN()).isPresent()) {
        errors.add("CNP deja existent");
    }
    if (elevRepository.findByPhoneNumber(elev.getPhoneNumber()).isPresent()) {
        errors.add("nr telefon deja existent");
    }
    Set<String> validClassNames = new HashSet<>(Arrays.asList
            ("5A", "5B", "5C", "5D",
                    "6A", "6B", "6C","6D",
                    "7A", "7B", "7C", "7D",
                    "8A", "8B", "8C", "8D"));

    if (!validClassNames.contains(elev.getClasa().getNumeClasa())) {
        errors.add("clasa la care vreti sa adaugati elevul nu exista");
    }

    if (bindingResult.hasErrors()) {
        errors.addAll(bindingResult.getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList()));
    }

    if (!errors.isEmpty()) {
        return ResponseEntity.badRequest().body(errors);
    }

    elevRepository.save(elev);
    URI location = URI.create("/api/v1/elevi/Add/"+elev.getId());
    return ResponseEntity.created(location).build();
}



    public ResponseEntity<Object> moveElev(int idElev, Clasa nouaClasa){
        List<String> errors = new ArrayList<>();

        Optional<Elev> elevOptional = elevRepository.findById(idElev);
        if(!elevOptional.isPresent()) {
            errors.add("Elevul cu id-ul specificat nu exista!");
            return ResponseEntity.badRequest().body(errors);
            }

        if(!clasaRepository.findByNumeClasa(nouaClasa.getNumeClasa()).isPresent()){
            errors.add("Clasa la care vreti sa mutati elevul nu exista!");
            return ResponseEntity.badRequest().body(errors);
        }
        if(clasaRepository.findByNumeClasa(nouaClasa.getNumeClasa())
                .get()
                .getNumeClasa()
                .equals(elevRepository.findById(idElev).get().getClasa().getNumeClasa()))
        {
            errors.add("Elevul este deja la aceasta clasa!");
            return ResponseEntity.badRequest().body(errors);
        }




        if(!errors.isEmpty())
        {
            return ResponseEntity.badRequest().body(errors);
        }

        Elev elevMutat = elevOptional.get();
        Clasa clasaVeche = elevMutat.getClasa();
        clasaVeche.stergeEleviiClasei(elevMutat);
        clasaRepository.save(clasaVeche);

        // adauga clasa noua elevului
        elevMutat.setClasa(nouaClasa);
        elevRepository.save(elevMutat);

        // adaugarea in lista de elevi a clasei noi

        nouaClasa.appendEleviiClasei(elevMutat);
        clasaRepository.save(nouaClasa);

       return ResponseEntity.ok().build(); }


    public ResponseEntity<Object> deleteElev (int idElev){

        List<String> errors = new ArrayList<>();
        Optional<Elev> elevOptional = elevRepository.findById(idElev);
        if(!elevOptional.isPresent()){
            errors.add("Elevul cu id-ul specificat nu exista!");
            return ResponseEntity.badRequest().body(errors);
        }

        elevRepository.delete(elevOptional.get());

        return ResponseEntity.ok().build();

    }


}
