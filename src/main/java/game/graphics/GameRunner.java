package game.graphics;

import game.simulation.brains.Initialize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GameRunner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameRunner.class.getResource("hello-view.fxml"));
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
        Scene helpScene = new Scene(menuLoader.load(), 600, 800);
//        JMetro helpMetro = new JMetro(Style.DARK);
//        helpMetro.setScene(helpScene);
        help.setScene(helpScene);
        helpScene.getStylesheets().add("moderna-darl.css");
        ParentPanel.setHelpPanel(help);
        Initialize.init();

    }

    public static void main(String[] args) {
        launch();
    }

}