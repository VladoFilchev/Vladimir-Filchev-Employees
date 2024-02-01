package com.sirmasolutionsinternproject.Controller;

import com.sirmasolutionsinternproject.CSVManager.FileIO;
import com.sirmasolutionsinternproject.assignmentManager.AssignmentFilter;
import com.sirmasolutionsinternproject.models.Assignment;
import com.sirmasolutionsinternproject.models.DisplayData;
import com.sirmasolutionsinternproject.models.EmployeePair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MainScreenController {

    @FXML
    public Button browseButton;

    @FXML
    public TableColumn<DisplayData, Integer> firstEmployee;

    @FXML
    public TableColumn<DisplayData, Integer> projectID;

    @FXML
    public Pane root;

    @FXML
    public TableColumn<DisplayData, Integer> secondEmployee;

    @FXML
    public TableView<DisplayData> tableView;

    @FXML
    public TableColumn<DisplayData, Long> timeSpent;

    /**
     * Handles the action when the user clicks the "Browse" button to choose a CSV file.
     *
     * @param event The action event triggered by the button click.
     */

    @FXML
    public void chooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {

                FileIO fileIO = new FileIO();
                AssignmentFilter assignmentFilter = new AssignmentFilter();
                List<Assignment> assignments = fileIO.readAndToList(selectedFile);
                List<EmployeePair> employeePairs = new ArrayList<>(assignmentFilter.findLongestWorkingPair(assignments));

                ObservableList<DisplayData> displayDataList = FXCollections.observableArrayList();

                Collections.sort(employeePairs);
                Collections.reverse(employeePairs);

                for (EmployeePair employeePair : employeePairs) {
                    DisplayData displayData = new DisplayData(
                            employeePair.getFirstEmployee().getEmployeeID(),
                            employeePair.getSecondEmployee().getEmployeeID(),
                            employeePair.getProjectID(),
                            employeePair.getTimePeriod()
                    );
                    displayDataList.add(displayData);
                }

                tableView.setItems(displayDataList);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Initializes the TableView columns and associates them with the properties of DisplayData.
     */

    @FXML
    public void initialize() {
        firstEmployee.setCellValueFactory(cellData -> cellData.getValue().employeeId1Property().asObject());
        secondEmployee.setCellValueFactory(cellData -> cellData.getValue().employeeId2Property().asObject());
        projectID.setCellValueFactory(cellData -> cellData.getValue().projectIdProperty().asObject());
        timeSpent.setCellValueFactory(cellData -> cellData.getValue().daysWorkedProperty().asObject());
    }
}

