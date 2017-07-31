# Movie-Ticket-Booking

Instructions on how to compile/run this program using terminal.
   * step 1: cd to Movie-Ticket-Booking/
   * step 2: mvn clean install
   * step 3: java -jar target/MovieTicketBooking-1.0-SNAPSHOT.jar [Reservation Requests File]

Implementation Details :
Design should be in such a way that it will be easy to extend this module to support Air Ticket booking, Bus Ticketing booking or any other ticket booking project in future.
1) ProgramStarter.java - Execution starts here. Class with Main function and validates the input arguments.
2) com.interview.ticket.booking.model
    * BaseReservationRequest.java - Base model class for all reservation request. This model class contains RequestId, NumberOfSeats. In future, if you want to extend this project for Air ticket booking, we need to extend this base class and add few extra fields in child model class.
    * MovieReservationRequest.java - This needs to extend BaseReservationRequest model class. As of now this is be same as Base class. We can add few details like TheaterName, Movietiming....
3) com.interview.ticket.booking.engine
    * BookingEngine.java - This is a Interface which can process any kind of ReservationRequest like MovieReservationRequest or AirTicketReservtionRequest.
    * MovieTicketBookingEngine.java (Singleton)- Implementation of BookingEngine. This is used to process MovieReservationRequest which comes from Inputfile.
    * HashMap<Integer, Integer> tracks all available seats per row.
4) com.interview.ticket.booking.dao
    * ParseInputFile.java - Parses the input file which contains ReservationRequests and send these requests to booking engine.
    * WriteOutputFile.java - Once BookingEngine confirms the seats, it will send the booking confirmation to this doa.
    * WriteOutput/ParseInput logic should be separated from Booking engine code. This will make life easy in future, if you want to use database instead of file.




Assumptions :
1) Valid reservation requestId should start with "R". RequestId and number of seats should be delimited with space.
2) Booking happens in first come first serve basis.
3) Booking starts from first row [away from screen].
4) Each request will be assigned consecutive seats in single row.
5) If seats are not available in one single row then seats accross multiple rows will be booked.
  
