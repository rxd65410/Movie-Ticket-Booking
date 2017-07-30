package com.interview.ticket.booking.dao;

import com.interview.ticket.booking.exception.WriteOutputException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteOutputFile {
    private static final String OUTPUT_FILENAME = "output.txt";
    static final String OUTPUT_FILE_PATH =  Paths.get("").toAbsolutePath().toString()+"/"+OUTPUT_FILENAME;
    private static WriteOutputFile writeOutputFile;

    private WriteOutputFile() throws WriteOutputException {
        try {
            if(Files.exists(Paths.get(OUTPUT_FILE_PATH))){
                Files.delete(Paths.get(OUTPUT_FILE_PATH));
            }
            Files.createFile(Paths.get(OUTPUT_FILE_PATH));
        } catch (IOException e) {
            throw new WriteOutputException("Filed to create output file at " + OUTPUT_FILE_PATH);
        }
    }

    public static WriteOutputFile getWriteOutputFileInstance() {
        if(writeOutputFile==null){
            try {
                writeOutputFile = new WriteOutputFile();
            } catch (WriteOutputException e) {
                System.out.println("Failed creating output file "+e.getCause());
            }
        }
        return writeOutputFile;
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
