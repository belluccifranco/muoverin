package com.muoverin.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({
    @NamedQuery(name = "Song.allSongs", query = "SELECT s FROM Song s"),
    @NamedQuery(name = "Song.songByNameAndAlbum", query = "SELECT s FROM Song s WHERE UPPER(s.name) = :name AND s.album.id_album = :id_album"),
    @NamedQuery(name = "Song.songById", query = "SELECT s FROM Song s JOIN FETCH s.link WHERE s.id_song = :id"),
    @NamedQuery(name = "Song.songsByCriteria", query = "SELECT son FROM Song son JOIN son.album alb JOIN alb.artists art "
            + "WHERE UPPER(son.name) LIKE :songName OR UPPER(son.album.name) LIKE :albumName OR UPPER(art.name) LIKE :artistName"),
    @NamedQuery(name = "Song.countCriteria", query = "SELECT count(son) FROM Song son JOIN son.album alb JOIN alb.artists art "
            + "WHERE UPPER(son.name) LIKE :songName OR UPPER(son.album.name) LIKE :albumName OR UPPER(art.name) LIKE :artistName")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_song")
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_song;

    @Pattern(regexp = "^\\s*\\d*\\s*$")
    private String track;

    @NotEmpty
    @Length(max = 250)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;

    @NotNull
    @Valid
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_link")
    private Link link;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    private List<Playlist> playlists;

    public Song() {
    }

    public Song(String track, String name, Album album, Link link) {
        this.track = track;
        this.name = name;
        this.album = album;
        this.link = link;
    }

    public long getId_song() {
        return id_song;
    }

    public void setId_song(long id_song) {
        this.id_song = id_song;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
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
