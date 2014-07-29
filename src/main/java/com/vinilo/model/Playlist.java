package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
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
    @NamedQuery(name = "Playlist.searchAll", query = "SELECT pl FROM Playlist pl JOIN FETCH pl.songs"),
    @NamedQuery(name = "Playlist.searchById", query = "SELECT pl FROM Playlist pl JOIN FETCH pl.songs WHERE pl.id_playlist = :id")
})
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_playlist;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_userAccount")
    private UserAccount userAccount;

    @JoinTable(name = "playlist_song",
        joinColumns = {@JoinColumn(name = "id_playlist", referencedColumnName = "id_playlist")},
        inverseJoinColumns = {@JoinColumn(name = "id_song", referencedColumnName = "id_song")})
    @ManyToMany
    private List<Song> songs;

    public Playlist() {
    }

    public Playlist(String name, UserAccount userAccount, List<Song> songs) {        
        this.name = name;
        this.userAccount = userAccount;
        this.songs = songs;
    }

    public long getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(long id_playlist) {
        this.id_playlist = id_playlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}
