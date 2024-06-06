package com.sabortostado.repositories;

import com.sabortostado.models.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Date;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.domain.Sort;
import com.sabortostado.dtos.ProductoDTO;


import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, Integer> {
    // Agrega este método para encontrar productos con stock bajo
    List<Producto> findByStockLessThan(int stockThreshold);

    //CONSULTA COMENTARIOS
    @Query("{ 'comentarios.fechaComment': { $gt: ?0 } }")
    List<Producto> findByComentariosFechaCommentAfter(Date fecha);

    //ESTADO STOCK
    @Query(value = "{}", fields = "{'nombreProducto': 1, 'stock': 1, '_id': 0}", sort = "{'nombreProducto': 1}")
    List<ProductoDTO> findProductosConEstadoDeStock();

}
