package com.laura.examen.services;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.examen.model.Permiso;

public interface PermisosService {

    public List<Permiso> findAll();

    public Page<Permiso> findAll(Pageable page);

    public Permiso findById(int codigo);

    public void insert(Permiso permiso);

    public void update(Permiso permiso);

    public void delete(int codigo);
}
