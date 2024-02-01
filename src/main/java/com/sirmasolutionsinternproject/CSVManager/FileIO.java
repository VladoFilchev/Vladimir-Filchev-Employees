package com.sirmasolutionsinternproject.CSVManager;

import com.sirmasolutionsinternproject.models.Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    BufferedReader reader = null;
    String line = "";
    String regex =",";


    /**
     * Reads the content of a CSV file and converts it into a list of Assignment objects.
     *
     * @param file The CSV file to read.
     * @return A list of Assignment objects representing the data in the CSV file.
     * @throws IOException If an error occurs while reading the file.
     */
    public List<Assignment> readAndToList(File file) throws IOException {



        List<Assignment> assignments = new ArrayList<>();

        int empID = 0;
        int projID = 0;
        LocalDate dateFrom;
        LocalDate dateTo;


        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {

                String[] row = line.split(regex);

                empID = Integer.parseInt(row[0]);
                projID = Integer.parseInt(row[1]);
                dateFrom = LocalDate.parse(row[2]);

                if (row.length < 4 || row[3].equals("NULL")) {
                    dateTo = LocalDate.now();
                } else {
                    dateTo = LocalDate.parse(row[3]);
                }

                Assignment assignment = new Assignment(empID, projID, dateFrom, dateTo);

                assignments.add(assignment);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            reader.close();
        }
        return assignments;
    }
}