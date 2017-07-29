package com.interview.movie.ticket.booking;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class ReservationRequest {
    private String requestId;
    private int numberOfSeats;

    public ReservationRequest(String requestId, int numberOfSeats) {
        this.requestId = requestId;
        this.numberOfSeats = numberOfSeats;
        //System.out.println(++a + " req created "+ requestId + " seats " + numberOfSeats);
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
