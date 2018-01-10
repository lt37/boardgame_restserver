package fr.univtln.m2dapm.boardgame.restserver.crud;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CrudServiceBean<T> implements CrudService<T> {

    private final String PERSISTENCE_UNIT = "persistenceVV";

    private static CrudServiceBean instance = null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public static CrudServiceBean getInstance() {
        if (instance == null)
            instance = new CrudServiceBean();
        return instance;
    }

    private CrudServiceBean() {
    }


    public void beginTransaction() {
        if (!transaction.isActive())
            transaction.begin();
    }


    public void commitTransaction() {
        transaction.commit();
    }


    public void closeEntityManager() {
        if(em.isOpen())
            em.close();
    }


    /**
     * Inserts a new entity into the database.
     * If the entity already exists, use the update method instead.
     * @param t: entity to insert.
     * @return T: the entity with its new id.
     */
    public T create(T t) {
        em.persist(t);
        em.flush();
        return t;
    }

    /**
     * Extracts an entity from the database.
     *
     * @param type: the type of entity to insert.
     * @param id: the entity's id.
     * @return T: the entity itself.
     */
    public T find(Class<T> type, Object id) {
        return em.find(type, id);
    }


    /**
     * Updates an entity in the database.
     *
     * @param t: the updated entity.
     * @return T: the updated entity.
     */
    public T update(T t) {
        return em.merge(t);
    }


    /**
     * Deletes an entity from the database.
     *
     * @param type: the entity's type.
     * @param id: the entity's id.
     * @return T: the deleted entity.
     */
    public T delete(Class type, Object id) {
        T t = (T)em.getReference(type, id);
        em.remove(t);
        em.flush();
        return t;
    }


    /**
     * Returns a list of entities using a named query.
     *
     * @param type: the type of entities to return.
     * @param queryName: the SQL query.
     * @return List: the list of entities.
     */
    public List findWithNamedQuery(Class<T> type, String queryName) {
        return em.createNamedQuery(queryName, type).getResultList();
    }


    /**
     * Returns a list of entities.
     *
     * @param type: the type of entities to return.
     * @param queryName: the SQL query.
     * @param resultLimit: max amount of entities to return.
     * @return List: the list of entities.
     */
    public List findWithNamedQuery(Class<T> type, String queryName, int resultLimit) {
        return em.createNamedQuery(queryName, type).setMaxResults(resultLimit).getResultList();
    }


    /**
     * Returns a list of entities using a named query with parameters.
     *
     * @param type: the type of entities to return.
     * @param namedQueryName: the SQL query.
     * @param parameters: the query parameters.
     * @return List: the list of entities.
     */
    public List findWithNamedQuery(Class<T> type, String namedQueryName, Map parameters) {
        return findWithNamedQuery(type, namedQueryName, parameters, 0);
    }


    public List findWithNamedQuery(Class<T> type, String namedQueryName, Map parameters, int resultLimit) {
        Set rawParameters = parameters.keySet();
        TypedQuery<T> query = em.createNamedQuery(namedQueryName, type);
        if (resultLimit > 0)
            query.setMaxResults(resultLimit);
        for (Object entry : rawParameters)
            query.setParameter(entry.toString(), parameters.get(entry.toString()));
        return query.getResultList();
    }

}
