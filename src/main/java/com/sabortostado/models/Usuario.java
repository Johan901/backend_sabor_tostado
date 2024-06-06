package com.sabortostado.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {

    @Id
    private Integer _id;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String email;
    private String password;
    private String userType;

    public Usuario() {
    }

    public Usuario(Integer _id, String nombre, String direccion, Integer telefono, String email, String password, String userType) {
        this._id = _id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.userType = userType;
        validarUsuario();
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private void validarUsuario() {
        if ("cliente".equals(this.userType)) {
            if (this.direccion == null || this.telefono == null) {
                throw new IllegalStateException("La dirección y el teléfono son requeridos para los usuarios tipo 'cliente'");
            }
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
