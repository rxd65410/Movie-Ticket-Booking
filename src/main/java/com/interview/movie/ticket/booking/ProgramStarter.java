package com.interview.movie.ticket.booking;

import org.apache.commons.lang.StringUtils;

/**
 * Created by r0d00e4 on 7/27/17.
 */
public class ProgramStarter {
    public static void main(String[] args){
        String fileName = "/Users/r0d00e4/sample-input.txt";
        if(!StringUtils.isEmpty(fileName)){
            ParseInputFile parseInputFile = new ParseInputFile();
            parseInputFile.processInputFile(fileName);
        }
    }
}
