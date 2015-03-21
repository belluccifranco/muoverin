package com.muoverin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Entity
@NamedQueries({
    @NamedQuery(name = "HostingAccount.searchAll", query = "SELECT ha FROM HostingAccount ha"),
    @NamedQuery(name = "HostingAccount.searchById", query = "SELECT ha FROM HostingAccount ha JOIN FETCH ha.links WHERE ha.id_hostingAccount = :id"),
    @NamedQuery(name = "HostingAccount.searchByUsername", query = "SELECT ha FROM HostingAccount ha WHERE ha.username = :username")
})
public class HostingAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_hostingAccount;

    @URL
    @NotNull
    @Length(min = 1, max = 250)
    private String url;

    @NotNull
    @Email
    @Length(min = 1, max = 200)
    private String username;

    @NotNull
    @Length(min = 1, max = 200)
    private String password;

    @OneToMany(mappedBy = "hostingAccount", cascade = CascadeType.REMOVE)
    private List<Link> links;

    public HostingAccount() {
    }

    public HostingAccount(String url, String username, String password) {        
        this.url = url;
        this.username = username;
        this.password = password;        
    }

    public long getId_hostingAccount() {
        return id_hostingAccount;
    }

    public void setId_hostingAccount(long id_hostingAccount) {
        this.id_hostingAccount = id_hostingAccount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
