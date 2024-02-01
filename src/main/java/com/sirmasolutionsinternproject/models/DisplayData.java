package com.sirmasolutionsinternproject.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class DisplayData {
    private final IntegerProperty employeeId1;
    private final IntegerProperty employeeId2;
    private final IntegerProperty projectId;
    private final LongProperty daysWorked;

    public DisplayData(int employeeId1, int employeeId2, int projectId, long daysWorked) {
        this.employeeId1 = new SimpleIntegerProperty(employeeId1);
        this.employeeId2 = new SimpleIntegerProperty(employeeId2);
        this.projectId = new SimpleIntegerProperty(projectId);
        this.daysWorked = new SimpleLongProperty(daysWorked);
    }

    public int getEmployeeId1() {
        return employeeId1.get();
    }

    public IntegerProperty employeeId1Property() {
        return employeeId1;
    }

    public int getEmployeeId2() {
        return employeeId2.get();
    }

    public IntegerProperty employeeId2Property() {
        return employeeId2;
    }

    public int getProjectId() {
        return projectId.get();
    }

    public IntegerProperty projectIdProperty() {
        return projectId;
    }

    public long getDaysWorked() {
        return daysWorked.get();
    }

    public LongProperty daysWorkedProperty() {
        return daysWorked;
    }
}
