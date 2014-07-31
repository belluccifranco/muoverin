package com.vinilo.repository.jpa;

import com.vinilo.model.UserAccount;
import com.vinilo.repository.UserAccountRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepositoryJpaImpl implements UserAccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserAccount searchByName(String name) {
        TypedQuery<UserAccount> query = em.createNamedQuery("UserAccount.searchByName", UserAccount.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return em.merge(userAccount);
    }
}