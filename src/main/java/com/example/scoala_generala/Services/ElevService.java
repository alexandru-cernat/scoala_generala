package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import com.example.scoala_generala.repositories.ClasaRepository;
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
    private final ClasaRepository clasaRepository;

    public Optional<Elev> getElevBySSN (String SSN)
    {
        return elevRepository.findBySSN(SSN);
    }

    public List<Elev> getElevi() {
        return (List<Elev>) elevRepository.findAll();
    }


    public void addElev(Elev elev )
    {
        elevRepository.save(elev);
    }

    public void asigneazaClasa ( int id_elev, Clasa clasa_asignata)
    {
        Optional<Elev> aux = elevRepository.findById(id_elev);
        if (aux.isPresent()){
            Elev e = aux.get();
            e.setClasa(clasa_asignata);
            elevRepository.save(e);

            Clasa clasa_aux = new Clasa(clasa_asignata.getId(),
                    clasa_asignata.getNumeClasa(),
                    clasa_asignata.getEleviiClasei() );

            clasa_aux.appendEleviiClasei(e);
            clasaRepository.save(clasa_aux);

        }
    }

//    public void moveElev(int idElev, Clasa nouaClasa)
//    {
//        Optional <Elev> aux = elevRepository.findById(idElev);
//        if(aux.isPresent()){
//            Elev e = aux.get();

        }
