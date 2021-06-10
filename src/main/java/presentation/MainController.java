package presentation;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    public Label labelHi;
    public Button buttonPushIt;

    public void pushed(ActionEvent actionEvent) {
        if (labelHi.getText().equals("hi")) {
            labelHi.setText("bye");
        }
        else {
            labelHi.setText("hi");
        }
    }
}
