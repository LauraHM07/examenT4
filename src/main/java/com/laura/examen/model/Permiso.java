package com.laura.examen.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Permiso {
    @Id
    @GeneratedValue
    private int codigo;
    private String descripcion;

    @Transient 
    private boolean tieneUsuario;

	@ManyToMany(mappedBy = "permisos")
    private List<Usuario> usuarios;

    public Permiso() {
    }

    public Permiso(int codigo) {
        this.codigo = codigo;
    }

    public Permiso(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 

    public boolean isTieneUsuario() {
        return tieneUsuario;
    }

    public void setTieneUsuario(boolean tieneUsuario) {
        this.tieneUsuario = tieneUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Permiso other = (Permiso) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}