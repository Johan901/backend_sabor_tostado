package com.sabortostado.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "Proveedor")
public class Proveedor {

    @Id
    private Integer _id;
    private String nombreEmpresa;
    private String ubicacion;
    private Integer telefono;
    @Field("emailProv")
    private String emailProveedor;
    private Date fechaSuministro;
    private List<String> productos; // Assuming ObjectIds are stored as strings

    // Constructors
    public Proveedor() {}

    public Proveedor(Integer _id, String nombreEmpresa, String ubicacion, Integer telefono, String emailProveedor, Date fechaSuministro, List<String> productos) {
        this._id = _id;
        this.nombreEmpresa = nombreEmpresa;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.emailProveedor = emailProveedor;
        this.fechaSuministro = fechaSuministro;
        this.productos = productos;
    }

    // Getters and Setters
    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public Date getFechaSuministro() {
        return fechaSuministro;
    }

    public void setFechaSuministro(Date fechaSuministro) {
        this.fechaSuministro = fechaSuministro;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "_id=" + _id +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", telefono=" + telefono +
                ", emailProveedor='" + emailProveedor + '\'' +
                ", fechaSuministro=" + fechaSuministro +
                ", productos=" + productos +
                '}';
    }
}
