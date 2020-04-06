// Author: Preston Whittaker
// Date last Modified: 4/4/2020
// Fishing buddy Application

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class fishingBuddy extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //global variables
    Button buttonSubmit;


    @Override
    public void start(Stage primaryStage) {

        //creating the scene and grid pane for scene1
        GridPane pane = new GridPane();
        Scene scene1 = new Scene( pane,400, 400);

        //creating a Submit button
        buttonSubmit = new Button();
        buttonSubmit.setText("Submit");
        pane.getChildren().add(buttonSubmit);
        buttonSubmit.setOnAction( e -> ConfirmSubmit.confirmation("Submit", "Do you want to Submit? "));


        //displaying the window
        //placing the scene in the stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Fishing Buddy");
        primaryStage.show();
    }

}
