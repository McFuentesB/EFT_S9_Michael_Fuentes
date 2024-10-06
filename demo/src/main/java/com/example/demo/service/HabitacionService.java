package com.example.demo.service;

import com.example.demo.model.Habitacion;
import java.util.List;
import java.util.Optional;

public interface HabitacionService {
    List<Habitacion> getAllHabitacions();
    Optional<Habitacion> getHabitacionById(Long id);
    Habitacion createHabitacion(Habitacion habitacion);
    Habitacion updateHabitacion(Long id, Habitacion habitacion);
    void deleteHabitacion(Long id);

}