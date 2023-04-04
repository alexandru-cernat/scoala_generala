package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import com.example.scoala_generala.repositories.ClasaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClasaServiceTest {

    @Mock
    private ClasaRepository clasaRepository;
    @InjectMocks
    private ClasaService clasaService ;

    Clasa clasa = new Clasa("5A");
    @Test
    void canGetClase() {
        //given
        when(clasaRepository.findAll()).thenReturn(List.of(clasa));

        //when
        List<Clasa> result = clasaService.getClase();

        //then
        assertEquals(1,result.size());
        assertEquals(clasa,result.get(0));
    }
}