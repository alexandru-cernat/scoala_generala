package com.example.scoala_generala.Controllers;


import com.example.scoala_generala.Services.ElevService;
import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/elevi")
public class ElevController {

    @Autowired
    private final ElevService elevService;

   //Afiseaza detaliile unui elev, cautat dupa SSN (CNP)
    @GetMapping(path="/getBySSN/{SSN}")
    public ResponseEntity<?> getElevBySSN(@PathVariable String SSN) {
        return elevService.getElevBySSN(SSN);
    }

    //Afiseaza toti elevii
    @GetMapping(path="getAll")
    public List<Elev> getElevi()
    {
        return elevService.getElevi();
    }


    //Adauga un nou elev.
    @PostMapping(path="/Add")
    public ResponseEntity<?> addElev (@Valid @RequestBody Elev elev, BindingResult bindingResult){
        return elevService.addElev(elev, bindingResult);
    }


    //Muta elevul in alta clasa
    @PutMapping(path="/MoveElev/{idElev}")
    public ResponseEntity<?> moveElev(@PathVariable int idElev, @RequestBody Clasa nouaClasa)
    {
        return elevService.moveElev(idElev,nouaClasa);
    }

    //Sterge elevul
    @DeleteMapping(path="/Delete/{idElev}")
    public ResponseEntity<?> deleteElev(@PathVariable int idElev)
    {
        return elevService.deleteElev(idElev);
    }
}

