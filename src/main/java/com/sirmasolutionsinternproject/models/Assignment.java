package com.sirmasolutionsinternproject.models;

import java.time.LocalDate;

public class Assignment {
    private final int empId;
    private final int projectId;
    private final  LocalDate dateFrom;
    private final LocalDate dateTo;

    public Assignment(int empId, int projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.empId = empId;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
        this.dateTo = (dateTo != null) ? dateTo : LocalDate.now();
    }

    public int getEmpId() {
        return empId;
    }


    public int getProjectId() {
        return projectId;
    }


    public LocalDate getDateFrom() {
        return dateFrom;
    }


    public LocalDate getDateTo() {
        return dateTo;
    }


    @Override
    public String toString() {
        return empId + "," + projectId + "," + dateFrom + "," + dateTo;
    }
}