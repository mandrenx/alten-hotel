package com.alten.hotel.modules.booking.service;

import com.alten.hotel.commons.exception.RepositoryException;
import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.booking.exception.*;
import com.alten.hotel.modules.booking.exception.errors.BookingErrorMessage;
import com.alten.hotel.modules.booking.exception.errors.BookingErrorResponse;
import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.repository.BookingRepository;
import com.alten.hotel.modules.booking.resource.BookingParameterRequest;
import com.alten.hotel.modules.booking.resource.BookingResult;
import com.alten.hotel.modules.guest.exception.errors.BookingError;

public interface BookingService extends BaseService<Booking>
{
    default void throwBookingException(BookingError error)
    {
        switch (error) {
            case BKG0001 -> throw new BookingCreateUpdateException(BookingErrorMessage.BKGMSG0001);
            case BKG0002 -> throw new BookingOperationNotAllowedException(BookingErrorMessage.BKGMSG0002);
            case BKG0003 -> throw new BookingAccommodationNotFoundException(BookingErrorMessage.BKGMSG0003);
            case BKG0004 -> throw new BookingPeriodNotFoundException(BookingErrorMessage.BKGMSG0004);
            case BKG0005 -> throw new BookingStatusNotFoundException(BookingErrorMessage.BKGMSG0005);
        }
    }

    private BookingErrorResponse getErrorData(BookingError error)
    {
        return new BookingErrorResponse(error, error.getDescription());
    }

    default BookingResult execute(BookingRepository repo, BookingParameterRequest request)
    {
        try
        {
            return switch (request.operation()) {
                case CREATE_UPDATE_BOOKING -> new BookingResult(this.insertUpdate(request.guest()), null);
                case FIND_BOOKING_BY_ACCOMMODATION -> new BookingResult(
                        null,
                        repo.findByAccommodation(request.parameter().accommodation())
                );
                case FIND_BOOKING_BY_AVAILABLE -> new BookingResult(
                        null,
                        repo.findByPeriod(request.parameter().entryAT(), request.parameter().exitAT())
                );
                case FIND_BOOKING_BY_STATUS -> new BookingResult(
                        null,
                        repo.findByStatus(request.parameter().status())
                );
            };
        }
        catch (RepositoryException ex)
        {
            var errorResponse = switch (request.operation()) {
                case CREATE_UPDATE_BOOKING -> this.getErrorData(BookingError.BKG0001);
                case FIND_BOOKING_BY_ACCOMMODATION -> this.getErrorData(BookingError.BKG0003);
                case FIND_BOOKING_BY_AVAILABLE -> this.getErrorData(BookingError.BKG0004);
                case FIND_BOOKING_BY_STATUS -> this.getErrorData(BookingError.BKG0005);
            };
            this.getLogger().error(errorResponse.description(), ex);
            this.throwBookingException(errorResponse.error());
            return null;
        }
    }
}
