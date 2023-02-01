package com.laura.examen.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.examen.model.Permiso;
import com.laura.examen.repository.PermisoRepository;
import com.laura.examen.services.PermisosService;

@Service
public class PermisosServiceImpl implements PermisosService{
    
    @Autowired
    PermisoRepository repository;

    @Override
    public Page<Permiso> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Permiso findById(int codigo) {
        Optional<Permiso> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Permiso permiso){
        repository.save(permiso);
    }

    @Override
    public void update(Permiso permiso) {
        repository.save(permiso);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
