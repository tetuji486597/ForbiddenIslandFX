package game.forbiddenislandfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
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
        FXMLLoader menuLoader = new FXMLLoader(HelloApplication.class.getResource("help-menu.fxml"));
        help.setTitle("How To Play");
        Scene helpScene = new Scene(menuLoader.load(), 600, 800);
//        JMetro helpMetro = new JMetro(Style.DARK);
//        helpMetro.setScene(helpScene);
        help.setScene(helpScene);
        helpScene.getStylesheets().add("moderna-darl.css");
        ParentPanel.setHelpPanel(help);


        Stage game = new Stage();
        FXMLLoader gameLoader = new FXMLLoader(HelloApplication.class.getResource("game-board.fxml"));
        game.setTitle("How To Play");
        Scene gameScene = new Scene(gameLoader.load(), 1350, 755);
        game.setResizable(false);
//        JMetro helpMetro = new JMetro(Style.DARK);
//        helpMetro.setScene(helpScene);
        game.setScene(gameScene);
        gameScene.getStylesheets().add("moderna-darl.css");
        ParentPanel.setGamePanel(game);


    }

    public static void main(String[] args) {
        launch();
    }

}