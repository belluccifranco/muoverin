package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_album;
    private String nombre;
    private int anio;
    private int cantCanciones;
    @ManyToOne
    @JoinColumn(name = "id_cuentaHosting")
    private CuentaHosting cuentaHosting;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Cancion> canciones;

    public Long getId_album() {
        return id_album;
    }

    public void setId_album(Long id_album) {
        this.id_album = id_album;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantCanciones() {
        return cantCanciones;
    }

    public void setCantCanciones(int cantCanciones) {
        this.cantCanciones = cantCanciones;
    }

    public CuentaHosting getCuentaHosting() {
        return cuentaHosting;
    }

    public void setCuentaHosting(CuentaHosting cuentaHosting) {
        this.cuentaHosting = cuentaHosting;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
