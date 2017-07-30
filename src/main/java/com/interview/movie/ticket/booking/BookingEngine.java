package com.interview.movie.ticket.booking;

import com.interview.movie.ticket.model.BaseReservationRequest;

public interface BookingEngine {
    /* Process the incoming reservation request */
    String processReservationRequest(BaseReservationRequest reservationRequest);
}
