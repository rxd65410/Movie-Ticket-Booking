# Movie-Ticket-Booking

Instructions on how to compile/run this program.
Use terminal 
   * step 1: cd to Movie-Ticket-Booking/
   * step 2: mvn clean install
   * step 3: java -jar target/MovieTicketBooking-1.0-SNAPSHOT.jar <input file path>.

Implementation Details :
1) Progra

Assumptions :
1) Valid reservation requestId should start with "R". RequestId and number of seats should be delimited with space.
2) Booking happens in first come first serve basis.
3) Booking starts from first row [away from screen].
4) Each request will be assigned consecutive seats in single row.
5) If seats are not available in one single row then seats accross multiple rows will be booked.
  
