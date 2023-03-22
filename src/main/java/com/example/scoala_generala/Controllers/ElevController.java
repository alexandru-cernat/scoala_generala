package com.example.scoala_generala.Controllers;


import com.example.scoala_generala.Services.ElevService;
import com.example.scoala_generala.entities.Elev;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
