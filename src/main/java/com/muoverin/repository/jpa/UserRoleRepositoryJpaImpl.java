package com.muoverin.repository.jpa;

import com.muoverin.model.UserRole;
import com.muoverin.repository.UserRoleRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepositoryJpaImpl implements UserRoleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserRole searchByName(String name) {
        TypedQuery<UserRole> query = em.createNamedQuery("UserRole.searchByName", UserRole.class);
        query.setParameter("name", name.toUpperCase());
        List<UserRole> userRoles = query.getResultList();
        if (userRoles.isEmpty()) {
            return null;
        } else {
            return userRoles.get(0);
        }
    }

    @Override
    public UserRole save(UserRole userRole) {
        return em.merge(userRole);
    }

    @Override
    public void remove(UserRole userRole) {
        UserRole mergedUserRole = em.merge(userRole);
        em.remove(mergedUserRole);
    }

    @Override
    public List<UserRole> searchAll() {
        return em.createNamedQuery("UserRole.searchAll", UserRole.class).getResultList();
    }

    @Override
    public UserRole searchById(long id) {
        TypedQuery<UserRole> query = em.createNamedQuery("UserRole.searchById", UserRole.class);
        query.setParameter("id", id);
        List<UserRole> userRoles = query.getResultList();
        if (userRoles.isEmpty()) {
            return null;
        } else {
            return userRoles.get(0);
        }
    }

}
