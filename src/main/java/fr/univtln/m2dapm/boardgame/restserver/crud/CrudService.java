package fr.univtln.m2dapm.boardgame.restserver.crud;

import java.util.List;
import java.util.Map;

public interface CrudService<T> {
    public T create(T t);
    public T find(Class type, Object id);
    public T update(T t);
    public void delete(Class type, Object id);
    public List findWithNamedQuery(String queryName);
    public List findWithNamedQuery(String queryName, int resultLimit);
    public List findWithNamedQuery(String namedQueryName, Map parameters);
    public List findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit);
}
