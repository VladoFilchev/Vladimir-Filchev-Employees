package com.sirmasolutionsinternproject.assignmentManager;


import com.sirmasolutionsinternproject.models.Assignment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignmentFilter {

    public Map<String, Long> findLongestWorkingPair(List<Assignment> assignments) {
        Map<String, Long> longestWorkingPair = new HashMap<>();

        for (int i = 0; i < assignments.size(); i++) {
            for (int j = i + 1; j < assignments.size(); j++) {
                Assignment assignment1 = assignments.get(i);
                Assignment assignment2 = assignments.get(j);

                if (assignment1.getProjectId() == assignment2.getProjectId()) {
                    LocalDate commonStartDate = assignment1.getDateFrom().isAfter(assignment2.getDateFrom()) ?
                            assignment1.getDateFrom() : assignment2.getDateFrom();

                    LocalDate commonEndDate = assignment1.getDateTo().isBefore(assignment2.getDateTo()) ?
                            assignment1.getDateTo() : assignment2.getDateTo();

                    long days = ChronoUnit.DAYS.between(commonStartDate, commonEndDate);

                    if (days > 0) {
                        String pairKey = assignment1.getEmpId() + ", " + assignment2.getEmpId();
                        longestWorkingPair.put(pairKey, days);
                    }
                }
            }
        }

        return longestWorkingPair;
    }
}