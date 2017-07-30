package com.interview.ticket.booking.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteOutputFile {
    private static final String OUTPUT_FILENAME = "output.txt";
    private static final String OUTPUT_FILE_PATH =  Paths.get("").toAbsolutePath().toString()+"/"+OUTPUT_FILENAME;

    public WriteOutputFile() throws IOException {
        if(Files.exists(Paths.get(OUTPUT_FILE_PATH))){
            Files.delete(Paths.get(OUTPUT_FILE_PATH));
        }
        Files.createFile(Paths.get(OUTPUT_FILE_PATH));
        System.out.println("Please find the booking information at " + OUTPUT_FILE_PATH);
    }

    public void writeOutput(String line){
        if(line!=null && line.length()>0){
            try {
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUTPUT_FILE_PATH), StandardOpenOption.APPEND);
                writer.append(line);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
