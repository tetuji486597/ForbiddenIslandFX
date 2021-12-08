package game.graphics;

import game.simulation.brains.GameState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DefeatController implements Initializable {

    @FXML
    public Label defeatText;

    public void setDefeatText(String message) {
        defeatText.setText(message);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        defeatText.setText(GameState.defeatMessage);
    }
}
