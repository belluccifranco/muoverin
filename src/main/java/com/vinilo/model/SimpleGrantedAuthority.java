package com.vinilo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class SimpleGrantedAuthority implements GrantedAuthority {

    private String rol;

    public SimpleGrantedAuthority(String rol) {
        Assert.hasText(rol, "A granted authority textual representation is required");
        this.rol = rol;
    }

    @Override
    public String getAuthority() {
        return rol;
    }
}
