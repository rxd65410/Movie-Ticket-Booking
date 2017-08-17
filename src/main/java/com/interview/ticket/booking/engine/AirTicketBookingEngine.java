package com.interview.ticket.booking.engine;

import com.interview.ticket.booking.model.AirTicketBookingReservationRequest;

import java.util.HashMap;
import java.util.Map;

public class AirTicketBookingEngine implements BookingEngine<AirTicketBookingReservationRequest>{

    Map<Integer,Integer> seats = new HashMap<>();
    private static AirTicketBookingEngine airTicketBookingEngine;

    private AirTicketBookingEngine() {
        seats = new HashMap<>();
        for(int i=0;i<10;i++){
            seats.put(i,20);
        }
        System.out.println("Air ticket booking engine initialized successfully.");
    }

    public static AirTicketBookingEngine getInstance() {
        if(airTicketBookingEngine == null) {
            airTicketBookingEngine = new AirTicketBookingEngine();
        }
        return airTicketBookingEngine;
    }

    @Override
    public String processReservationRequest(AirTicketBookingReservationRequest reservationRequest) {
        //todo
        return null;
    }
}
