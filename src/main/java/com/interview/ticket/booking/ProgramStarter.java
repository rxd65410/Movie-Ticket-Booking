package com.interview.ticket.booking;

import com.interview.ticket.booking.dao.WriteOutputFile;
import com.interview.ticket.booking.exception.ArgumentsMissingException;
import com.interview.ticket.booking.dao.ParseInputFile;

import java.io.IOException;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class ProgramStarter {
    public static void main(String[] args) throws IOException, ArgumentsMissingException {
        // "/Users/r0d00e4/sample-input.txt";
        String fileName ;

       if(args.length==1){
            fileName = args[0];
        }else{
            System.out.println("Usage : java -jar <.jar file> <Reservation requests input file path.>");
            throw new ArgumentsMissingException("Input file missing");
        }


        if(fileName!=null && fileName.length()>0){
           System.out.println("Start processing the reservation request file.");
            ParseInputFile parseInputFile = new ParseInputFile();
            parseInputFile.processInputFile(fileName);
            System.out.println("Please find the booking information at "+ WriteOutputFile.OUTPUT_FILE_PATH);
        }
    }
}
