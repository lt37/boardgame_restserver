package fr.univtln.m2dapm.boardgame.restserver.crud;

import java.util.HashMap;
import java.util.Map;

public class QueryParameter {

    /**
     * The Map contains the actual parameters.
     */
    private Map parameters = new HashMap();

    private QueryParameter(String name, Object value) {
        this.parameters.put(name, value);
    }

    /**
     * Creates a new QueryParameter, with 1 parameter.
     * @param name: name of the parameter (must be the same as the name in the Named Query)
     * @param value: parameter value
     * @return QueryParameter
     */
    public static QueryParameter with(String name, Object value) {
        return new QueryParameter(name, value);
    }


    /**
     * Adds a new parameter.
     * @param name: name of the parameter (must fit the name in the Named Query)
     * @param value: parameter value
     * @return QueryParameter
     */
    public QueryParameter and(String name, Object value) {
        this.parameters.put(name, value);
        return this;
    }

    public Map parameters() {
        return this.parameters;
    }
}
