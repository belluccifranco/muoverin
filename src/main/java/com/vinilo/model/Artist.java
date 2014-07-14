package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@NamedQueries({
    @NamedQuery(name = "Artist.searchAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.searchById", query = "SELECT a FROM Artist a WHERE a.id_artist = :id")    
})
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_artist;

    @NotNull
    @Length(min = 1, max = 200)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
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
