package com.alten.hotel.commons.resource;

import com.alten.hotel.commons.types.RepositoryOperationType;

public record RepositoryParameter<T>(RepositoryOperationType operation, T entity) { }