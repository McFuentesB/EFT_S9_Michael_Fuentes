package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Habitacion;
import com.example.demo.repository.HabitacionRepository;


import java.util.List;
import java.util.Optional;


@Service
public class HabitacionServiceImpl implements HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public List<Habitacion> getAllHabitacions(){
        return habitacionRepository.findAll();
    }

    @Override
    public Optional <Habitacion> getHabitacionById(Long id){
        return habitacionRepository.findById(id);
    }

    @Override
    public Habitacion createHabitacion(Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }
    
    @Override
    public Habitacion updateHabitacion(Long id, Habitacion habitacion){
        if(habitacionRepository.existsById(id)){
            habitacion.setId(id);
            return habitacionRepository.save(habitacion);
        }   else {
            return null;
        }
        }

    @Override 
    public void deleteHabitacion(Long id){
        habitacionRepository.deleteById(id);
    }

    

    }