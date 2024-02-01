module com.sirmasolutionsinternproject {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.sirmasolutionsinternproject to javafx.fxml;
    exports com.sirmasolutionsinternproject;
    exports com.sirmasolutionsinternproject.Controller;
    exports com.sirmasolutionsinternproject.UI;
}