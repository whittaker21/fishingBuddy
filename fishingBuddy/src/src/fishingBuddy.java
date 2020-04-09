// Author: Preston Whittaker
// Date last Modified: 4/8/2020
// Fishing buddy Application

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

public class fishingBuddy extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //global variables
     Button buttonSubmit;
     Button buttonClear;
    ImageView imageView;


    @Override
    public void start(Stage primaryStage) {

        //creating a Submit button and Labels
        Label labelSpecies = new Label("Fish Species: ");
        Label labelLength = new Label("Length (in): ");
        Label labelWeight= new Label("Weight(lb/oz): ");
        Label labelLocation = new Label("Location: ");
        Label labelTime = new Label("Time: ");

        buttonSubmit = new Button("Submit");
        buttonClear = new Button("Clear");

        //imageviewer
        Image imageFish = new Image("bass1.jpg");
        imageView = new ImageView(imageFish);


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
        //submit button
        buttonSubmit.setOnAction( e -> {
            boolean result = ConfirmSubmit.confirmation("Submit", "Do you want to Submit? ");
            System.out.println(result);
        });

        //clear button
        buttonClear.setOnAction(e -> {
            species.clear();
            length.clear();
            weight.clear();
            location.clear();
            time.clear();
        });

        //creating the scene and grid pane for scene1
        GridPane pane = new GridPane();

        //placing items into pane
        pane.addRow(1,labelSpecies, species);
        pane.addRow(2,labelLength, length);
        pane.addRow(3,labelWeight,weight);
        pane.addRow(4,labelLocation,location);
        pane.addRow(5,labelTime,time);
        pane.add(buttonSubmit,0,6);
        pane.add(buttonClear,1,6);
        pane.add(imageView, 2,0);


        //pane layout
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(10,10,10,10));
        GridPane.setHalignment(buttonClear, HPos.LEFT);
        GridPane.setHalignment(buttonSubmit, HPos.RIGHT);


        //displaying the window
        //placing the scene in the stage
        Scene scene1 = new Scene( pane,560, 370);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Fishing Buddy");
        primaryStage.show();
    }

}
