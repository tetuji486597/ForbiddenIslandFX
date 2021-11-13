package game.forbiddenislandfx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {
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
    void startGame(ActionEvent event) throws IOException {
        int num = (int) spinner.getValue();
        String d = dropdown.getValue();
        while(true){
            try{
                if(num==0) throw new NumberFormatException();
                if(d.isEmpty()) throw new NumberFormatException();
            }catch(NumberFormatException ex){
                System.out.println("error");
            }
            break;
        }
        System.out.println(num + " " + d);
        ParentPanel.menuPanel.hide();
        Stage game = new Stage();
        FXMLLoader gameLoader = new FXMLLoader(MenuController.class.getResource("game-board.fxml"));
        game.setTitle("How To Play");
        Scene gameScene = new Scene(gameLoader.load(), 1350, 755);
        game.setResizable(false);
//        JMetro helpMetro = new JMetro(Style.DARK);
//        helpMetro.setScene(helpScene);
        game.setScene(gameScene);
        gameScene.getStylesheets().add("moderna-darl.css");
        ParentPanel.setGamePanel(game);
        ParentPanel.gamePanel.show();
    }
}