package game.graphics;

import javafx.stage.Stage;

public class ParentPanel {
    static Stage menuPanel;
    static Stage helpPanel;
    static Stage gamePanel;

    public static void setMenuPanel(Stage s){
        menuPanel = s;
    }

    public static void setGamePanel(Stage gamePanel) {
        ParentPanel.gamePanel = gamePanel;
    }

    public static void setHelpPanel(Stage s){
        helpPanel = s;
    }
}
