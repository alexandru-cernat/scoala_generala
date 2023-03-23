package com.example.scoala_generala.repositories;


import com.example.scoala_generala.entities.Elev;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElevRepository extends CrudRepository<Elev,String> {
    Optional<Elev> findBySSN(String SSN);
    Optional<Elev> findById(int id);
}
