package com.laura.examen.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.examen.model.Grupo;

public interface GruposService {
    
    public Page<Grupo> findAll(Pageable page);

    public Grupo findById(int codigo);

    public void insert(Grupo permiso);

    public void update(Grupo permiso);

    public void delete(int codigo);
}
