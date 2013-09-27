package com.vinilo.service;

import com.vinilo.model.CuentaUsuario;

public interface CuentaUsuarioService {

    public void login();

    public void logout();

    public CuentaUsuario guardar(CuentaUsuario cuentaUsuario);
}
