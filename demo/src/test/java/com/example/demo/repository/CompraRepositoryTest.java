package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Compra;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraRepositoryTest {
    @Autowired 
    private CompraRepository compraRepository;

    @Test
    public void guardarHabitacionTest(){
        Compra compra= new Compra();
        compra.setApellidoCliente("Prueba");
        compra.setCodProducto(213);
        compra.setCorreoCliente("correoprueba@prueba.com");
        compra.setDireccionCliente("direccion prueba 123");
        compra.setNombCliente("Prueba");
        compra.setNombProducto("Nom Producto Prueba");
        compra.setNumCompra(123);
        compra.setStatusCompra("despachado");
        compra.setTelefonoCliente(123);
        compra.setTipoEntrega("retiro");
        compra.setTotalCompra(123);

        Compra resultado=compraRepository.save(compra);

        assertNotNull(resultado.getId());
        assertEquals("Prueba", resultado.getApellidoCliente());
        assertEquals(213, resultado.getCodProducto());
        assertEquals("correoprueba@prueba.com", resultado.getCorreoCliente());
        assertEquals("direccion prueba 123", resultado.getDireccionCliente());
        assertEquals("Prueba", resultado.getNombCliente());
        assertEquals("Nom Producto Prueba", resultado.getNombProducto());
        assertEquals(123, resultado.getNumCompra());
        assertEquals("despachado", resultado.getStatusCompra());
        assertEquals(123, resultado.getTelefonoCliente());
        assertEquals("retiro", resultado.getTipoEntretga());
        assertEquals(123, resultado.getTotalCompra());
    }
    
}