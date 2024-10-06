package com.example.demo.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.Habitacion;
import com.example.demo.service.HabitacionServiceImpl;

@WebMvcTest(HabitacionController.class)
public class HabitacionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HabitacionServiceImpl habitacionServicioMock;

    @Test
    public void obtenerTodosTest() throws Exception{
        Habitacion habitacion1 = new Habitacion();
        habitacion1.setId(3L);
        habitacion1.setNumHabitacion(346);
        habitacion1.setCamas(2);
        habitacion1.setM2("5.45 m2");
        habitacion1.setPiso(3);
        habitacion1.setStatus("disponible");
        Habitacion habitacion2 = new Habitacion();
        habitacion2.setId(4L);
        habitacion2.setNumHabitacion(789);
        habitacion2.setCamas(2);
        habitacion2.setM2("5.45 m2");
        habitacion2.setPiso(3);
        habitacion2.setStatus("disponible");
        List<Habitacion> habitacions =Arrays.asList(habitacion1,habitacion2);
        when(habitacionServicioMock.getAllHabitacions()).thenReturn(habitacions);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/habitaciones"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].numHabitacion", Matchers.is(346)));
    }
    
}