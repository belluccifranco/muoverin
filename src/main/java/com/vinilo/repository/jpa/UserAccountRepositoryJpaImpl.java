package com.vinilo.repository.jpa;

import com.vinilo.model.UserAccount;
import com.vinilo.repository.AccountRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepositoryJpaImpl implements AccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserAccount searchByName(String name) {
        TypedQuery<UserAccount> query = em.createNamedQuery("UserAccount.searchByName", UserAccount.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
