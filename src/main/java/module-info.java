module com.sirmasolutionsinternproject {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.sirmasolutionsinternproject to javafx.fxml;
    exports com.sirmasolutionsinternproject;
}