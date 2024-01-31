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

    String filePath="C:\\Users\\Star huy 67\\Java Projects\\SirmaSolutionsInternProject\\src\\main\\resources\\CSVFiles\\assignments.csv";
    BufferedReader reader = null;
    String line = "";
    String regex =",";

    public List<Assignment> readAndToList() throws IOException {

        List<Assignment> assignments = new ArrayList<>();

        int empID = 0;
        int projID = 0;
        LocalDate dateFrom;
        LocalDate dateTo;

        try {
            reader = new BufferedReader(new FileReader(filePath));
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

            for (Assignment assignment : assignments) {
                System.out.println(assignment+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            reader.close();
        }
        return assignments;
    }
}