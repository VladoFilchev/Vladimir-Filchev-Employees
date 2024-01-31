package com.sirmasolutionsinternproject.models;

import java.time.LocalDate;

public class Employee {
    private int employeeID;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Employee(int employeeID, LocalDate dateFrom, LocalDate dateTo) {
        this.employeeID = employeeID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }


}
