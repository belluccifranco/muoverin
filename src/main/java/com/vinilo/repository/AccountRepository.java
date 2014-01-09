package com.vinilo.repository;

import com.vinilo.model.CuentaUsuario;

public interface AccountRepository {

    public CuentaUsuario searchByName(String name);
}
