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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class fishingBuddy extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //global variables
    private static Button buttonLoadImage;
    private static Button buttonSubmit;
    private static Button buttonClear;
    private static ImageView imageView;
    private static File selectedFile;



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
        buttonLoadImage = new Button("Load Image");

        //imageviewer
        Image noImage = new Image("noImg.jpg");
        imageView = new ImageView(noImage);
        imageView.setFitWidth(400);
        imageView.setFitHeight(225);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);



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

        //Load Image button
        buttonLoadImage.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            selectedFile = fileChooser.showOpenDialog(primaryStage);
            Image newImage = new Image(selectedFile.toURI().toString());
            imageView.setImage(newImage);

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
        pane.add(buttonLoadImage, 2,1);


        //pane layout
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(10,10,10,10));
        GridPane.setHalignment(buttonClear, HPos.LEFT);
        GridPane.setHalignment(buttonSubmit, HPos.RIGHT);
        GridPane.setHalignment(buttonLoadImage, HPos.CENTER);


        //displaying the window
        //placing the scene in the stage
        Scene scene1 = new Scene( pane,600, 430);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Fishing Buddy");
        primaryStage.show();
    }

}
