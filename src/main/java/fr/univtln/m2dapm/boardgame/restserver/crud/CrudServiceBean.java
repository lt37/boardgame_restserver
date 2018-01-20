package fr.univtln.m2dapm.boardgame.restserver.crud;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Stateless
@Local(CrudService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CrudServiceBean<T> implements CrudService<T> {

    @PersistenceContext(unitName = "persistence")
    EntityManager em;


    public T create(T t) {
        em.persist(t);
        em.flush();
        em.refresh(t);
        return t;
    }


    public T find(Class type, Object id) {
        return (T)em.find(type, id);
    }


    public void delete(Class type, Object id) {
        Object ref = em.getReference(type, id);
        em.remove(ref);
    }


    public T update(T t) {
        return (T)em.merge(t);
    }


    public List findWithNamedQuery(String namedQueryName) {
        return em.createNamedQuery(namedQueryName).getResultList();
    }


    public List findWithNamedQuery(String namedQueryName, Map parameters) {
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }


    public List findWithNamedQuery(String queryName, int resultLimit) {
        return em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
    }


    public List findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit) {
        Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = this.em.createNamedQuery(namedQueryName);
        if (resultLimit > 0)
            query.setMaxResults(resultLimit);
        for (Map.Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }
}