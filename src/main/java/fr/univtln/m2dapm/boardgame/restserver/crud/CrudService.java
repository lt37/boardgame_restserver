package fr.univtln.m2dapm.boardgame.restserver.crud;

import java.util.List;
import java.util.Map;

public interface CrudService<T> {
    T create(T t);
    T find(Class<T> type, Object id);
    T update(T t);
    T delete(Class type, Object id);
    List findWithNamedQuery(Class<T> type, String queryName);
    List findWithNamedQuery(Class<T> type, String queryName, int resultLimit);
    List findWithNamedQuery(Class<T> type, String namedQueryName, Map parameters);
    List findWithNamedQuery(Class<T> type, String namedQueryName, Map parameters, int resultLimit);
}
