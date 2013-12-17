package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "CuentaUsuario.buscarUsuarioPorNombre", query = "SELECT cu FROM CuentaUsuario cu JOIN FETCH cu.roles WHERE cu.nombreUsuario = :nombre")
})
public class CuentaUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cuentaUsuario;
    
    private String nombreUsuario;
    
    private String contrasenia;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "cuentaUsuario_rol", joinColumns = {
        @JoinColumn(name = "id_cuentaUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol")})
    private List<Rol> roles;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaUsuario")
    private List<ListaReproduccion> listasDeReproduccion;

    public Long getId_cuentaUsuario() {
        return id_cuentaUsuario;
    }

    public void setId_cuentaUsuario(Long id_cuentaUsuario) {
        this.id_cuentaUsuario = id_cuentaUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<ListaReproduccion> getListasDeReproduccion() {
        return listasDeReproduccion;
    }

    public void setListasDeReproduccion(List<ListaReproduccion> listasDeReproduccion) {
        this.listasDeReproduccion = listasDeReproduccion;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cuentaUsuario != null ? id_cuentaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CuentaUsuario)) {
            return false;
        }
        CuentaUsuario other = (CuentaUsuario) object;
        if ((this.id_cuentaUsuario == null && other.id_cuentaUsuario != null) || (this.id_cuentaUsuario != null && !this.id_cuentaUsuario.equals(other.id_cuentaUsuario))) {
            return false;
        }
        return true;
    }
}
