package game.simulation.board;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameTile {
    private String name;
    private javafx.scene.image.Image tile;
    private int[] position;
    private boolean isFlooded;
    private boolean isTreasure;
    private boolean isStarting;


    public GameTile(String str, javafx.scene.image.Image img) {
        name = str;
        tile = img;
        isFlooded = false;
        isTreasure = str.equals("CaveOfShadows") || str.equals("TidalPalace") || str.equals("WhisperingGarden") ||
                str.equals("TempleOfTheMoon") || str.equals("CaveOfEmbers") || str.equals("CoralPalace") ||
                str.equals("TempleOfTheSun") || str.equals("HowlingGarden");
        isStarting = str.equals("FoolsLanding") || str.equals("IronGate") || str.equals("BronzeGate") || str.equals("GoldGate") || str.equals("CopperGate");
    }

    public String getName(){
        return name;
    }

    public Image getTile() {
        return tile;
    }

    public int[] getPosition(){
        return position;
    }

    public boolean getFloodState(){
        return isFlooded;
    }

    public void setFlooded(boolean floodState){
        this.isFlooded = floodState;
    }

    public boolean getTreasureState(){
        return isTreasure;
    }

    public boolean getStarting(){
        return isStarting;
    }


}
