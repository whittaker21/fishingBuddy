// Author: Preston Whittaker
// Last date modified: 4/6/2020
// Confirmation popup window


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
        primaryWindow.setTitle(title);
        primaryWindow.setMinWidth(200);

        //labels and buttons
        Label label = new Label();
        label.setText(message);
        Button buttonYes = new Button("Yes");
        Button buttonNo = new Button("No");

        //setting up layout
        GridPane layout = new GridPane();
        layout.add(buttonYes, 0, 0);
        layout.add(buttonNo, 1, 0);


        //setting up scene and connecting it to stage
        Scene scene = new Scene(layout);
        primaryWindow.setScene(scene);
        primaryWindow.showAndWait();

        return result;

    }

}
