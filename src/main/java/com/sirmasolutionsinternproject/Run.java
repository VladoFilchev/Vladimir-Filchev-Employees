package com.sirmasolutionsinternproject;

import com.sirmasolutionsinternproject.CSVManager.FileIO;
import com.sirmasolutionsinternproject.assignmentManager.AssignmentFilter;
import com.sirmasolutionsinternproject.models.Assignment;
import com.sirmasolutionsinternproject.models.EmployeePair;

import java.io.IOException;
import java.util.*;

public class Run {
    public static void main(String[] args) throws IOException {

        FileIO fileIO = new FileIO();

        AssignmentFilter assignmentFilter = new AssignmentFilter();
        List<Assignment> assignments = new ArrayList<>(fileIO.readAndToList());
        List<EmployeePair> employeePairs = new ArrayList<>(assignmentFilter.findLongestWorkingPair(assignments));

        Collections.sort(employeePairs);
        Collections.reverse(employeePairs);
        EmployeePair employeePair = employeePairs.get(0);
        for (EmployeePair firstEmployeePair : employeePairs) {
            if (firstEmployeePair.getTimePeriod().equals(employeePair.getTimePeriod()) && !employeePair.equals(firstEmployeePair)) {
                System.out.println(firstEmployeePair);
            }
        }
        System.out.println(employeePair);

    }
}
