package com.sabortostado.services;

import com.sabortostado.models.Proveedor;
import com.sabortostado.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }

    //CONSULTA PROVEDOOR PRODUCTO
    public List<Proveedor> getProveedoresPorProducto(int productoId) {
        return proveedorRepository.findProveedoresByProductoId(productoId);
    }

    //CONSULTA FILTRA POR PAIS
    public List<Proveedor> getProveedoresPorUbicacion(String ubicacion) {
        return proveedorRepository.findByUbicacion(ubicacion);
    }
}
