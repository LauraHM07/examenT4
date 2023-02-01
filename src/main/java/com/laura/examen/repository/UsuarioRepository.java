package com.laura.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.examen.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
