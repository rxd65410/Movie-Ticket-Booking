package com.interview.movie.ticket.model;

import java.util.Date;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class MovieReservationRequest extends BaseReservationRequest{
    private String theaterName;
    private Date timing;

    public MovieReservationRequest(String requestId, int numberOfSeats, String theaterName, Date timing) {
        super(requestId, numberOfSeats);
        this.theaterName = theaterName;
        this.timing = timing;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public Date getTiming() {
        return timing;
    }

    public void setTiming(Date timing) {
        this.timing = timing;
    }
}
