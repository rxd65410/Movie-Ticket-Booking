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
public class ParseInputFile {

    private static final String VALID_REQUEST = "R";
    private static final String REQUEST_DELIMITER = " ";
    private final BookingEngine<MovieReservationRequest> bookingEngine;

    public ParseInputFile() throws IOException {
        this.bookingEngine = MovieTicketBookingEngine.getInstance();
    }

    /*Process the input file for Reservation Requests.*/
    public void processInputFile(String fileName){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            //filter only valid reservation requests which starts with R###.
            stream.filter(request -> request.startsWith(VALID_REQUEST)).forEach(this::parseReservationRequest);
            System.out.println("Please find the booking information at "+ WriteOutputFile.OUTPUT_FILE_PATH);
        } catch (IOException e) {
            System.out.println("Failed to process input file : " + fileName + "\n"+ e);
        }
    }

    private void parseReservationRequest(String request) {
        if(request!=null && request.length()>0){
            String[] tokens = request.split(REQUEST_DELIMITER);
            if(tokens.length==2 && tokens[0]!=null && tokens[1]!=null){
                MovieReservationRequest reservationRequest = new MovieReservationRequest(tokens[0],Integer.valueOf(tokens[1]));
                bookingEngine.processReservationRequest(reservationRequest);
            }
        }
    }
}
