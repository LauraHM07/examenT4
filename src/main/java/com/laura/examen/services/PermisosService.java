package com.laura.examen.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.examen.model.Permiso;

public interface PermisosService {
    
    public Page<Permiso> findAll(Pageable page);

    public Permiso findById(int codigo);

    public void insert(Permiso permiso);

    public void update(Permiso permiso);

    public void delete(int codigo);
}
