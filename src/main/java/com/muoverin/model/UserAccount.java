package com.muoverin.model;

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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({
    @NamedQuery(name = "UserAccount.searchByUsername", query = "SELECT ua FROM UserAccount ua JOIN FETCH ua.userRoles WHERE ua.username = :username"),
    @NamedQuery(name = "UserAccount.searchAll", query = "SELECT ua FROM UserAccount ua"),
    @NamedQuery(name = "UserAccount.searchById", query = "SELECT ua FROM UserAccount ua JOIN FETCH ua.userRoles WHERE ua.id_userAccount = :id")
})
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_userAccount;

    @Email
    @NotEmpty
    @Length(max = 250)
    private String username;

    @NotEmpty
    @Length(max = 250)
    private String password;

    @NotEmpty
    @Length(max = 250)
    private String cpassword;

    @JoinTable(name = "userAccount_userRole",
            joinColumns = {
                @JoinColumn(name = "id_userAccount", referencedColumnName = "id_userAccount")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_userRole", referencedColumnName = "id_userRole")})
    @ManyToMany(cascade = {CascadeType.MERGE})
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "userAccount")
    private List<Playlist> playlists;

    public UserAccount() {
    }

    public UserAccount(String username, String password, String cpassword, List<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.cpassword = cpassword;
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

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
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
