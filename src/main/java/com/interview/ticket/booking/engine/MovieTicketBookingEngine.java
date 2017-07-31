package com.interview.ticket.booking.engine;


import com.interview.ticket.booking.dao.WriteOutputFile;
import com.interview.ticket.booking.model.BaseReservationRequest;
import com.interview.ticket.booking.model.MovieReservationRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by r0d00e4 on 7/28/17.
 */
public class MovieTicketBookingEngine implements BookingEngine<MovieReservationRequest>{
    private static final int NUM_OF_ROWS = 10;
    private static final int NUM_OF_SEATS_PER_ROW = 20;
    private static final String SEATS_NOT_AVAILABLE = "No Seats Available";

    private int totalNumOfSeatsAvailable = NUM_OF_ROWS * NUM_OF_SEATS_PER_ROW;
    private Map<Integer,Integer> seatsAvailable;

    private static MovieTicketBookingEngine movieTicketBookingEngine;
    private WriteOutputFile writeOutputFile;

    private MovieTicketBookingEngine() {
        writeOutputFile = WriteOutputFile.getWriteOutputFileInstance();
        seatsAvailable = new HashMap<>();
        for(int i=0;i<NUM_OF_ROWS;i++){
            seatsAvailable.put(i,NUM_OF_SEATS_PER_ROW);
        }
        System.out.println("Movie ticket booking engine initialized successfully.");
    }

    public static MovieTicketBookingEngine getInstance() {
        if(movieTicketBookingEngine == null) {
            movieTicketBookingEngine = new MovieTicketBookingEngine();
        }
        return movieTicketBookingEngine;
    }

    @Override
    public String processReservationRequest(MovieReservationRequest movieReservationRequest) {

        String seatNumbers = SEATS_NOT_AVAILABLE;

        //Check if we have enough seats before processing request.
        if(totalNumOfSeatsAvailable>= movieReservationRequest.getNumberOfSeats()) {

            //Book from Top.
            for (Map.Entry<Integer, Integer> entry : seatsAvailable.entrySet()) {
                if (entry.getValue() >= movieReservationRequest.getNumberOfSeats()) {
                    seatNumbers = bookSeats(entry.getKey(), entry.getValue(), movieReservationRequest.getNumberOfSeats());
                    seatsAvailable.put(entry.getKey(), entry.getValue() - movieReservationRequest.getNumberOfSeats());
                    totalNumOfSeatsAvailable -= movieReservationRequest.getNumberOfSeats();
                    writeOutputFile.writeOutput(movieReservationRequest.getRequestId()+" "+seatNumbers);
                    return seatNumbers;
                }
            }

            //If we are here... it means we have seats but not in single row. Book tickets in multiple rows.
            return bookAcrossRows(movieReservationRequest);
        }
        return seatNumbers;
    }

    private String bookAcrossRows(BaseReservationRequest movieReservationRequest) {

        StringBuilder seatNumbers = new StringBuilder();

        int seatsNeed = movieReservationRequest.getNumberOfSeats();
        for(Map.Entry<Integer,Integer> entry : seatsAvailable.entrySet()){
            int available = entry.getValue();
            int book = 0;
            if(seatsNeed>available){
                book = available;
            }else{
                book = seatsNeed;
            }
            seatNumbers.append(bookSeats(entry.getKey(),available,book));
            seatsNeed -= book;
            totalNumOfSeatsAvailable -= book;
            seatsAvailable.put(entry.getKey(), entry.getValue() - book);
            if(seatsNeed==0){
                break;
            }else{
                seatNumbers.append(",");
            }
        }
        writeOutputFile.writeOutput(movieReservationRequest.getRequestId()+" "+seatNumbers);
        return seatNumbers.toString();
    }

    private String bookSeats(Integer bookInRow, Integer seatsAvailable, int numberOfSeatsRequested) {


        int startIndex = NUM_OF_SEATS_PER_ROW-seatsAvailable+1;
        int endIndex = startIndex+numberOfSeatsRequested;
        char row = (char) ('A' + NUM_OF_ROWS - bookInRow - 1);

        StringBuilder output = new StringBuilder();
        for(int i = startIndex; i<endIndex; i++){
            output.append(row+""+i);
            if(i<endIndex-1) output.append(",");
        }
        return output.toString();
    }

    public Map<Integer, Integer> getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Map<Integer, Integer> seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public WriteOutputFile getWriteOutputFile() {
        return writeOutputFile;
    }

    public void setWriteOutputFile(WriteOutputFile writeOutputFile) {
        this.writeOutputFile = writeOutputFile;
    }
}
