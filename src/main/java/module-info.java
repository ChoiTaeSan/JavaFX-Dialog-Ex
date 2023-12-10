module com.example.dialog_practice {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.dialog_practice to javafx.fxml;
    exports com.example.dialog_practice;
}