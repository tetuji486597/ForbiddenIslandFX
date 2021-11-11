package game.forbiddenislandfx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Button help;

    @FXML
    private ComboBox<String> dropdown;

    @FXML
    private Button button;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    void showHelp(ActionEvent event) {
        ParentPanel.helpPanel.show();
    }

    @FXML
    void startGame(ActionEvent event) {
        int num = (int) spinner.getValue();
        String d = dropdown.getValue();
        System.out.println(num + " " + d);
    }
}