package com.interview.movie.ticket;

import com.interview.movie.ticket.booking.ParseInputFile;
import com.interview.movie.ticket.exception.ArgumentsMissingException;

import java.io.IOException;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class ProgramStarter {
    public static void main(String[] args) throws IOException, ArgumentsMissingException {
        String fileName = "/Users/r0d00e4/sample-input.txt";

       /* if(args.length==1){
            fileName = args[0];
        }else{
            System.out.println("Usage : java -jar <.jar file> <Reservation requests input file path.>");
            throw new ArgumentsMissingException("Input file missing");
        }*/


        if(fileName!=null && fileName.length()>0){
            ParseInputFile parseInputFile = new ParseInputFile();
            parseInputFile.processInputFile(fileName);
        }
    }
}
