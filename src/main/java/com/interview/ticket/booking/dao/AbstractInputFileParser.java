package com.interview.ticket.booking.dao;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class AbstractInputFileParser {

    private static final String VALID_REQUEST = "R";

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

    public abstract void parseReservationRequest(String request);
}
