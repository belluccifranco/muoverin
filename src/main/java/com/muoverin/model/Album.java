package com.muoverin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


@Entity
@NamedQueries({
    @NamedQuery(name = "Album.searchAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.searchById", query = "SELECT a FROM Album a JOIN FETCH a.songs WHERE a.id_album = :id"),
    @NamedQuery(name = "Album.searchByName", query = "SELECT a FROM Album a WHERE a.name = :name"),
    @NamedQuery(name = "Album.searchByArtist", query = "SELECT alb FROM Album alb JOIN alb.artists art WHERE art.id_artist IN (:artists_id) AND alb.id_album IN (SELECT alb2.id_album FROM Album alb2 JOIN alb2.artists art2 GROUP BY alb2 HAVING count(art2) = :artists_count) GROUP BY alb HAVING count(art) = :artists_count")
})
public class Album implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_album;

    @NotNull
    @Length(min = 1, max = 200)
    private String name;

    private int releaseYear;

    private int numberOfSongs;

    @Valid
    @ManyToMany(mappedBy = "albums", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Artist> artists;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album() {
    }

    public Album(String name, int releaseYear, int numberOfSongs) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.numberOfSongs = numberOfSongs;
    }

    public long getId_album() {
        return id_album;
    }

    public void setId_album(long id_album) {
        this.id_album = id_album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return name;
    }
}
