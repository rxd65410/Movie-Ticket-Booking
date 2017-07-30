package com.interview.ticket.booking.engine;

import com.interview.ticket.booking.dao.WriteOutputFile;
import com.interview.ticket.booking.model.MovieReservationRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingEngineTest {
    @Mock public WriteOutputFile writeOutputFile;
    @InjectMocks private MovieTicketBookingEngine movieTicketBookingEngine;

    @Test
    public void processReservationRequestTest() throws IOException {
        MovieReservationRequest reservationRequest = new MovieReservationRequest("R00TEST1",3);
        String seatNumbers = movieTicketBookingEngine.processReservationRequest(reservationRequest);
        assertEquals("J1,J2,J3",seatNumbers);
    }

    @Test
    public void testBookAcrossRows() throws IOException {
        Map<Integer,Integer> seatsAvailable = new HashMap<>();
        seatsAvailable.put(1,2);
        seatsAvailable.put(2,3);
        movieTicketBookingEngine.setSeatsAvailable(seatsAvailable);
        MovieReservationRequest reservationRequest = new MovieReservationRequest("R00TEST2",4);
        String seats = movieTicketBookingEngine.processReservationRequest(reservationRequest);
        assertEquals("I19,I20,H18,H19",seats);
    }
}
