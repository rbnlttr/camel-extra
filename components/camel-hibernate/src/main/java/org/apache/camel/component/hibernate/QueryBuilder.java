/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


/**
 * A builder of query expressions
 * 
 * @version $Revision: 630591 $
 */
public abstract class QueryBuilder implements QueryFactory {
    ParameterBuilder parameterBuilder;

    /**
     * Creates a query builder using the JPA query syntax
     * 
     * @param query JPA query language to create
     * @return a query builder
     */
    public static QueryBuilder query(final String query) {
        return new QueryBuilder() {
            protected Query makeQueryObject(Session entityManager) {
                return entityManager.createQuery(query);
            }

            @Override
            public String toString() {
                return "Query: " + query + " params: " + getParameterDescription();
            }
        };
    }


    /**
     * Creates a native SQL query
     */
    public static QueryBuilder nativeQuery(final String nativeQuery) {
        return new QueryBuilder() {
            protected Query makeQueryObject(Session entityManager) {
                return entityManager.createSQLQuery(nativeQuery);
            }

            @Override
            public String toString() {
                return "SQL: " + nativeQuery + getParameterDescription();
            }
        };
    }

    /**
     * Specifies the parameters to the query
     * 
     * @param parameters the parameters to be configured on the query
     * @return this query builder
     */
    public QueryBuilder parameters(Object... parameters) {
        return parameters(Arrays.asList(parameters));
    }

    /**
     * Specifies the parameters to the query as an ordered collection of
     * parameters
     * 
     * @param parameters the parameters to be configured on the query
     * @return this query builder
     */
    public QueryBuilder parameters(final Collection parameters) {
        checkNoParametersConfigured();
        parameterBuilder = new ParameterBuilder() {
            public void populateQuery(Session entityManager, Query query) {
                int counter = 0;
                for (Object parameter : parameters) {
                    query.setParameter(counter++, parameter);
                }
            }

            @Override
            public String toString() {
                return "Parameters: " + parameters;
            }
        };
        return this;
    }

    /**
     * Specifies the parameters to the query as a Map of key/value pairs
     * 
     * @param parameterMap the parameters to be configured on the query
     * @return this query builder
     */
    public QueryBuilder parameters(final Map<String, Object> parameterMap) {
        checkNoParametersConfigured();
        parameterBuilder = new ParameterBuilder() {
            public void populateQuery(Session entityManager, Query query) {
                Set<Map.Entry<String, Object>> entries = parameterMap.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }

            @Override
            public String toString() {
                return "Parameters: " + parameterMap;
            }
        };
        return this;
    }

    protected void checkNoParametersConfigured() {
        if (parameterBuilder != null) {
            throw new IllegalArgumentException("Cannot add parameters to a QueryBuilder which already has parameters configured");
        }
    }

    public Query createQuery(Session entityManager) {
        Query query = makeQueryObject(entityManager);
        populateQuery(entityManager, query);
        return query;
    }

    protected String getParameterDescription() {
        if (parameterBuilder == null) {
            return "";
        } else {
            return " " + parameterBuilder.toString();
        }
    }

    protected void populateQuery(Session entityManager, Query query) {
        if (parameterBuilder != null) {
            parameterBuilder.populateQuery(entityManager, query);
        }
    }

    protected abstract Query makeQueryObject(Session entityManager);

    /**
     * A plugin strategy to populate the query with parameters
     */
    protected abstract static class ParameterBuilder {
        public abstract void populateQuery(Session entityManager, Query query);
    }
}
