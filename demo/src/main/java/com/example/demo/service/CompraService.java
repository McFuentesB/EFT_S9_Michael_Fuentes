package com.example.demo.service;

import com.example.demo.model.Compra;
import java.util.List;
import java.util.Optional;

public interface CompraService {
    List<Compra> getAllCompras();
    Optional<Compra> getCompraById(Long id);
    Compra createCompra(Compra compra);
    Compra updateCompra(Long id, Compra compra);
    void deleteCompra(Long id);

}