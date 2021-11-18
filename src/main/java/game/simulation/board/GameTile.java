package game.simulation.board;

import game.simulation.brains.Initialize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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


    public GameTile(String str, javafx.scene.image.Image img) throws FileNotFoundException {
        name = str;
        tile = img;
        floodedTile = Initialize.tiles.get(name+"Flooded");
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
            return new Image(new FileInputStream("src/main/resources/Images/Tiles/extra/Tile_Flood_Water@2x.png"));
        else if(isFlooded)
            return floodedTile;
        return new Image(new FileInputStream("src/main/resources/Images/Tiles/extra/Tile_Moat@2x.png"));
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

    public void setPosition(int[] position) {
        this.position = position;
    }

    public boolean isGone() {return isGone;}
}
