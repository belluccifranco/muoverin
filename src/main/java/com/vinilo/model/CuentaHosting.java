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
public class CuentaHosting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cuentaHosting;
    private String url;
    private String usuario;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaHosting")
    private List<Album> albumes;

    public Long getId_cuentaHosting() {
        return id_cuentaHosting;
    }

    public void setId_cuentaHosting(Long id_cuentaHosting) {
        this.id_cuentaHosting = id_cuentaHosting;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }
}
