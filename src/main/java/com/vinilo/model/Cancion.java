package com.vinilo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Cancion.buscarTodas", query = "SELECT c FROM Cancion c"),
    @NamedQuery(name = "Cancion.buscarPorId", query = "SELECT c FROM Cancion c WHERE c.id_cancion = :id"),
    @NamedQuery(name = "Cancion.buscarTodasConDetalles", query = "SELECT c FROM Cancion c JOIN FETCH c.artista JOIN FETCH c.album")
})
public class Cancion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cancion;
    private int nroOrden;
    private String nombre;
    private String duracion;
    private String url;
    private String letra;
    @ManyToOne
    @JoinColumn(name = "id_artista")
    private Artista artista;
    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;
    @ManyToOne
    @JoinColumn(name = "id_listaDeReproduccion")
    private ListaReproduccion listaDeReproduccion;

    public Long getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(Long id_cancion) {
        this.id_cancion = id_cancion;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public ListaReproduccion getListaDeReproduccion() {
        return listaDeReproduccion;
    }

    public void setListaDeReproduccion(ListaReproduccion listaDeReproduccion) {
        this.listaDeReproduccion = listaDeReproduccion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
