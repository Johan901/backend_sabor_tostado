package com.sabortostado.services;

import com.sabortostado.models.Producto;
import com.sabortostado.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.sabortostado.dtos.ProductoDTO;

import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    // Método para encontrar productos con stock bajo
    public List<Producto> findProductosConStockBajo(int umbral) {
        return productoRepository.findByStockLessThan(umbral);
    }

    //CONSULTA COMENTARIOS
    public List<Producto> getProductosConComentariosRecientes(Date fecha) {
        return productoRepository.findByComentariosFechaCommentAfter(fecha);
    }

    //ESTADO STOCK
    public List<ProductoDTO> getEstadoDeStockDeProductos() {
        return productoRepository.findProductosConEstadoDeStock();
    }

}
