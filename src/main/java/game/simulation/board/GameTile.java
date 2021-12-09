package game.simulation.board;

import game.graphics.GameRunner;
import game.graphics.ParentPanel;
import game.simulation.brains.GameState;
import game.simulation.brains.Initialize;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameTile {
    private String name;
    private javafx.scene.image.Image tile;
    private javafx.scene.image.Image floodedTile;
    private javafx.scene.image.Image sunkTile;
    private int[] position;
    private boolean isFlooded;
    private boolean isTreasure;
    private boolean isStarting;
    private boolean isGone;

    public GameTile(String str, Image img, int[] pos) {
        this(str,img);
        position = pos;
    }

    public GameTile(String str, javafx.scene.image.Image img) {
        name = str;
        tile = img;
        position = new int[]{-1,-1};
        floodedTile = Initialize.tiles.get(name+"Flooded");
        sunkTile = Initialize.tiles.get("Sunk");
        isFlooded = false;
        isTreasure = str.equals("CaveOfShadows") || str.equals("TidalPalace") || str.equals("WhisperingGarden") ||
                str.equals("TempleOfTheMoon") || str.equals("CaveOfEmbers") || str.equals("CoralPalace") ||
                str.equals("TempleOfTheSun") || str.equals("HowlingGarden");
        isStarting = str.equals("FoolsLanding") || str.equals("IronGate") || str.equals("BronzeGate") || str.equals("GoldGate") || str.equals("CopperGate");
        isGone = false;
    }

    public String getName(){
        return name;
    }

    public Image getTile() throws FileNotFoundException {
        if(!isFlooded)
            return tile;
        else if(isGone)
            return sunkTile;
        else if(isFlooded)
            return floodedTile;
        return new Image(GameTile.class.getResourceAsStream("Images/Tiles/extra/Tile_Moat@2x.png"));
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

    public void flood() {
        if(isFlooded){
            isGone = true;
            if(name.equals("FoolsLanding")) {
                GameState.controller.disableButtons();
                GameState.loseGame("Players have been stranded!");
                return;
            }
        } else {
            isFlooded = true;
        }
    }

    public boolean getTreasureState(){
        return isTreasure;
    }

    public boolean getStarting(){
        return isStarting;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setGone(boolean sunk){
        isGone = sunk;
    }

    public boolean isGone() {return isGone;}
}
