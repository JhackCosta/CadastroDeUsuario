package com.controleUsuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleUsuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
