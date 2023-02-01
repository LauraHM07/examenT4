package com.laura.examen.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.examen.model.Grupo;
import com.laura.examen.repository.GrupoRepository;
import com.laura.examen.services.GruposService;

@Service
public class GruposServiceImpl implements GruposService{
    
    @Autowired
    GrupoRepository repository;

    @Override
    public Page<Grupo> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Grupo findById(int codigo) {
        Optional<Grupo> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Grupo grupo){
        repository.save(grupo);
    }

    @Override
    public void update(Grupo grupo) {
        repository.save(grupo);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
