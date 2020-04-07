// Author: Preston Whittaker
// Last date modified: 4/6/2020
// Confirmation popup window


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmSubmit {

    static boolean result;

    public static boolean confirmation(String title, String message){
        Stage primaryWindow = new Stage();
        primaryWindow.initModality(Modality.APPLICATION_MODAL);

        //labels and buttons
        Label label = new Label();
        label.setText(message);
        Button buttonYes = new Button("Yes");
        Button buttonNo = new Button("No");

        //event handlers
        buttonYes.setOnAction(e ->{
          result = true;
          primaryWindow.close();
        });

        buttonNo.setOnAction( e -> {
            result = false;
            primaryWindow.close();
        });

        //setting up layout
        GridPane layout = new GridPane();
        layout.setMinSize(300, 100);
        layout.setPadding(new Insets(10, 10, 10 , 10));
        layout.setVgap(10);
        layout.setHgap(10);

        //adding items to layout
        layout.add(label, 0, 0);
        layout.add(buttonYes, 0, 1);
        GridPane.setHalignment(buttonYes, HPos.RIGHT);
        layout.add(buttonNo, 1, 1);



        //setting up scene and connecting it to stage
        Scene scene = new Scene(layout);
        primaryWindow.setTitle(title);
        primaryWindow.setScene(scene);
        primaryWindow.showAndWait();

        return result;
    }

}
