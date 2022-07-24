package com.alten.hotel.commons.serializer;

import java.util.List;

public interface BaseSerializer<T, R, S>
{
    T toEntity(R request);

    List<T> toEntity(List<R> requests);

    S toResponse(T entity);

    List<S> toResponse(List<T> entities);
}
