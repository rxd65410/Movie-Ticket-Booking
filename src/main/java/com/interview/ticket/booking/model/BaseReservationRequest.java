package com.interview.ticket.booking.model;

public class BaseReservationRequest {
    private String requestId;
    private int numberOfSeats;

    public BaseReservationRequest(String requestId, int numberOfSeats) {
        this.requestId = requestId;
        this.numberOfSeats = numberOfSeats;
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
