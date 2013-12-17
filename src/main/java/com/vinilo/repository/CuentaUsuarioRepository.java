package com.vinilo.repository;

import com.vinilo.model.CuentaUsuario;

public interface CuentaUsuarioRepository {

    public CuentaUsuario buscarUsuarioPorNombre(String nombre);
}
