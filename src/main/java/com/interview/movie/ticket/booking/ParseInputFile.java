package com.interview.movie.ticket.booking;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class ParseInputFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParseInputFile.class);
    private static final String VALID_REQUEST = "R";
    private static final String REQUEST_DELIMITER = " ";
    private final BookingEngine bookingEngine;

    public ParseInputFile() {
        this.bookingEngine = BookingEngine.getInstance();;
    }

    /*Process the input file for Reservation Requests.*/
    public void processInputFile(String fileName){
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            //filter only valid reservation requests which starts with R###.
            stream.filter(request -> request.startsWith(VALID_REQUEST)).forEach(request -> parseReservationRequest(request));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseReservationRequest(String request) {
        if(!StringUtils.isEmpty(request)){
            String[] tokens = request.split(REQUEST_DELIMITER);
            if(tokens.length==2 && !StringUtils.isEmpty(tokens[0]) && !StringUtils.isEmpty(tokens[1])){
                ReservationRequest reservationRequest = new ReservationRequest(tokens[0],Integer.valueOf(tokens[1]));
                String bookingResponse = bookingEngine.processReservationRequest(reservationRequest);
                System.out.println(reservationRequest.getRequestId()+" "+bookingResponse);
            }
        }
    }
}
