package com.muoverin.repository.jpa;

import com.muoverin.model.UserAccount;
import com.muoverin.repository.UserAccountRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepositoryJpaImpl implements UserAccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserAccount searchByUsername(String username) {
        TypedQuery<UserAccount> query = em.createNamedQuery("UserAccount.searchByUsername", UserAccount.class);
        query.setParameter("username", username);
        List<UserAccount> userAccounts = query.getResultList();
        if (userAccounts.isEmpty()) {
            return null;
        } else {
            return userAccounts.get(0);
        }
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return em.merge(userAccount);
    }

    @Override
    public void remove(UserAccount userAccount) {
        UserAccount mergedUserAccount = em.merge(userAccount);
        em.remove(mergedUserAccount);
    }

    @Override
    public List<UserAccount> searchAll() {
        return em.createNamedQuery("UserAccount.searchAll", UserAccount.class).getResultList();
    }

    @Override
    public UserAccount searchById(long id) {
        TypedQuery<UserAccount> query = em.createNamedQuery("UserAccount.searchById", UserAccount.class);
        query.setParameter("id", id);
        List<UserAccount> userAccounts = query.getResultList();
        if (userAccounts.isEmpty()) {
            return null;
        } else {
            return userAccounts.get(0);
        }
    }

}
