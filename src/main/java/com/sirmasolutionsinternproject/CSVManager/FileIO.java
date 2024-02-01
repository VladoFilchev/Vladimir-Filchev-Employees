package com.sirmasolutionsinternproject.CSVManager;

import com.sirmasolutionsinternproject.models.Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    BufferedReader reader = null;
    String line = "";
    String regex =",";

    private static final DateTimeFormatter[] dateFormatters = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),

            DateTimeFormatter.ofPattern("dd-MM-yyyy"),

            DateTimeFormatter.ofPattern("MM-dd-yyyy"),

            DateTimeFormatter.ofPattern("MM/dd/yyyy"),

            DateTimeFormatter.ofPattern("yyyy/MM/dd"),

            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
    };

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
                dateFrom = parseDate(row[2],dateFormatters);

                if (row.length < 4 || row[3].equals("NULL")) {
                    dateTo = LocalDate.now();
                } else {
                    dateTo = parseDate(row[3],dateFormatters);
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
    private LocalDate parseDate(String dateString, DateTimeFormatter[] dateFormatters) {
        for (DateTimeFormatter formatter : dateFormatters) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (Exception e) {

            }
        }
        throw new IllegalArgumentException("Unable to parse date: " + dateString);
    }
}