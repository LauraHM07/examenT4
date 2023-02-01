package com.laura.examen.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.examen.model.Usuario;
import com.laura.examen.repository.UsuarioRepository;
import com.laura.examen.services.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{
    
    @Autowired
    UsuarioRepository repository;

    @Override
    public Page<Usuario> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Usuario findById(int codigo) {
        Optional<Usuario> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Usuario usuario){
        repository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
