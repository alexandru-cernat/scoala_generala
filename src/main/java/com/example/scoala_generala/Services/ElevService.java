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

    public void asigneazaClasa ( int id_elev, Clasa clasaAsignata)
    {
        Optional<Elev> elevOptional = elevRepository.findById(id_elev);
        if (elevOptional.isPresent()){
            Elev elevNou = elevOptional.get();
            elevNou.setClasa(clasaAsignata);
            elevRepository.save(elevNou);

            clasaAsignata.appendEleviiClasei(elevNou);
            clasaRepository.save(clasaAsignata);

        }
    }

    public void moveElev(int idElev, Clasa nouaClasa){
        Optional<Elev> elevOptional= elevRepository.findById(idElev);
        if(elevOptional.isPresent()){
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


        }

    }
        public void deleteElev(int idElev){
            // sterg elevul si din clasa
            Optional<Elev> elevOptional = elevRepository.findById(idElev);
            Elev elevSters = elevOptional.get();

            Clasa clasaElevului = elevSters.getClasa();
            elevRepository.delete(elevSters);
            clasaElevului.stergeEleviiClasei(elevSters);
            clasaRepository.save(clasaElevului);
        }
}
