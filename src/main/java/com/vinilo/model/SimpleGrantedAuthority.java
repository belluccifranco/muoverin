package com.vinilo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class SimpleGrantedAuthority implements GrantedAuthority {

    private final String roleName;

    public SimpleGrantedAuthority(String roleName) {
        Assert.hasText(roleName, "Role name cannot be null or empty");
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}
