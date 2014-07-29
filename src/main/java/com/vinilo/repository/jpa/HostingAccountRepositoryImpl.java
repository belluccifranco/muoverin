package com.vinilo.repository.jpa;

import com.vinilo.model.HostingAccount;
import com.vinilo.repository.HostingAccountRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class HostingAccountRepositoryImpl implements HostingAccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<HostingAccount> searchAll() {
        return em.createNamedQuery("HostingAccount.searchAll", HostingAccount.class).getResultList();
    }

    @Override
    public HostingAccount searchById(long id) {
        TypedQuery<HostingAccount> query = em.createNamedQuery("HostingAccount.searchById", HostingAccount.class);
        query.setParameter("id", id);
        List<HostingAccount> hostingAccounts = query.getResultList();
        if (hostingAccounts.isEmpty()) {
            return null;
        } else {
            return hostingAccounts.get(0);
        }
    }

    @Override
    public HostingAccount save(HostingAccount hostingAccount) {
        return em.merge(hostingAccount);
    }

    @Override
    public void remove(HostingAccount hostingAccount) {
        HostingAccount mergedHostingAccount = em.merge(hostingAccount);
        em.remove(mergedHostingAccount);
    }

    @Override
    public HostingAccount searchByUsername(String username) {
        TypedQuery<HostingAccount> query = em.createNamedQuery("HostingAccount.searchByUsername", HostingAccount.class);
        query.setParameter("username", username);
        List<HostingAccount> hostingAccounts = query.getResultList();
        if (hostingAccounts.isEmpty()) {
            return null;
        } else {
            return hostingAccounts.get(0);
        }
    }

}
