package game.graphics;

import game.simulation.brains.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GameRunner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameRunner.class.getResource("splash-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 500);
//        JMetro jMetro = new JMetro(Style.DARK);
//        jMetro.setScene(scene);
        ParentPanel.setMenuPanel(stage);
        stage.setTitle("Menu");
        stage.setResizable(false);
        stage.setScene(scene);
        scene.getStylesheets().add("moderna-darl.css");
        stage.show();



        Stage help = new Stage();
        FXMLLoader menuLoader = new FXMLLoader(GameRunner.class.getResource("help-menu.fxml"));
        help.setTitle("How To Play");
        Scene helpScene = new Scene(menuLoader.load(), 600, 830);
//        JMetro helpMetro = new JMetro(Style.DARK);
//        helpMetro.setScene(helpScene);
        help.setScene(helpScene);
        help.setResizable(false);
        helpScene.getStylesheets().add("moderna-darl.css");
        ParentPanel.setHelpPanel(help);
        Initialize.init();

        Stage settings = new Stage();
        settings.setTitle("Settings");

    }

    public static void main(String[] args) {
        launch();
    }

}