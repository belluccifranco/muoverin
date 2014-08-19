package com.vinilo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Entity
public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_link;

    @URL
    @NotNull
    @Length(min = 1, max = 250)
    private String url;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_hostingAccount")
    private HostingAccount hostingAccount;

    @OneToOne(mappedBy = "link")
    private Song song;

    public Link() {
    }

    public Link(String url, HostingAccount hostingAccount) {        
        this.url = url;
        this.hostingAccount = hostingAccount;        
    }

    public long getId_link() {
        return id_link;
    }

    public void setId_link(long id_link) {
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
