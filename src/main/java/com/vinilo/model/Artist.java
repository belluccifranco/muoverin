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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@NamedQueries({
    @NamedQuery(name = "Artist.searchAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.searchById", query = "SELECT a FROM Artist a WHERE a.id_artist = :id"),
    @NamedQuery(name = "Artist.searchByName", query = "SELECT a FROM Artist a WHERE a.name = :name"),
    @NamedQuery(name = "Artist.searchByNameLike", query = "SELECT a FROM Artist a WHERE UPPER(a.name) LIKE :name")
})
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_artist;

    @NotNull
    @Length(min = 1, max = 200)
    private String name;

    private String info;

    @JoinTable(name = "artist_album",
        joinColumns = {@JoinColumn(name = "id_artist", referencedColumnName = "id_artist")},
        inverseJoinColumns = {@JoinColumn(name = "id_album", referencedColumnName = "id_album")})
    @ManyToMany
    private List<Album> albums;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public long getId_artist() {
        return id_artist;
    }

    public void setId_artist(long id_artist) {
        this.id_artist = id_artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return name;
    }
}
