package com.alten.hotel.commons.service;

import com.alten.hotel.commons.exception.RepositoryError;
import com.alten.hotel.commons.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public interface BaseService<T> extends BaseRepository<T>
{
    default Logger getLogger() { return LoggerFactory.getLogger(BaseService.class); }

    default LocalDateTime toLocalDateTime(String dateTime)
    {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }

    default LocalDateTime getFormattedDate()
    {
        return LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }

    default UUID toUUID(String uuid)
    {
        try
        {
            return Objects.isNull(uuid) ? null : UUID.fromString(uuid);
        }
        catch (IllegalArgumentException ex)
        {
            this.throwRepositoryException(RepositoryError.RPT0007);
            return null;
        }
    }
}
