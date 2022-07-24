package com.alten.hotel.modules.guest.service;

import com.alten.hotel.commons.exception.RepositoryException;
import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.guest.exception.*;
import com.alten.hotel.modules.guest.exception.errors.GuestError;
import com.alten.hotel.modules.guest.exception.errors.GuestErrorMessage;
import com.alten.hotel.modules.guest.exception.errors.GuestErrorResponse;
import com.alten.hotel.modules.guest.model.Guest;
import com.alten.hotel.modules.guest.repository.GuestRepository;
import com.alten.hotel.modules.guest.resource.GuestParameterRequest;

public interface GuestService extends BaseService<Guest>
{
    default void throwGuestException(GuestError error)
    {
        switch (error) {
            case GST0001 -> throw new GuestCreateUpdateException(GuestErrorMessage.GSTMSG0001);
            case GST0002 -> throw new GuestOperationNotAllowedException(GuestErrorMessage.GSTMSG0002);
            case GST0003 -> throw new GuestFullNameNotFoundException(GuestErrorMessage.GSTMSG0003);
            case GST0004 -> throw new GuestEmailNotFoundException(GuestErrorMessage.GSTMSG0004);
            case GST0005 -> throw new GuestPhoneNumberNotFoundException(GuestErrorMessage.GSTMSG0005);
        }
    }

    private GuestErrorResponse getErrorResponse(GuestError error)
    {
        return new GuestErrorResponse(error, error.getDescription());
    }

    default Guest execute(GuestRepository repo, GuestParameterRequest request)
    {
        try
        {
            return switch (request.operation()) {
                case CREATE_UPDATE_GUEST -> this.insertUpdate(request.guest());
                case FIND_GUEST_BY_EMAIL -> repo.findByEmail(request.parameter().email().orElse("email"));
                case FIND_GUEST_BY_FULL_NAME -> repo.findByFullName(
                        request.parameter().firstname().orElse("firstname"),
                        request.parameter().lastname().orElse("lastname")
                );
                case FIND_GUEST_BY_PHONE_NUMBER -> repo.findByPhoneNumber(request.parameter().phoneNumber().orElse("phone"));
            };
        }
        catch (RepositoryException ex)
        {
            var errorResponse = switch (request.operation()) {
                case CREATE_UPDATE_GUEST -> this.getErrorResponse(GuestError.GST0001);
                case FIND_GUEST_BY_EMAIL -> this.getErrorResponse(GuestError.GST0003);
                case FIND_GUEST_BY_FULL_NAME -> this.getErrorResponse(GuestError.GST0004);
                case FIND_GUEST_BY_PHONE_NUMBER -> this.getErrorResponse(GuestError.GST0005);
            };
            this.getLogger().error(errorResponse.description(), ex);
            this.throwGuestException(errorResponse.error());
            return null;
        }
    }
}
