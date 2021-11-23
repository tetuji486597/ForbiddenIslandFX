package game.simulation.player;
//import game.simulation.brains.GameState;
import game.graphics.GameBoardController;
import game.simulation.board.*;
import game.simulation.brains.GameState;
import game.simulation.card.Card;
import game.simulation.card.TreasureCard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

//import java.lang.reflect.Array;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Player
{
    private ArrayList<String>   playerDeck;
    private boolean             deckFilled, hasSunk;
    private String              role;
    private int                 moveNumber;
    private int[]               position;
    private String               startingPos;
    private int                 index;
    private ImageView           currentPawn;
    private Image               pawn;
    private Image               activePawn;
    private Image               givePawn;
    private Image               movePawn;
    private GridPane            currentTile;

    public Player(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        playerDeck = startingDeck;
        deckFilled = false;
        hasSunk = false;
        this.role = role;
        moveNumber = 0;
        position = new int[2];
        switch (role){
            case "Diver":
                pawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Diver_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Diver_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Diver_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Diver_Adventurer_Icon_move@2x.png"));
                startingPos = Arrays.toString(GameState.tilesMap.get("IronGate").getPosition());
                break;
            case "Engineer":
                pawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Engineer_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Engineer_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Engineer_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Engineer_Adventurer_Icon_move@2x.png"));
                startingPos = Arrays.toString(GameState.tilesMap.get("BronzeGate").getPosition());
                break;
            case "Explorer":
                pawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Explorer_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Explorer_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Explorer_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Explorer_Adventurer_Icon_move@2x.png"));
                startingPos = Arrays.toString(GameState.tilesMap.get("CopperGate").getPosition());
                break;
            case "Messenger":
                pawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Messenger_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Messenger_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Messenger_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Messenger_Adventurer_Icon_move@2x.png"));
                startingPos = Arrays.toString(GameState.tilesMap.get("SilverGate").getPosition());
                break;
            case "Navigator":
                pawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Navigator_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Navigator_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Navigator_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Navigator_Adventurer_Icon_move@2x.png"));
                startingPos = Arrays.toString(GameState.tilesMap.get("GoldGate").getPosition());
                break;
            case "Pilot":
                pawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Pilot_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Pilot_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Pilot_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("src/main/resources/Images/Pawns/Pilot_Adventurer_Icon_move@2x.png"));
                startingPos = Arrays.toString(GameState.tilesMap.get("FoolsLanding").getPosition());
                break;
        }
        currentPawn = new ImageView(pawn);
    }

    public void drawCard(String c)
    {
        if(deckFilled){
            this.disposeCard();

        }
        playerDeck.add(c);
        if(playerDeck.size()==5){
            this.setDeckFilled(true);
        }
    }

    public void setIndex(int ind){
        index = ind;
    }

    public void updatePosition(int[] newPos)
    {
        position = newPos;
    }

    public void disposeTreasure(String treasure)
    {
        ArrayList<String> player = this.playerDeck;

        for(String card: player)
        {
            if(card.equals(treasure))
            {
                player.remove(card);
            }
        }
    }

    public ImageView getCurrentPawn() {
        return currentPawn;
    }

    public void setDeckFilled(boolean deckFilled) {
        this.deckFilled = deckFilled;
    }

    public String getStartingPos() {
        return startingPos;
    }

    public void setCurrentTile(GridPane currentTile) {
        this.currentTile = currentTile;
    }

    public void disposeCard()
    {
        ArrayList<String> player = this.playerDeck;
        if(deckFilled)
        {
           player.remove(player.size()-1);
        }
    }

    public ArrayList<String> getDeck()
    {
        return playerDeck;
    }


    public void giveTreasure(String treasure, Player send, Player receive)
    {
        ArrayList<String> rec = receive.getDeck();
        ArrayList<String> sen = send.getDeck();

        for(String card: sen)
        {
            if(card.equals(treasure))
            {
                sen.remove(card);
                rec.add(card);
                break;
            }
        }
    }

    public int[] getPosition() {
        return position;
    }

    public int getIndex() {
        return index;
    }

    public Image getPawn() {
        return pawn;
    }

    public Image getActivePawn() {
        return activePawn;
    }

    public Image getGivePawn() {
        return givePawn;
    }

    public Image getMovePawn() {
        return movePawn;
    }

    public GridPane getCurrentTile() {
        return currentTile;
    }

    public void shoreUp(GameTile tile)
    {
        tile.setFlooded(false);
    }

    public void movePawn(int[] pos)
    {
        position = pos;
    }

    public int[] getPos()
    {
        return position;
    }

    public int getMoveNumber()
    {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public String getRole() {
        return role;
    }

    public void setPosition(int[] pos) {
        position = pos;
    }
}
