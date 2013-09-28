package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CuentaUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cuentaUsuario;
    private String email;
    private int pin;
    private int cantidadIntentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaUsuario")
    private List<ListaDeReproduccion> listasDeReproduccion;

    public Long getId_cuentaUsuario() {
        return id_cuentaUsuario;
    }

    public void setId_cuentaUsuario(Long id_cuentaUsuario) {
        this.id_cuentaUsuario = id_cuentaUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public void setCantidadIntentos(int cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos;
    }

    public List<ListaDeReproduccion> getListasDeReproduccion() {
        return listasDeReproduccion;
    }

    public void setListasDeReproduccion(List<ListaDeReproduccion> listasDeReproduccion) {
        this.listasDeReproduccion = listasDeReproduccion;
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

    @Override
    public String toString() {
        return email;
    }
}
