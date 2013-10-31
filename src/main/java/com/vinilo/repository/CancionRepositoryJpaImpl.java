package com.vinilo.repository;

import com.vinilo.model.Cancion;
import com.vinilo.model.CancionBusquedaCriteria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class CancionRepositoryJpaImpl implements CancionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cancion> buscarTodas() {
        List<Cancion> canciones = em.createNamedQuery("Cancion.buscarTodas", Cancion.class).getResultList();
        return canciones;
    }

    @Override
    public Cancion buscarPorId(Long id) {
        TypedQuery<Cancion> query = em.createNamedQuery("Cancion.buscarPorId", Cancion.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Cancion guardar(Cancion cancion) {
        if (cancion.getId_cancion() == null) {
            //log.info("Inserting new contact");
            em.persist(cancion);
        } else {
            em.merge(cancion);
            //log.info("Updating existing contact");
        }
        //log.info("Contact saved with id: " + contact.getId());
        return cancion;
    }

    @Override
    public void eliminar(Cancion cancion) {
        Cancion mergedCancion = em.merge(cancion);
        em.remove(mergedCancion);
        //log.info("Contact with id: " + contact.getId() + " deleted successfully");
    }

    @Override
    public List<Cancion> buscarConCriteria(CancionBusquedaCriteria criteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cancion> cq = cb.createQuery(Cancion.class);
        Root<Cancion> pet = cq.from(Cancion.class);
        cq.where(cb.equal(pet.get("nombre"), criteria.getNombreCancion()));
        TypedQuery<Cancion> q = em.createQuery(cq);
        return q.getResultList();
    }
    
    
    /*
     public void displayAllContactSummary() {
     List result = em
     .createQuery("select c.firstName, c.lastName, t.telNumber "
     + "from Contact c left join c.contactTelDetails t "
     + " where t.telType='Home'").getResultList();
     int count = 0;
     for (Iterator i = result.iterator(); i.hasNext();) {
     Object[] values = (Object[]) i.next();
     System.out.println(++count + ": " + values[0] + ", "
     + values[1] + ", " + values[2]);
     }
     }*/
}
