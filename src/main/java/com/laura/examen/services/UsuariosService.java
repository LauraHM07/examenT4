package com.laura.examen.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.examen.model.Usuario;

public interface UsuariosService {
    
    public Page<Usuario> findAll(Pageable page);

    public Usuario findById(int codigo);

    public void insert(Usuario usuario);

    public void update(Usuario usuario);

    public void delete(int codigo);
}
