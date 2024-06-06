package com.sabortostado.controllers;

import com.sabortostado.models.Pedidos;
import com.sabortostado.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public List<Pedidos> getAllPedidos() {
        return pedidosService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Pedidos getPedidoById(@PathVariable Integer id) {
        return pedidosService.getPedidoById(id);
    }

    @PostMapping
    public Pedidos createPedido(@RequestBody Pedidos pedido) {
        return pedidosService.savePedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedidos updatePedido(@PathVariable Integer id, @RequestBody Pedidos pedido) {
        // Logic to update the order based on the ID and the provided order data
        return pedidosService.savePedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Integer id) {
        pedidosService.deletePedido(id);
    }

    //CONSULTA 4
    @GetMapping("/envios-pendientes")
    public List<Pedidos> getPedidosConEnvioPendiente() {
        return pedidosService.getPedidosConEnvioPendiente();
    }

    //CONSULTA FACTURAS
    @GetMapping("/numero-factura/{numeroFactura}")
    public Pedidos obtenerPedidoPorNumeroFactura(@PathVariable Integer numeroFactura) {
        return pedidosService.obtenerPedidoPorNumeroFactura(numeroFactura);
    }

    //PEDIDOS X DIA
    @GetMapping("/ventas-en-dia")
    public List<Pedidos> getVentasEnDia(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaPedido) {
        return pedidosService.getVentasEnDia(fechaPedido);
    }

    //PEDIDOS X CLIENTE
    @GetMapping("/pedidos-por-cliente/{clienteId}")
    public List<Pedidos> getPedidosPorCliente(@PathVariable Integer clienteId) {
        return pedidosService.getPedidosPorCliente(clienteId);
    }
}
