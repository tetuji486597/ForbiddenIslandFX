package game.graphics;

import javafx.stage.Stage;

public class ParentPanel {
    static Stage menuPanel;
    static Stage helpPanel;
    static Stage gamePanel;
    public static Stage victoryPanel;
    public static Stage losingPanel;

    public static void setMenuPanel(Stage s){
        menuPanel = s;
    }

    public static void setGamePanel(Stage gamePanel) {
        ParentPanel.gamePanel = gamePanel;
    }

    public static void setHelpPanel(Stage s){
        helpPanel = s;
    }
    public static void setVictoryPanel(Stage s) {
        victoryPanel = s;
    }
    public static void setLosingPanel(Stage s) {
        losingPanel = s;
    }
}
