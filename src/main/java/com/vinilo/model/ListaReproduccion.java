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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "ListaReproduccion.buscarTodas", query = "SELECT lr FROM ListaReproduccion lr"),
    @NamedQuery(name = "ListaReproduccion.buscarPorId", query = "SELECT lr FROM ListaReproduccion lr WHERE lr.id_listaDeReproduccion = :id")
})
public class ListaReproduccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_listaDeReproduccion;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaDeReproduccion")
    private List<Cancion> canciones;
    @ManyToOne
    @JoinColumn(name = "id_cuentaUsuario")
    private CuentaUsuario cuentaUsuario;

    public Long getId_listaDeReproduccion() {
        return id_listaDeReproduccion;
    }

    public void setId_listaDeReproduccion(Long id_listaDeReproduccion) {
        this.id_listaDeReproduccion = id_listaDeReproduccion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_listaDeReproduccion != null ? id_listaDeReproduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ListaReproduccion)) {
            return false;
        }
        ListaReproduccion other = (ListaReproduccion) object;
        if ((this.id_listaDeReproduccion == null && other.id_listaDeReproduccion != null) || (this.id_listaDeReproduccion != null && !this.id_listaDeReproduccion.equals(other.id_listaDeReproduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
