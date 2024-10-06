package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotBlank(message = "No puede ingresar un numero de compra vacio")
    @Column(name="numCompra")
    private int numCompra;

    @NotBlank(message = "No puede ingresar un codigo de producto vacio")
    @Column(name="codProducto")
    private int codProducto;

    @NotBlank(message = "No puede ingresar un nombre de producto vacio")
    @Column(name="nombProducto")
    private String nombProducto;

    @NotBlank(message = "No puede ingresar un tipo de entrega vacio")
    @Column(name="tipoEntrega")
    private String tipoEntrega;

    @NotBlank(message = "No puede ingresar un nombre de cliente vacio")
    @Column(name="nombCliente")
    private String nombCliente;

    @NotBlank(message = "No puede ingresar un apellido de cliente vacio")
    @Column(name="apellidoCliente")
    private String apellidoCliente;

    @NotBlank(message = "No puede ingresar un correo de cliente vacio")
    @Column(name="correoCliente")
    private String correoCliente;

    @NotBlank(message = "No puede ingresar un telefono de cliente vacio")
    @Column(name="telefonoCliente")
    private int telefonoCliente;

    @NotBlank(message = "No puede ingresar una direccion de cliente vacia")
    @Column(name="direccionCliente")
    private String direccionCliente;

    @NotBlank(message = "No puede ingresar un total de compra vacio")
    @Column(name="totalCompra")
    private int totalCompra;

    @NotBlank(message = "No puede ingresar un status de compra vacio")
    @Column(name="statusCompra")
    private String statusCompra;



    public long getId() {
        return id;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombProducto(){
        return nombProducto;
    }

    public void setNombProducto(String nombProducto){
        this.nombProducto=nombProducto;
    }

    public String getTipoEntretga(){
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega){
        this.tipoEntrega=tipoEntrega;
    }

    public String getNombCliente(){
        return nombCliente;
    }

    public void setNombCliente(String nombCliente){
        this.nombCliente=nombCliente;
    }

    public String getApellidoCliente(){
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente){
        this.apellidoCliente=apellidoCliente;
    }

    public String getCorreoCliente(){
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente){
        this.correoCliente=correoCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccionCliente(){
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente){
        this.direccionCliente=direccionCliente;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getStatusCompra(){
        return statusCompra;
    }

    public void setStatusCompra(String statusCompra){
        this.statusCompra=statusCompra;
    }
    
}




