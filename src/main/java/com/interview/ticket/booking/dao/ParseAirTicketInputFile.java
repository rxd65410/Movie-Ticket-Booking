package com.interview.ticket.booking.dao;

import com.interview.ticket.booking.engine.AirTicketBookingEngine;
import com.interview.ticket.booking.engine.BookingEngine;
import com.interview.ticket.booking.model.AirTicketBookingReservationRequest;

public class ParseAirTicketInputFile extends AbstractInputFileParser{

    private static final String REQUEST_DELIMITER = " ";
    private final BookingEngine<AirTicketBookingReservationRequest> bookingEngine;

    public ParseAirTicketInputFile() {
        this.bookingEngine = AirTicketBookingEngine.getInstance();
    }

    public ParseAirTicketInputFile(BookingEngine<AirTicketBookingReservationRequest> bookingEngine){
        this.bookingEngine = bookingEngine;
    }

    @Override
    public void parseReservationRequest(String request) {
        if(request!=null && request.length()>0){
            String[] tokens = request.split(REQUEST_DELIMITER);
            if(tokens.length==2 && tokens[0]!=null && tokens[1]!=null){
                AirTicketBookingReservationRequest reservationRequest = new AirTicketBookingReservationRequest(tokens[0],Integer.valueOf(tokens[1]));
                reservationRequest.setFlightNumber("flightnumber");
                reservationRequest.setDestination("destination");
                bookingEngine.processReservationRequest(reservationRequest);
            }
        }
    }
}
