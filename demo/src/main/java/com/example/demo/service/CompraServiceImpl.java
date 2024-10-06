package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Compra;
import com.example.demo.repository.CompraRepository;


import java.util.List;
import java.util.Optional;


@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> getAllCompras(){
        return compraRepository.findAll();
    }

    @Override
    public Optional <Compra> getCompraById(Long id){
        return compraRepository.findById(id);
    }

    @Override
    public Compra createCompra(Compra compra){
        return compraRepository.save(compra);
    }
    
    @Override
    public Compra updateCompra(Long id, Compra compra){
        if(compraRepository.existsById(id)){
            compra.setId(id);
            return compraRepository.save(compra);
        }   else {
            return null;
        }
        }

    @Override 
    public void deleteCompra(Long id){
        compraRepository.deleteById(id);
    }

    

    }