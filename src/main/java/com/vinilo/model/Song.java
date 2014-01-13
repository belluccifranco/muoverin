package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "Song.searchAllSongs", query = "SELECT s FROM Song s"),
    @NamedQuery(name = "Song.searchById", query = "SELECT s FROM Song s JOIN FETCH s.links WHERE s.id_song = :id")
})
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_song;

    private int track;

    private String name;

    private String duration;

    private String lyric;

    @ManyToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "song")
    private List<Link> links;

    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;

    public Long getId_song() {
        return id_song;
    }

    public void setId_song(Long id_song) {
        this.id_song = id_song;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return name;
    }
}
