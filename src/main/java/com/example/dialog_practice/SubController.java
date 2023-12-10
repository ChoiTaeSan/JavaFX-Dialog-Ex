package com.example.dialog_practice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SubController implements Initializable {

    @FXML private Button btn_back;
    @FXML private AnchorPane sub_layout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StackPane root = (StackPane) btn_back.getScene().getRoot();
                root.getChildren().remove(sub_layout);
            }
        });
    }
}
