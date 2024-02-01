package com.sirmasolutionsinternproject.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class EmployeePair implements Comparable<EmployeePair> {
    private final int projectID;
    private final Employee firstEmployee;
    private final Employee secondEmployee;

    private final Long timePeriod;

    public EmployeePair(int projectID, Employee firstEmployee, Employee secondEmployee) {
        this.projectID = projectID;
        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
        this.timePeriod = calculatePeriod();
    }

    public int getProjectID() {
        return projectID;
    }

    public Long getTimePeriod() {
        return timePeriod;
    }

    /**
     * Calculates the common time period during which both employees worked on the project.
     * If the common time period is negative, it returns 0.
     *
     * @return The calculated time period.
     */

    private Long calculatePeriod() {

        LocalDate commonStartDate = firstEmployee.getDateFrom().isAfter(secondEmployee.getDateFrom()) ?
                firstEmployee.getDateFrom() : secondEmployee.getDateFrom();

        LocalDate commonEndDate = firstEmployee.getDateTo().isBefore(secondEmployee.getDateTo()) ?
                firstEmployee.getDateTo() : secondEmployee.getDateTo();


        if(ChronoUnit.DAYS.between(commonStartDate, commonEndDate)<0){
            return 0L;
        }

        return ChronoUnit.DAYS.between(commonStartDate, commonEndDate);

    }

    @Override
    public int compareTo(EmployeePair o) {
        return this.timePeriod.compareTo(o.timePeriod);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePair that = (EmployeePair) o;
        return projectID == that.projectID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectID);
    }

    @Override
    public String toString() {
        return "Employees ID:\n" + firstEmployee.getEmployeeID() + " , " + secondEmployee.getEmployeeID() + "\nProject ID:\n" + getProjectID() + "\nTime Period:\n" + getTimePeriod() + "\n";
    }

    public Employee getFirstEmployee() {
        return firstEmployee;
    }

    public Employee getSecondEmployee() {
        return secondEmployee;
    }
}
