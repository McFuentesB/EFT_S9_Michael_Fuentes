package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Compra;
import com.example.demo.service.CompraService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private static final Logger log = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<EntityModel<Compra>> getAllCompras() {
        log.info("retornando todas las compras");

        List<Compra> compras = compraService.getAllCompras();
        return compras.stream()
            .map(compra -> EntityModel.of(compra,
                linkTo(methodOn(CompraController.class).getCompraById(compra.getId())).withSelfRel(),
                linkTo(methodOn(CompraController.class).getAllCompras()).withRel("compras")))
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Compra> getCompraById(@PathVariable Long id) {
        log.info("retornando compra por ID");
        Optional<Compra> compraOptional = compraService.getCompraById(id);
    
        return compraOptional.map(compra -> {
            // Crea los enlaces HATEOAS
            EntityModel<Compra> entityModel = EntityModel.of(compra,
                linkTo(methodOn(CompraController.class).getCompraById(compra.getId())).withSelfRel(),
                linkTo(methodOn(CompraController.class).getAllCompras()).withRel("compras"),
                linkTo(methodOn(CompraController.class).updateCompra(compra.getId(), compra)).withRel("update"));
            
            return entityModel;
        }).orElseThrow(() -> new RuntimeException("Compra no encontrada"));
    }
    

    @PostMapping
    public EntityModel<Compra> createCompra(@RequestBody Compra compra) {
        log.info("compra creada");
        Compra nuevaCompra = compraService.createCompra(compra);

        return EntityModel.of(nuevaCompra,
            linkTo(methodOn(CompraController.class).getCompraById(nuevaCompra.getId())).withSelfRel(),
            linkTo(methodOn(CompraController.class).getAllCompras()).withRel("compras"));
    }

    @PutMapping("/{id}")
    public EntityModel<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra compra) {
        log.info("compra actualizada correctamente");
        Compra updatedCompra = compraService.updateCompra(id, compra);

        return EntityModel.of(updatedCompra,
            linkTo(methodOn(CompraController.class).getCompraById(updatedCompra.getId())).withSelfRel(),
            linkTo(methodOn(CompraController.class).getAllCompras()).withRel("compras"));
    }

    @DeleteMapping("/{id}")
    public void deleteCompra(@PathVariable Long id) {
        log.info("compra eliminada correctamente");
        compraService.deleteCompra(id);
    }
}
