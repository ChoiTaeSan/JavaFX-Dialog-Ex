package com.example.dialog_practice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private Label welcomeText;
    private Stage primaryStage;

    @FXML private MenuItem mi_popup, mi_custom;
    @FXML private Button btn_ok, btn_next;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onFileChooserOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files", "*.txt"),
                new FileChooser.ExtensionFilter("Image files", "*.png")
        );

        File file = fileChooser.showOpenDialog(primaryStage);
        String filePath = file.getPath();
        welcomeText.setText(filePath);
    }
    @FXML
    protected void onDirectoryChooserOpen() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(primaryStage);
        String filePath = file.getPath();
        welcomeText.setText(filePath);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btn_next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent sub = FXMLLoader.load(getClass().getResource("sub.fxml"));
                    StackPane root = (StackPane) btn_next.getScene().getRoot();
                    //스택팬에다가 sub 추가해주면 됨
                    root.getChildren().add(sub);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mi_custom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage dialog = new Stage(StageStyle.UTILITY);
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(primaryStage);

                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("custom.fxml"));

                    Button btnOk = (Button) parent.lookup("#btn_ok");

                    btnOk.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            dialog.close();
                        }
                    });

                    Scene scene = new Scene(parent);
                    dialog.setScene(scene);
                    dialog.show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mi_popup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Popup popup = new Popup();
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("popup.fxml"));
                    popup.getContent().add(parent);
                    popup.setAutoHide(true);
                    popup.show(primaryStage);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}
