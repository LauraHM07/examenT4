package com.laura.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.examen.model.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Integer>{
    
}
