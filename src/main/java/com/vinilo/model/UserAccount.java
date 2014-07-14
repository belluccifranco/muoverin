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
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "UserAccount.searchByName", query = "SELECT ua FROM UserAccount ua JOIN FETCH ua.userRoles WHERE ua.username = :name")
})
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_userAccount;

    private String username;

    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})    
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<Playlist> playlists;

    public UserAccount() {
    }

    public UserAccount(String username, String password, List<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }

    public long getId_userAccount() {
        return id_userAccount;
    }

    public void setId_userAccount(long id_userAccount) {
        this.id_userAccount = id_userAccount;
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

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

}
