package com.sabortostado.controllers;

import com.sabortostado.models.Proveedor;
import com.sabortostado.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable Integer id) {
        return proveedorService.getProveedorById(id);
    }

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.saveProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        // Logic to update the provider based on the ID and the provided provider data
        return proveedorService.saveProveedor(proveedor);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable Integer id) {
        proveedorService.deleteProveedor(id);
    }

    //CONSULTA PROVEDOOR PRODUCOT
    @GetMapping("/producto/{productoId}")
    public List<Proveedor> getProveedoresPorProducto(@PathVariable int productoId) {
        return proveedorService.getProveedoresPorProducto(productoId);
    }

    //CONSULTA FILTRAR POR PAIS
    @GetMapping("/por-ubicacion")
    public List<Proveedor> getProveedoresPorUbicacion(@RequestParam String ubicacion) {
        return proveedorService.getProveedoresPorUbicacion(ubicacion);
    }
}
