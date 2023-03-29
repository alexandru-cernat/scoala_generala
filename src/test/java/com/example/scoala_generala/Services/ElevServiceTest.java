package com.example.scoala_generala.Services;

import com.example.scoala_generala.entities.Clasa;
import com.example.scoala_generala.entities.Elev;
import com.example.scoala_generala.repositories.ClasaRepository;
import com.example.scoala_generala.repositories.ElevRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ElevServiceTest {


    //testul este independent de spring !!!!!
    @Mock
    private ElevRepository elevRepository;
    @Mock
    private ClasaRepository clasaRepository;
    @InjectMocks
    private ElevService elevService;

    Clasa clasa = new Clasa("5A");
    Elev elev = new Elev(
            1,
            "Mihai",
            "Popescu",
            "Bucuresti",
            "mihai.popescu@yahoo.com",
            "0774057496",
            "1111111111111",
            clasa);

    @Test
    void canGetElevBySSNHappyPath() {
        //given
        String ssnCautat="1111111111111";

        when(elevRepository.findBySSN(ssnCautat)).thenReturn(Optional.of(elev));
        //when
        ResponseEntity<?> elevCautat = elevService.getElevBySSN(ssnCautat);
        //then
        assertEquals(elevCautat.getBody(),elev);
        assertEquals(HttpStatus.OK, elevCautat.getStatusCode());
        assertNotNull(elevCautat.getBody());
    }

    @Test
    void canGetElevBySSNNuExista() {
        //given
        String ssnInexistent ="000000000000";
        when(elevRepository.findBySSN(ssnInexistent)).thenReturn(Optional.empty());
        String expectedError = "Elevul cu CNP-ul specificat NU exista!";
    //when
        ResponseEntity<?> elevCautat = elevService.getElevBySSN(ssnInexistent);
    //then
        assertEquals(HttpStatus.BAD_REQUEST, elevCautat.getStatusCode());
        assertEquals(elevCautat.getBody(), expectedError);
    }
    @Test
    void canGetElevi() {
        //given
        when(elevRepository.findAll()).thenReturn(List.of(elev));

        //when
        List<Elev> result = elevService.getElevi();

        //then
        assertEquals(1,result.size());
        assertEquals(elev,result.get(0));
    }

    @Test
    void canAddElevHappyPath() {
        //given
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        when(elevRepository.findBySSN("1111111111111")).thenReturn(Optional.empty());
        when(elevRepository.findByEmailAddress("mihai.popescu@yahoo.com")).thenReturn(Optional.empty());
        when(elevRepository.findByPhoneNumber("0774057496")).thenReturn(Optional.empty());
        //when
        ResponseEntity<Object> result = elevService.addElev(elev, bindingResult);
        //then
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(elevRepository, times(1)).save(any(Elev.class));
    }

    @Test
    public void canAddElevCuDateExistente() {
        //given
        Elev existingElev = new Elev();
        existingElev.setEmailAddress("mihai.popescu@yahoo.com");
        existingElev.setPhoneNumber("0774057496");
        existingElev.setSSN("1111111111111");

        when(elevRepository.findByEmailAddress(existingElev.getEmailAddress())).thenReturn(Optional.of(existingElev));
        when(elevRepository.findByPhoneNumber(existingElev.getPhoneNumber())).thenReturn(Optional.of(existingElev));
        when(elevRepository.findBySSN(existingElev.getSSN())).thenReturn(Optional.of(existingElev));


        BindingResult bindingResult = mock(BindingResult.class);
        //when
        ResponseEntity<Object> responseEntity = elevService.addElev(elev, bindingResult);

        assertTrue(responseEntity.getStatusCode().equals(HttpStatus.BAD_REQUEST));
        List<String>expectedResponse = new ArrayList<>();
        expectedResponse.add("e-mail deja existent");
        expectedResponse.add("CNP deja existent");
        expectedResponse.add("nr telefon deja existent");

        assertTrue(responseEntity.getBody().equals(expectedResponse));
    }
    @Test
    public void canAddElevCuClasaNeexistenta() {
        //given
        Clasa clasaInexistenta = new Clasa("5E");
        Elev elevTest = new Elev();
        elevTest.setClasa(clasaInexistenta);

        BindingResult bindingResult = mock(BindingResult.class);

        //when
        ResponseEntity<Object> responseEntity = elevService.addElev(elevTest, bindingResult);

        //then
        List<String> expectedError = new ArrayList<>();
        expectedError.add("clasa la care vreti sa adaugati elevul nu exista");

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(expectedError, responseEntity.getBody());
    }

    @Test
    void canAddElevCuEroriLaValiditateDateInBindingResult(){

        //given
        BindingResult bindingResult = mock(BindingResult.class);
        String expectedError = "e-mail invalid";
        FieldError fieldError = new FieldError("elev", "emailAddress",expectedError);
        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.getFieldErrors()).thenReturn(Collections.singletonList(fieldError));


        //when
        ResponseEntity<Object> responseEntity = elevService.addElev(elev, bindingResult);

        //then
        List<String> errors = (List<String>) responseEntity.getBody();
        assertTrue(errors.contains(expectedError));
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }




    @Test
    void canMoveElevCandAcestaNuExista() {
        //given
        int idInexistent = -1;
        List<String> expectedError = new ArrayList<>();
        expectedError.add("Elevul cu id-ul specificat nu exista!");
        when(elevRepository.findById(idInexistent)).thenReturn(Optional.empty());

        // when
        ResponseEntity<Object> response = elevService.moveElev(idInexistent, clasa);

        // then
        assertTrue(response.getBody().equals(expectedError));
        assertTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));
        ;
    }
    @Test
    void canMoveElevCandClasaNuExista() {
        //given
        Clasa nouaClasa = new Clasa("9A");
        List<String> expectedError = new ArrayList<>();
        expectedError.add("Clasa la care vreti sa mutati elevul nu exista!");
        when(elevRepository.findById(elev.getId())).thenReturn(Optional.of(elev));

        // when
        ResponseEntity<Object> response = elevService.moveElev(elev.getId(), nouaClasa);

        // then
        assertTrue(response.getBody().equals(expectedError));
        assertTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));
        ;
    }    @Test
    void canMoveElevCandEsteDejaLaAceaClasa() {
        //given
        Clasa nouaClasa = new Clasa("5A");
        List<String> expectedError = new ArrayList<>();
        expectedError.add("Elevul este deja la aceasta clasa!");
        when(elevRepository.findById(elev.getId())).thenReturn(Optional.of(elev));
        when(clasaRepository.findByNumeClasa(nouaClasa.getNumeClasa())).thenReturn(Optional.of(nouaClasa));
        // when
        ResponseEntity<Object> response = elevService.moveElev(elev.getId(), nouaClasa);

        // then
        assertTrue(response.getBody().equals(expectedError));
        assertTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));
        ;
    }
    @Test
        void canMoveElevHappyPath(){
            //given
            Clasa nouaClasa = new Clasa("6A");
        when(elevRepository.findById(anyInt())).thenReturn(Optional.of(elev));
        when(clasaRepository.findByNumeClasa(eq(nouaClasa.getNumeClasa()))).thenReturn(Optional.of(nouaClasa));

        //when
            ResponseEntity<Object> response = elevService.moveElev(elev.getId(), nouaClasa);

            //then
            assertEquals(HttpStatus.OK, response.getStatusCode());
            verify(elevRepository, times(1)).save(elev);
            verify(clasaRepository, times(1)).save(clasa);
            verify(clasaRepository, times(1)).save(nouaClasa);
            assertEquals(nouaClasa, elev.getClasa());
        }

    @Test
    void deleteElevCandElevulNuExista() {
        //given
        int idInexistent = -1;
        List<String> expectedError = new ArrayList<>();
        expectedError.add("Elevul cu id-ul specificat nu exista!");
        when(elevRepository.findById(idInexistent)).thenReturn(Optional.empty());
        //when
        ResponseEntity<Object> expectedResponse = elevService.deleteElev(idInexistent);
        //then
        assertTrue(expectedResponse.getStatusCode().equals(HttpStatus.BAD_REQUEST));
        assertTrue(expectedResponse.getBody().equals(expectedError));
    }


    @Test
    void deleteElevHappyPath(){
        //given
        when(elevRepository.findById(elev.getId())).thenReturn(Optional.of(elev));
        //when
        ResponseEntity<Object> expectedResponse = elevService.deleteElev(elev.getId());
        //then
        assertTrue(expectedResponse.getStatusCode().equals(HttpStatus.OK));

        verify(elevRepository, times(1)).delete(elev);
    }


}