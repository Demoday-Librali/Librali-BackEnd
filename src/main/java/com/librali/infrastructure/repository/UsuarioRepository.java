package com.librali.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librali.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
