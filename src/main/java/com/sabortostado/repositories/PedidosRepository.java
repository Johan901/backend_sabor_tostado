package com.sabortostado.repositories;

import com.sabortostado.models.Pedidos;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


public interface PedidosRepository extends MongoRepository<Pedidos, Integer> {

    //CONSULTA 2
    @Query("{ 'detalle.proveedor_id' : ?0 }")
    List<Pedidos> findPedidosByProveedorId(Integer proveedorId);

    //CONSULTA 4
    List<Pedidos> findByEstadoEnvio(String estadoEnvio);

    //CONSULTA FACTURAS
    Pedidos findByNumeroFactura(Integer numeroFactura);

    //PEDIDOS X DIA
    @Query("{ 'fechaPedido' : ?0 }")
    List<Pedidos> findPedidosByFechaPedido(Date fechaPedido);

    //PEDIDOS X CLIENTE
    @Query("{ 'cliente_id' : ?0 }")
    List<Pedidos> findPedidosByClienteId(Integer clienteId);
}

