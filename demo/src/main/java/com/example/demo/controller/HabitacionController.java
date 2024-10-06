package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Habitacion;
import com.example.demo.service.HabitacionService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {

    private static final Logger log = LoggerFactory.getLogger(HabitacionController.class);

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public List<EntityModel<Habitacion>> getAllHabitacions() {
        log.info("Retornando todas las habitaciones");
        List<Habitacion> habitaciones = habitacionService.getAllHabitacions();
        
        return habitaciones.stream()
                .map(habitacion -> {
                    EntityModel<Habitacion> resource = EntityModel.of(habitacion);
                    Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HabitacionController.class).getHabitacionById(habitacion.getId())).withSelfRel();
                    resource.add(selfLink);
                    return resource;
                })
                .toList();
    }
    
    @GetMapping("/{id}")
    public EntityModel<Habitacion> getHabitacionById(@PathVariable Long id) {
        log.info("Buscando habitación con ID: {}", id);
        Optional<Habitacion> habitacionOpt = habitacionService.getHabitacionById(id);

        if (habitacionOpt.isEmpty()) {
            log.warn("No se encontró habitación con ID: {}", id);
            // Puedes lanzar una excepción aquí si lo prefieres
            return null; // Manejar caso de error apropiadamente
        }
        
        Habitacion habitacion = habitacionOpt.get();
        EntityModel<Habitacion> resource = EntityModel.of(habitacion);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HabitacionController.class).getHabitacionById(habitacion.getId())).withSelfRel();
        Link updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HabitacionController.class).updateHabitacion(habitacion.getId(), habitacion)).withRel("update");
        
        resource.add(selfLink, updateLink);
        return resource;
    }

    @PostMapping
    public EntityModel<Habitacion> createHabitacion(@RequestBody Habitacion habitacion) {
        log.info("Habitación creada correctamente");
        Habitacion createdHabitacion = habitacionService.createHabitacion(habitacion);
        EntityModel<Habitacion> resource = EntityModel.of(createdHabitacion);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HabitacionController.class).getHabitacionById(createdHabitacion.getId())).withSelfRel();
        resource.add(selfLink);
        return resource;
    }
 
    @PutMapping("/{id}")
    public EntityModel<Habitacion> updateHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        log.info("Habitación actualizada correctamente");
        Habitacion updatedHabitacion = habitacionService.updateHabitacion(id, habitacion);
        EntityModel<Habitacion> resource = EntityModel.of(updatedHabitacion);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HabitacionController.class).getHabitacionById(updatedHabitacion.getId())).withSelfRel();
        resource.add(selfLink);
        return resource;
    }
    
    @DeleteMapping("/{id}")
    public void deleteHabitacion(@PathVariable Long id) {
        log.info("Intentando eliminar la habitación ID: {}", id);
        habitacionService.deleteHabitacion(id);
    }
}
