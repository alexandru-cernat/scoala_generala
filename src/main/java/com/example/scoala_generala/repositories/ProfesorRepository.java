package com.example.scoala_generala.repositories;

import com.example.scoala_generala.entities.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesorRepository extends CrudRepository<Profesor,Integer> {

}
