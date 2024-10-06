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


import com.example.demo.model.Compra;
import com.example.demo.service.CompraServiceImpl;

@WebMvcTest(CompraController.class)
public class CompraControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompraServiceImpl compraServicioMock;

    @Test
    public void obtenerTodosTest() throws Exception{
        Compra compra1= new Compra();
        compra1.setId(1L);
        compra1.setApellidoCliente("Prueba");
        compra1.setCodProducto(213);
        compra1.setCorreoCliente("correoprueba@prueba.com");
        compra1.setDireccionCliente("direccion prueba 123");
        compra1.setNombCliente("Prueba");
        compra1.setNombProducto("Nom Producto Prueba");
        compra1.setNumCompra(123);
        compra1.setStatusCompra("despachado");
        compra1.setTelefonoCliente(123);
        compra1.setTipoEntrega("retiro");
        compra1.setTotalCompra(123);
        Compra compra2= new Compra();
        compra2.setId(2L);
        compra2.setApellidoCliente("Prueba2");
        compra2.setCodProducto(123);
        compra2.setCorreoCliente("correoprueba2@prueba.com");
        compra2.setDireccionCliente("direccion prueba2 123");
        compra2.setNombCliente("Prueba2");
        compra2.setNombProducto("Nom Producto Prueba2");
        compra2.setNumCompra(456);
        compra2.setStatusCompra("despachado");
        compra2.setTelefonoCliente(456);
        compra2.setTipoEntrega("retiro");
        compra2.setTotalCompra(456);
        List<Compra> compras=Arrays.asList(compra1,compra2);
        when(compraServicioMock.getAllCompras()).thenReturn(compras);

        mockMvc.perform(MockMvcRequestBuilders.get("/compras"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombCliente",Matchers.is("Prueba")))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].nombCliente",Matchers.is("Prueba2")));
    }
    
}