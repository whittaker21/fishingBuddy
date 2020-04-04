// Author: Preston Whittaker
// Date last Modified: 4/4/2020
// Fishing buddy Application

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class fishingBuddy extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //setting up the group
        Group group = new Group();

        //creating the scene and filling it
        Scene scene = new Scene( group,400, 400);
        scene.setFill(Color.rgb(0,155,155));

        //placing the scene in the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fishing Buddy");

        //displaying the window
        primaryStage.show();
    }
}
