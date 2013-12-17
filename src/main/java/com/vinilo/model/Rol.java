package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rol"})})
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Rol;
    private String rol;
    @ManyToMany(mappedBy = "roles")
    private List<CuentaUsuario> cuentasUsuario;

    public Rol() {
    }

    public Rol(String rol) {
        this.rol = rol;
    }

    public Long getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(Long id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<CuentaUsuario> getCuentasUsuario() {
        return cuentasUsuario;
    }

    public void setCuentasUsuario(List<CuentaUsuario> cuentasUsuario) {
        this.cuentasUsuario = cuentasUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Rol != null ? id_Rol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.id_Rol == null && other.id_Rol != null) || (this.id_Rol != null && !this.id_Rol.equals(other.id_Rol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rol;
    }
}
