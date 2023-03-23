package com.example.scoala_generala.Controllers;


import com.example.scoala_generala.Services.ElevService;
import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/elevi")
public class ElevController {

    @Autowired
    private final ElevService elevService;

    @GetMapping(path="/getBySSN/{SSN}")
    public Optional<Elev> getEleviBySSN(@PathVariable String SSN) {
        return elevService.getElevBySSN(SSN);
    }

    @GetMapping(path="getAll")
    public List<Elev> getElevi()
    {
        return elevService.getElevi();
    }

    @PutMapping(path="/addClasa/{idElev}")
    public void asigneazaClasa(@PathVariable int idElev, @RequestBody Clasa clasa_asignata) {
        elevService.asigneazaClasa(idElev, clasa_asignata);
    }



    @PostMapping(path="/Add")
    public void addElev (@RequestBody Elev elev){
        elevService.addElev(elev);
    }

    @PutMapping(path="/MoveElev/{idElev}")
    public void moveElev(@PathVariable int idElev, @RequestBody Clasa nouaClasa)
    {
        elevService.moveElev(idElev,nouaClasa);
    }

    @DeleteMapping(path="/Delete/{idElev}")
    public void deleteElev(@PathVariable int idElev)
    {
        elevService.deleteElev(idElev);
    }
}

