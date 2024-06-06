package com.sabortostado.repositories;

import com.sabortostado.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
}
