package com.vinilo.service;

import com.vinilo.controller.ReproductorController;
import com.vinilo.model.CuentaUsuario;
import com.vinilo.model.Rol;
import com.vinilo.model.SimpleGrantedAuthority;
import com.vinilo.repository.CuentaUsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class CuentaUsuarioServiceImpl implements UserDetailsService {

    private final CuentaUsuarioRepository cuentaUsuarioRepository;
    private static final Logger logger = Logger.getLogger(CuentaUsuarioServiceImpl.class);

    @Autowired
    public CuentaUsuarioServiceImpl(CuentaUsuarioRepository cuentaUsuarioRepository) {
        this.cuentaUsuarioRepository = cuentaUsuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CuentaUsuario cuentaUsuario = null;
        try {
            cuentaUsuario = cuentaUsuarioRepository.buscarUsuarioPorNombre(username);
        } catch (NoResultException ex) {
            logger.error(ex.getMessage());
            throw new UsernameNotFoundException("");            
        }
        return this.construirUsuario(cuentaUsuario);
    }

    private User construirUsuario(CuentaUsuario cuentaUsuario) {
        String username = cuentaUsuario.getNombreUsuario();
        String password = cuentaUsuario.getContrasenia();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Rol role : cuentaUsuario.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRol()));
        }
        User user = new User(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
