// Author: Preston Whittaker
// Date last Modified: 4/7/2020
// Fishing buddy Application

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

        //creating a Submit button and Labels
        Label labelSpecies = new Label("Fish Species: ");
        Label labelLength = new Label("Length: ");
        Label labelWeight= new Label("Weight: ");
        Label labelLocation = new Label("Location: ");
        Label labelTime = new Label("Time: ");
        buttonSubmit = new Button("Submit");

        //Text Fields and binding
        TextField species = new TextField();
        labelSpecies.setLabelFor(species);
        TextField length = new TextField();
        labelLength.setLabelFor(length);
        TextField weight = new TextField();
        labelWeight.setLabelFor(weight);
        TextField location = new TextField();
        labelLocation.setLabelFor(location);
        TextField time = new TextField();
        labelTime.setLabelFor(time);

        //action handling
        buttonSubmit.setOnAction( e -> {
            boolean result = ConfirmSubmit.confirmation("Submit", "Do you want to Submit? ");
            System.out.println(result);
        });

        //creating the scene and grid pane for scene1
        GridPane pane = new GridPane();

        //placing items into pane
        pane.addRow(0,labelSpecies, species);
        pane.addRow(1,labelLength, length);
        pane.addRow(2,labelWeight,weight);
        pane.addRow(3,labelLocation,location);
        pane.addRow(4,labelTime,time);
        pane.add(buttonSubmit,1,5);

        //pane layout
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(10,10,10,10));

        //displaying the window
        //placing the scene in the stage
        Scene scene1 = new Scene( pane,250, 250);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Fishing Buddy");
        primaryStage.show();
    }

}
