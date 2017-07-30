package com.interview.ticket.booking.engine;

import com.interview.ticket.booking.model.BaseReservationRequest;

public interface BookingEngine {
    /* Process the incoming reservation request */
    String processReservationRequest(BaseReservationRequest reservationRequest);
}
