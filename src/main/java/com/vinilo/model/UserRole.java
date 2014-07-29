package com.vinilo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_userRole;

    private String name;

    @ManyToMany(mappedBy = "userRoles")
    private List<UserAccount> userAccounts;

    public UserRole() {
    }   

    public UserRole(String name) {
        this.name = name;
    }

    public long getId_UserRole() {
        return id_userRole;
    }

    public void setId_UserRole(long id_userRole) {
        this.id_userRole = id_userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

}
