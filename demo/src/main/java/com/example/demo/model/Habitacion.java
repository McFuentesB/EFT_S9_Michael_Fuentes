package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotBlank(message = "No puede ingresar un numero de habitacion vacio")
    @Column(name="numHabitacion")
    private int numHabitacion;

    @NotBlank(message = "No puede ingresar una dimension de habitacion vacia")
    @Column(name="m2")
    private String m2;

    @NotBlank(message = "No puede ingresar un piso vacio")
    @Column(name="piso")
    private int piso;

    @NotBlank(message = "No puede ingresar un numero de camas vacio")
    @Column(name="camas")
    private int camas;

    @NotBlank(message = "No puede ingresar un status vacio")
    @Column(name="status")
    private String status;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
