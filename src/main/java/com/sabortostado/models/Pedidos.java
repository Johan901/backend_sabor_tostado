package com.sabortostado.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Pedidos")
public class Pedidos {

    @Id
    private Integer cliente_id;
    private Date fechaPedido;
    private String estadoPedido;
    private Integer numeroFactura;
    private Date fechaEnvio;
    private String estadoEnvio;
    private List<Detalle> detalle;

    public Pedidos() {}

    public Pedidos(Integer cliente_id, Date fechaPedido, String estadoPedido, Integer numeroFactura, Date fechaEnvio, String estadoEnvio, List<Detalle> detalle) {
        this.cliente_id = cliente_id;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.numeroFactura = numeroFactura;
        this.fechaEnvio = fechaEnvio;
        this.estadoEnvio = estadoEnvio;
        this.detalle = detalle;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public List<Detalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Detalle> detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "cliente_id=" + cliente_id +
                ", fechaPedido=" + fechaPedido +
                ", estadoPedido='" + estadoPedido + '\'' +
                ", numeroFactura=" + numeroFactura +
                ", fechaEnvio=" + fechaEnvio +
                ", estadoEnvio='" + estadoEnvio + '\'' +
                ", detalle=" + detalle +
                '}';
    }

    public static class Detalle {
        private Integer proveedor_id;
        private Integer producto_id;
        private String nombreProducto;
        private Integer cantidad;
        private Integer costePedido;

        public Detalle() {}

        public Detalle(Integer proveedor_id, Integer producto_id, String nombreProducto, Integer cantidad, Integer costePedido) {
            this.proveedor_id = proveedor_id;
            this.producto_id = producto_id;
            this.nombreProducto = nombreProducto;
            this.cantidad = cantidad;
            this.costePedido = costePedido;
        }

        public Integer getProveedor_id() {
            return proveedor_id;
        }

        public void setProveedor_id(Integer proveedor_id) {
            this.proveedor_id = proveedor_id;
        }

        public Integer getProducto_id() {
            return producto_id;
        }

        public void setProducto_id(Integer producto_id) {
            this.producto_id = producto_id;
        }

        public String getNombreProducto() {
            return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

        public Integer getCostePedido() {
            return costePedido;
        }

        public void setCostePedido(Integer costePedido) {
            this.costePedido = costePedido;
        }

        @Override
        public String toString() {
            return "Detalle{" +
                    "proveedor_id=" + proveedor_id +
                    ", producto_id=" + producto_id +
                    ", nombreProducto='" + nombreProducto + '\'' +
                    ", cantidad=" + cantidad +
                    ", costePedido=" + costePedido +
                    '}';
        }
    }
}
