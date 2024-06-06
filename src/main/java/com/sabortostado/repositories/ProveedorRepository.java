package com.sabortostado.repositories;

import com.sabortostado.models.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProveedorRepository extends MongoRepository<Proveedor, Integer> {

    //CONSULTA PROVEEDOR PRODUCTO
     @Query("{ 'productos': ?0 }")
    List<Proveedor> findProveedoresByProductoId(int productoId);

    //CONSULTA FILTRAR POR PAIS
    @Query("{ 'ubicacion': ?0 }")
    List<Proveedor> findByUbicacion(String ubicacion);
}
