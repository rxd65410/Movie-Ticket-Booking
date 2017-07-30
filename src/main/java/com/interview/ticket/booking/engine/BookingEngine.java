package com.interview.ticket.booking.engine;

import com.interview.ticket.booking.model.BaseReservationRequest;

public interface BookingEngine<T extends BaseReservationRequest> {
    /* Process the incoming reservation request */
    String processReservationRequest(T reservationRequest);
}
