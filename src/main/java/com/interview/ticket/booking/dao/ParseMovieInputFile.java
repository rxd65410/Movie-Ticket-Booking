package com.interview.ticket.booking.dao;

import com.interview.ticket.booking.engine.BookingEngine;
import com.interview.ticket.booking.engine.MovieTicketBookingEngine;
import com.interview.ticket.booking.model.MovieReservationRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class ParseMovieInputFile extends AbstractInputFileParser {

    private static final String REQUEST_DELIMITER = " ";
    private final BookingEngine<MovieReservationRequest> bookingEngine;

    public ParseMovieInputFile() {
        this.bookingEngine = MovieTicketBookingEngine.getInstance();
    }

    public ParseMovieInputFile(BookingEngine<MovieReservationRequest> bookingEngine){
        this.bookingEngine = bookingEngine;
    }

    @Override
    public void parseReservationRequest(String request) {
        if(request!=null && request.length()>0){
            String[] tokens = request.split(REQUEST_DELIMITER);
            if(tokens.length==2 && tokens[0]!=null && tokens[1]!=null){
                MovieReservationRequest reservationRequest = new MovieReservationRequest(tokens[0],Integer.valueOf(tokens[1]));
                bookingEngine.processReservationRequest(reservationRequest);
            }
        }
    }
}
