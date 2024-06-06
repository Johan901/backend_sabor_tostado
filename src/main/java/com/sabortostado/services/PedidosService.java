package com.sabortostado.services;

import com.sabortostado.models.Pedidos;
import com.sabortostado.repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabortostado.models.Pedidos;
import com.sabortostado.models.Pedidos.Detalle;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.List;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Pedidos> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    public Pedidos getPedidoById(Integer id) {
        return pedidosRepository.findById(id).orElse(null);
    }

    public Pedidos savePedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    public void deletePedido(Integer id) {
        pedidosRepository.deleteById(id);
    }

//CONSULTA 2.
    public List<Detalle> obtenerProductosPorProveedor(Integer proveedorId) {
        List<Pedidos> pedidos = pedidosRepository.findPedidosByProveedorId(proveedorId);
        List<Detalle> productos = new ArrayList<>();

        for (Pedidos pedido : pedidos) {
            for (Detalle detalle : pedido.getDetalle()) {
                if (detalle.getProveedor_id().equals(proveedorId)) {
                    productos.add(detalle);
                }
            }
        }

        return productos;
    }

    //CONSULTA 4
    public List<Pedidos> getPedidosConEnvioPendiente() {
        return pedidosRepository.findByEstadoEnvio("Por enviar");
    }

    //CONSULTA FACTURA
    public Pedidos obtenerPedidoPorNumeroFactura(Integer numeroFactura) {
        return pedidosRepository.findByNumeroFactura(numeroFactura);
    }

    //PEDIDOS X DIA
    public List<Pedidos> getVentasEnDia(Date fechaPedido) {
        return pedidosRepository.findPedidosByFechaPedido(fechaPedido);
    }

    //PEDIDOS X CLIENTE
    public List<Pedidos> getPedidosPorCliente(Integer clienteId) {
        return pedidosRepository.findPedidosByClienteId(clienteId);
    }
}
