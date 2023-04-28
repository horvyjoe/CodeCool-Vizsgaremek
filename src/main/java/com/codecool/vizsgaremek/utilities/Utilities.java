package com.codecool.vizsgaremek.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utilities {

    private String fileName;
    public String getFileName() {
        return fileName;
    }

    public String textReader() {
        StringBuilder writtenText = new StringBuilder();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                writtenText.append(line).append(System.lineSeparator());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return writtenText.toString().trim();
    }

}
