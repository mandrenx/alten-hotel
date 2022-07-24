package com.alten.hotel.commons.repository;

import com.alten.hotel.commons.exception.RepositoryError;
import com.alten.hotel.commons.exception.RepositoryErrorMessage;
import com.alten.hotel.commons.exception.RepositoryException;
import com.alten.hotel.commons.resource.RepositoryParameter;
import com.alten.hotel.commons.types.RepositoryOperationType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import java.util.List;
import java.util.UUID;

public interface BaseRepository<T> extends PanacheRepository<T>
{
    default void throwRepositoryException(RepositoryError error)
    {
        switch (error) {
            case RPT0001 -> throw new RepositoryException(RepositoryErrorMessage.MSG0001);
            case RPT0002 -> throw new RepositoryException(RepositoryErrorMessage.MSG0002);
            case RPT0003 -> throw new RepositoryException(RepositoryErrorMessage.MSG0003);
            case RPT0004 -> throw new RepositoryException(RepositoryErrorMessage.MSG0004);
            case RPT0005 -> throw new RepositoryException(RepositoryErrorMessage.MSG0005);
            case RPT0006 -> throw new RepositoryException(RepositoryErrorMessage.MSG0006);
            case RPT0007 -> throw new RepositoryException(RepositoryErrorMessage.MSG0007);
        }
    }

    default T search(String query, Object object)
    {
        var entity = this.find(query, object).firstResult();
        if (entity == null) this.throwRepositoryException(RepositoryError.RPT0001);
        return entity;
    }

    default T search(String query, Parameters params)
    {
        var entity = this.find(query, params).firstResult();
        if (entity == null) this.throwRepositoryException(RepositoryError.RPT0002);
        return entity;
    }

    default T searchByID(String id, UUID uuid)
    {
        var entity = this.find(id, uuid).firstResult();
        if (entity == null) { this.throwRepositoryException(RepositoryError.RPT0003); }
        return entity;
    }

    default List<T> searchList(String query, Object object)
    {
        var list = this.find(query, object).list();
        if (list.isEmpty()) this.throwRepositoryException(RepositoryError.RPT0004);
        return list;
    }

    default List<T> searchList(String query, Parameters params)
    {
        var list = this.find(query, params).list();
        if (list.isEmpty()) this.throwRepositoryException(RepositoryError.RPT0005);
        return list;
    }

    private T execute(RepositoryParameter<T> parameter)
    {
        try
        {
            switch (parameter.operation()) {
                case DELETE -> this.delete(parameter.entity());
                case INSERT_UPDATE -> this.persist(parameter.entity());
            }
            return parameter.entity();
        }
        catch (IllegalArgumentException | IllegalStateException ex)
        {
            this.throwRepositoryException(
                    parameter.operation() == RepositoryOperationType.DELETE ? RepositoryError.RPT0006 : RepositoryError.RPT0007
            );
            return null;
        }
    }

    default T remove(String id, UUID uuid)
    {
        return this.execute(new RepositoryParameter<>(RepositoryOperationType.DELETE, this.searchByID(id, uuid)));
    }

    default T insertUpdate(T entity)
    {
        return this.execute(new RepositoryParameter<>(RepositoryOperationType.INSERT_UPDATE, entity));
    }
}
