package com.example.scoala_generala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoEndpoint {

    @GetMapping(path="/demo")
    public String firstEndpoint()
    {
        return "This is the first Endpoint!";
    }

}
