package com.laura.examen.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private int codigo;
    private String nombre;
    private String email;

    @ManyToMany
	@JoinTable(
		name="usuario_permiso"
		, joinColumns={
			@JoinColumn(name="usuario_codigo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permiso_codigo")
			}
		)
    private List<Permiso> permisos;

    public Usuario() {
    }

    public Usuario(int codigo) {
        this.codigo = codigo;
    }

    public Usuario(int codigo, String nombre, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return nombre;
    }

    public void setDescripcion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
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
        Usuario other = (Usuario) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}