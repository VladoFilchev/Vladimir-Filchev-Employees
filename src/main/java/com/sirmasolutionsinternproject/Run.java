package com.sirmasolutionsinternproject;

import com.sirmasolutionsinternproject.CSVManager.FileIO;
import com.sirmasolutionsinternproject.assignmentManager.AssignmentFilter;
import com.sirmasolutionsinternproject.models.Assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Run {
    public static void main(String[] args) throws IOException {
        FileIO fileIO = new FileIO();
        AssignmentFilter assignmentFilter = new AssignmentFilter();
        List<Assignment> assignments = new ArrayList<>(fileIO.readAndToList());
        Map<String, Long> longestWorkingPair = assignmentFilter.findLongestWorkingPair(assignments);

        if (!longestWorkingPair.isEmpty()) {
            System.out.println("Pair of employees who have worked together for the longest period:");
            for (Map.Entry<String, Long> entry : longestWorkingPair.entrySet()) {
                System.out.println(entry.getKey() + ", " + entry.getValue());
            }
        } else {
            System.out.println("No common projects found.");
        }
    }
}
