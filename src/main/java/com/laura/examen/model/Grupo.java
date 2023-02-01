package com.laura.examen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;

@Entity
public class Grupo {
    @Id
    @GeneratedValue
    private int codigo;
    private String nombre;

    // @ManyToOne
    // private Usuario usuario;

    public Grupo() {
    }

    public Grupo(int codigo) {
        this.codigo = codigo;
    }

    public Grupo(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public Usuario getUsuario() {
    //     return usuario;
    // }

    // public void setUsuario(Usuario usuario) {
    //     this.usuario = usuario;
    // } 

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
        Grupo other = (Grupo) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}