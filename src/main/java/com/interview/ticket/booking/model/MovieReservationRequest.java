package com.interview.ticket.booking.model;

import java.util.Date;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class MovieReservationRequest extends BaseReservationRequest{

    public MovieReservationRequest(String requestId, int numberOfSeats) {
        super(requestId, numberOfSeats);
    }
}
