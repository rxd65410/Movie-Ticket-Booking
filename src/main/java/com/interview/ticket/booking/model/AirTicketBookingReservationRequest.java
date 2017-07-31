package com.interview.ticket.booking.model;

public class AirTicketBookingReservationRequest extends BaseReservationRequest{

    private String flightNumber ;
    private String destination ;

    public AirTicketBookingReservationRequest(String requestId,int numberOfSeats){
        super(requestId,numberOfSeats);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
