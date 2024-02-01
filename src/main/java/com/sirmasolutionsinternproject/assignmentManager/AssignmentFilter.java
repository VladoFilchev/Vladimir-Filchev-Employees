package com.sirmasolutionsinternproject.assignmentManager;


import com.sirmasolutionsinternproject.models.Assignment;
import com.sirmasolutionsinternproject.models.Employee;
import com.sirmasolutionsinternproject.models.EmployeePair;


import java.util.*;

public class AssignmentFilter {


    /**
     * Finds pairs of employees who have worked on the same project and creates EmployeePair objects.
     *
     * @param assignments A list of Assignment objects representing employees' project assignments.
     * @return A set of EmployeePair objects representing pairs of employees working on the same project.
     */

    public Set<EmployeePair> findLongestWorkingPair(List<Assignment> assignments) {

        Set<EmployeePair> employeePairs = new HashSet<>();

        for (Assignment assignment : assignments) {
            for (Assignment secondAssignment : assignments) {
                if (assignment.equals(secondAssignment)) {
                    continue;
                }
                if (assignment.getProjectId() == secondAssignment.getProjectId()) {
                    Employee firstEmployee = new Employee(assignment.getEmpId(), assignment.getDateFrom(), assignment.getDateTo());
                    Employee secondEmployee = new Employee(secondAssignment.getEmpId(), secondAssignment.getDateFrom(), secondAssignment.getDateTo());
                    EmployeePair employeePair = new EmployeePair(assignment.getProjectId(), firstEmployee, secondEmployee);
                    employeePairs.add(employeePair);
                }
            }
        }
        return employeePairs;

    }
}