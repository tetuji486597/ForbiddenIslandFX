package game.graphics;

import game.simulation.brains.GameState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

import java.io.IOException;

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
        int diff = 0;
        if(d.equalsIgnoreCase("novice")) diff = 1;
        else if(d.equalsIgnoreCase("normal")) diff = 2;
        else if(d.equalsIgnoreCase("elite")) diff = 3;
        else if(d.equalsIgnoreCase("legendary")) diff = 4;

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
        game.setTitle("Forbidden Island");
        Scene gameScene = new Scene(gameLoader.load(), 1375, 930);
        game.setResizable(false);
//        JMetro helpMetro = new JMetro(Style.DARK);
//        helpMetro.setScene(helpScene);
        game.setScene(gameScene);
        gameScene.getStylesheets().add("moderna-darl.css");
        ParentPanel.setGamePanel(game);
        ParentPanel.gamePanel.show();
        GameState gameState = new GameState(diff,num);
    }
}