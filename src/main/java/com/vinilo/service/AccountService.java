package com.vinilo.service;

import com.vinilo.model.CuentaUsuario;

public interface AccountService {

    public void login();

    public void logout();

    public CuentaUsuario save(CuentaUsuario account);
}
