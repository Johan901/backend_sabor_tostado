package com.sabortostado.dtos;


public class ProductoDTO {
    private String nombreProducto;
    private int stock;

    // Constructor vacío
    public ProductoDTO() {
    }

    // Constructor con parámetros
    public ProductoDTO(String nombreProducto, int stock) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
    }

    // Getters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método toString (opcional, útil para depuración)
    @Override
    public String toString() {
        return "ProductoDTO{" +
               "nombreProducto='" + nombreProducto + '\'' +
               ", stock=" + stock +
               '}';
    }
}
