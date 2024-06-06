package com.sabortostado.controllers;

import com.sabortostado.models.Producto;
import com.sabortostado.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sabortostado.models.Pedidos;
import com.sabortostado.models.Pedidos.Detalle;
import com.sabortostado.services.PedidosService;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import com.sabortostado.dtos.ProductoDTO;



import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        // Logic to update the product based on the ID and the provided product data
        return productoService.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }
// CONSULTA 1
    @GetMapping("/stock-bajo")
    public List<Producto> getProductosConStockBajo(@RequestParam(defaultValue = "130") int umbral) {
        return productoService.findProductosConStockBajo(umbral);
    }

// Endpoint para obtener productos por ID de proveedor
// Consulta 2
    @GetMapping("/productos/proveedor/{proveedorId}")
    public List<Pedidos.Detalle> getProductosPorProveedor(@PathVariable Integer proveedorId) {
        return pedidosService.obtenerProductosPorProveedor(proveedorId);
    }

    //CONSULTA COMENTARIOS
    @GetMapping("/comentarios-recientes")
    public List<Producto> getProductosConComentariosRecientes(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        return productoService.getProductosConComentariosRecientes(fecha);
    }

    //ESTADO STOCK
    @GetMapping("/estado-stock")
    public List<ProductoDTO> getEstadoDeStockDeProductos() {
        return productoService.getEstadoDeStockDeProductos();
    }
}
