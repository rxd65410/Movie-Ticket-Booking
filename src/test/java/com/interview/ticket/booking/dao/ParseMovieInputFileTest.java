package com.interview.ticket.booking.dao;

import com.interview.ticket.booking.engine.BookingEngine;
import com.interview.ticket.booking.model.MovieReservationRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.google.common.io.Resources;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParseMovieInputFileTest {
    @Mock private BookingEngine<MovieReservationRequest> bookingEngine ;
    @InjectMocks private ParseMovieInputFile parseMovieInputFile;

    @Before
    public void init() {
        parseMovieInputFile = new ParseMovieInputFile(bookingEngine);
    }

    @Test
    public void testProcessInputFile(){
        String intputFile = Resources.getResource("movie-reservation-requests").getFile();
        parseMovieInputFile.processInputFile(intputFile);
        verify(bookingEngine,times(4)).processReservationRequest(any());
    }
}
