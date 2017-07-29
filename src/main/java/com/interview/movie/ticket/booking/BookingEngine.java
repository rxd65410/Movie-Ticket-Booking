package com.interview.movie.ticket.booking;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by r0d00e4 on 7/28/17.
 */
public class BookingEngine {
    private static final int NUM_OF_ROWS = 10;
    private static final int NUM_OF_SEATS_PER_ROW = 20;
    private static final String SEATS_NOT_AVAILABLE = "No Seats Available";

    private static BookingEngine bookingEngine;
    private int totalNumOfSeatsAvailable = NUM_OF_ROWS * NUM_OF_SEATS_PER_ROW;
    private Map<Integer,Integer> seatsAvailable;


    private BookingEngine() {
        seatsAvailable = new HashMap<>();
        for(int i=0;i<NUM_OF_ROWS;i++){
            seatsAvailable.put(i,NUM_OF_SEATS_PER_ROW);
        }
    }

    public static BookingEngine getInstance() {
        if(bookingEngine == null) {
            bookingEngine = new BookingEngine();
        }
        return bookingEngine;
    }

    protected String processReservationRequest(ReservationRequest reservationRequest){

        String seatNumbers = SEATS_NOT_AVAILABLE;

        //Check if we have enough seats before processing request.
        if(totalNumOfSeatsAvailable>=reservationRequest.getNumberOfSeats()) {

            //Book from Top.
            for (Map.Entry<Integer, Integer> entry : seatsAvailable.entrySet()) {
                if (entry.getValue() >= reservationRequest.getNumberOfSeats()) {
                    seatNumbers = bookSeats(entry.getKey(), entry.getValue(), reservationRequest.getNumberOfSeats());
                    seatsAvailable.put(entry.getKey(), entry.getValue() - reservationRequest.getNumberOfSeats());
                    totalNumOfSeatsAvailable -= reservationRequest.getNumberOfSeats();
                    return seatNumbers;
                }
            }

            //If we are here... then we have seats but not in single row. Book tickets in multiple rows.
            return bookAcrossRows(reservationRequest);
        }
        return seatNumbers;
    }

    private String bookAcrossRows(ReservationRequest reservationRequest) {

        StringBuilder seatNumbers = new StringBuilder();

        int seatsNeed = reservationRequest.getNumberOfSeats();
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
            if(seatsNeed==0) break;
        }
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

    public int getTotalNumOfSeatsAvailable() {
        return totalNumOfSeatsAvailable;
    }
}
