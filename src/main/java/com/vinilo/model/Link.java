package com.vinilo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_link;

    private String url;

    @ManyToOne
    @JoinColumn(name = "id_hostingAccount")
    private HostingAccount hostingAccount;

    @ManyToOne
    @JoinColumn(name = "id_song")
    private Song song;

    public Long getId_link() {
        return id_link;
    }

    public void setId_link(Long id_link) {
        this.id_link = id_link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HostingAccount getHostingAccount() {
        return hostingAccount;
    }

    public void setHostingAccount(HostingAccount hostingAccount) {
        this.hostingAccount = hostingAccount;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

}
