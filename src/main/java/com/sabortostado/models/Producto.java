package com.sabortostado.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Producto")
public class Producto {

    @Id
    private Integer _id;
    private String nombreProducto;
    private String descripcion;
    private Integer precioVenta;
    private String origen;
    private Integer stock;
    private Integer proveedorId;
    private List<Comentario> comentarios;

    public Producto() {
    }

    public Producto(Integer _id, String nombreProducto, String descripcion, Integer precioVenta, String origen, Integer stock, Integer proveedorId, List<Comentario> comentarios) {
        this._id = _id;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.origen = origen;
        this.stock = stock;
        this.proveedorId = proveedorId;
        this.comentarios = comentarios;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "_id=" + _id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                ", origen='" + origen + '\'' +
                ", stock=" + stock +
                ", proveedorId=" + proveedorId +
                ", comentarios=" + comentarios +
                '}';
    }

    public static class Comentario {
        private Integer comment_id;
        private String comentario;
        private Date fechaComment;

        public Comentario() {
        }

        public Comentario(Integer comment_id, String comentario, Date fechaComment) {
            this.comment_id = comment_id;
            this.comentario = comentario;
            this.fechaComment = fechaComment;
        }

        public Integer getComment_id() {
            return comment_id;
        }

        public void setComment_id(Integer comment_id) {
            this.comment_id = comment_id;
        }

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        public Date getFechaComment() {
            return fechaComment;
        }

        public void setFechaComment(Date fechaComment) {
            this.fechaComment = fechaComment;
        }

        @Override
        public String toString() {
            return "Comentario{" +
                    "comment_id=" + comment_id +
                    ", comentario='" + comentario + '\'' +
                    ", fechaComment=" + fechaComment +
                    '}';
        }
    }
}
