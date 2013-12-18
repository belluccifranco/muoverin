package com.vinilo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class SimpleGrantedAuthority implements GrantedAuthority {

    private String rol;

    public SimpleGrantedAuthority(String rol) {
        Assert.hasText(rol, "El nombre del rol no debe estar vacio.");
        this.rol = rol;
    }

    @Override
    public String getAuthority() {
        return rol;
    }
}
