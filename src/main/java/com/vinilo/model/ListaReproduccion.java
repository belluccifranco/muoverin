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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "ListaReproduccion.buscarTodas", query = "SELECT lr FROM ListaReproduccion lr JOIN FETCH lr.canciones"),
    @NamedQuery(name = "ListaReproduccion.buscarPorId", query = "SELECT lr FROM ListaReproduccion lr JOIN FETCH lr.canciones WHERE lr.id_listaReproduccion = :id")
})
public class ListaReproduccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_listaReproduccion;
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "id_cuentaUsuario")
    private CuentaUsuario cuentaUsuario;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "listaReproduccion_cancion", joinColumns = {
        @JoinColumn(name = "id_listaReproduccion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_cancion")})
    private List<Cancion> canciones;

    public Long getId_listaReproduccion() {
        return id_listaReproduccion;
    }

    public void setId_listaReproduccion(Long id_listaReproduccion) {
        this.id_listaReproduccion = id_listaReproduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public CuentaUsuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }
}
