package com.muoverin.service;

import com.muoverin.model.UserAccount;
import com.muoverin.model.UserRole;
import com.muoverin.model.SimpleGrantedAuthority;
import com.muoverin.repository.UserAccountRepository;
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
public class UserAccountServiceImpl implements UserDetailsService, UserAccountService {

    private final UserAccountRepository accountRepository;
    private static final Logger logger = Logger.getLogger(UserAccountServiceImpl.class);

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository accountRepository) {
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

    @Override
    public void remove(UserAccount userAccount) {
        accountRepository.remove(userAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAccount> searchAll() {
        return accountRepository.searchAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserAccount searchById(long id) {
        return accountRepository.searchById(id);
    }
}
