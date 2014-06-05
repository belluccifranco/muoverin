package com.vinilo.service;

import com.vinilo.model.UserAccount;
import com.vinilo.model.UserRole;
import com.vinilo.model.SimpleGrantedAuthority;
import com.vinilo.repository.AccountRepository;
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
public class AccountServiceImpl implements UserDetailsService, AccountService {

    private final AccountRepository accountRepository;
    private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = null;
        try {
            account = accountRepository.searchByName(username);
        } catch (NoResultException ex) {
            logger.error(ex.getMessage());
            throw new UsernameNotFoundException("");            
        }
        return this.buildUser(account);
    }

    private User buildUser(UserAccount userAccount) {
        String username = userAccount.getUsername();
        String password = userAccount.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (UserRole role : userAccount.getUserRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        User user = new User(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }

    @Override
    @Transactional
    public UserAccount save(UserAccount userAccount) {
        return accountRepository.save(userAccount);
    }
}
