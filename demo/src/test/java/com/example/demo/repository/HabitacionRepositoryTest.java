package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Habitacion;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HabitacionRepositoryTest {
    @Autowired
    private HabitacionRepository habitacionRepository;
    @Test
    public void guardarHabitacionTest(){
        Habitacion habitacion= new Habitacion();
        habitacion.setNumHabitacion(346);
        habitacion.setCamas(2);
        habitacion.setM2("5.45 m2");
        habitacion.setPiso(3);
        habitacion.setStatus("disponible");

        Habitacion resultado=habitacionRepository.save(habitacion);

        assertNotNull(resultado.getId());
        assertEquals(346, resultado.getNumHabitacion());
        assertEquals(2, resultado.getCamas());
        assertEquals("5.45 m2", resultado.getM2());
        assertEquals(3, resultado.getPiso());
        assertEquals("disponible", resultado.getStatus());
    }
     
}