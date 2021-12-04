package game.simulation.player;
//import game.simulation.brains.GameState;
import game.simulation.board.*;
import game.simulation.brains.GameState;
import game.simulation.card.TreasureCard;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

//import java.lang.reflect.Array;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Player
{
    private ArrayList<String>   playerDeck;
    private boolean             deckFilled, hasSunk;
    private String              role;
    public int                 moveNumber;
    private int[]               position;
    private int[]               startingPos;
    private int                 index;
    private ImageView           currentPawn;
    private Image               pawn;
    private Image               activePawn;
    private Image               givePawn;
    private Image               movePawn;
    private GridPane            currentTile;
    private boolean[][]         shoreableTiles;
    private boolean[][]         navigableTiles;

    public Player(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        playerDeck = startingDeck;
        deckFilled = false;
        hasSunk = false;
        this.role = role;
        moveNumber = 0;
        position = new int[2];
        switch (role){
            case "Diver":
                pawn = new Image(new FileInputStream("/Images/Pawns/Diver_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("/Images/Pawns/Diver_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(new FileInputStream("/Images/Pawns/Diver_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("/Images/Pawns/Diver_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("IronGate").getPosition();
                break;
            case "Engineer":
                pawn = new Image(new FileInputStream("/Images/Pawns/Engineer_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("/Images/Pawns/Engineer_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(new FileInputStream("/Images/Pawns/Engineer_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("/Images/Pawns/Engineer_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("BronzeGate").getPosition();
                break;
            case "Explorer":
                pawn = new Image(new FileInputStream("/Images/Pawns/Explorer_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("/Images/Pawns/Explorer_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(new FileInputStream("/Images/Pawns/Explorer_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("/Images/Pawns/Explorer_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("CopperGate").getPosition();
                break;
            case "Messenger":
                pawn = new Image(new FileInputStream("/Images/Pawns/Messenger_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("/Images/Pawns/Messenger_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(new FileInputStream("/Images/Pawns/Messenger_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("/Images/Pawns/Messenger_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("SilverGate").getPosition();
                break;
            case "Navigator":
                pawn = new Image(new FileInputStream("/Images/Pawns/Navigator_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("/Images/Pawns/Navigator_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(new FileInputStream("/Images/Pawns/Navigator_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("/Images/Pawns/Navigator_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("GoldGate").getPosition();
                break;
            case "Pilot":
                pawn = new Image(new FileInputStream("/Images/Pawns/Pilot_Adventurer_Icon@2x.png"));
                activePawn = new Image(new FileInputStream("/Images/Pawns/Pilot_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(new FileInputStream("/Images/Pawns/Pilot_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(new FileInputStream("/Images/Pawns/Pilot_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("FoolsLanding").getPosition();
                break;
        }
        position = startingPos;
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

    public boolean[][] getShoreableTiles(GameTile gameTile){
        shoreableTiles = new boolean[6][6];
        int[] pos = gameTile.getPosition();
        int r = pos[0], c = pos[1];
        try {checkShoreableSurroundings(r - 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        try {checkShoreableSurroundings(r + 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        try {checkShoreableSurroundings(r, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        try {checkShoreableSurroundings(r, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        checkShoreableSurroundings(r, c);
        return shoreableTiles;
    }


    public void checkShoreableSurroundings(int r, int c){
        char[][] board = GameState.getCurrentState();
        if(board[r][c] == 'F') shoreableTiles[r][c] = true;
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

    public boolean[][] getMoveableTiles(GameTile tile) {
        return new boolean[6][6];
    }

    public boolean[][] getMoveableTiles(int[] tile) {
        return new boolean[6][6];
    }

    public ImageView getCurrentPawn() {
        return currentPawn;
    }

    public void setDeckFilled(boolean deckFilled) {
        this.deckFilled = deckFilled;
    }

    public int[] getStartingPos() {
        return startingPos;
    }

    public void setCurrentTile(GridPane currentTile) {
        this.currentTile = currentTile;
    }

    public void setActivePawn(String str){
        switch (str){
            case "move":
                currentPawn = new ImageView(movePawn);
                break;
            case "active":
                currentPawn = new ImageView(activePawn);
                break;
            case "give":
                currentPawn = new ImageView(givePawn);
                break;
            default:
                currentPawn = new ImageView(pawn);
                break;
        }
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


    public ArrayList<Player> tradeablePlayers (Player sender){
        ArrayList<Player> tradePlayer = new ArrayList<>();
        if(sender.getRole().equals("Messenger")){
          for(int i = 0; i<GameState.allPlayers.size(); i++){
              if(GameState.allPlayers.get(i).equals(sender.getRole())){
                  continue;
              }
              else{
                  tradePlayer.add(GameState.allPlayers.get(i));
              }

          }
        }

        else{
            for(int i = 0; i<GameState.allPlayers.size(); i++){
                if(GameState.allPlayers.get(i).equals(sender.getRole())){
                    continue;
                }
                else if(GameState.allPlayers.get(i).getPosition().equals(sender.getPosition())){
                    tradePlayer.add(GameState.allPlayers.get(i));
                }

            }
        }
        return tradePlayer;
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
                setMoveNumber(moveNumber+1);
                break;
            }
        }
    }

    public boolean[][] getNavigableTile(){
        navigableTiles = new boolean[6][6];
        int[] pos = getPos();
        int r = pos[0], c = pos[1];
        try{ checkNavigableSurroundings(r-1,c);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try{ checkNavigableSurroundings(r+1,c);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try{ checkNavigableSurroundings(r,c-1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try{ checkNavigableSurroundings(r,c+1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try{ checkNavigableSurroundings(r,c);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        return navigableTiles;
    }

    public void checkNavigableSurroundings(int r, int c){
        try {checkNaviagableTile(r-1,c);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try {checkNaviagableTile(r+1,c);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try {checkNaviagableTile(r,c-1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try {checkNaviagableTile(r,c+1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
    }

    public void checkNaviagableTile(int r, int c) {
        char[][] board = GameState.getCurrentState();
        if (board[r][c] == 'O')
            navigableTiles[r][c] = true;
        else if (board[r][c] == 'F')
            navigableTiles[r][c] = true;
        else if (board[r][c] == 'S')
            navigableTiles[r][c] = false;
    }

    public boolean getRetrievable(Player retriever, String treasure){
        ArrayList<String> deck = retriever.getDeck();
        int i = 0;
        for(String card: deck){
            if(card.equals(treasure)){
                i++;
            }
        }
        if(i == 4){
            return true;
        }
        return false;

    }



    public int[] getPosition() {
        return position;
    }
    public int[] getPos() {
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

    public boolean shoreUp(int[] pos)
    {
        boolean[][] shore = GameState.currentPlayer.getShoreableTiles(GameState.posMap.get(Arrays.toString(GameState.currentPlayer.getPosition())));
        if(shore[pos[0]][pos[1]] && GameState.posMap.get(Arrays.toString(pos)).getFloodState()) {
            setMoveNumber(moveNumber+1);
            return true;
        } else
            return false;
    }

    public boolean movePawn( int[] pos)
    {
        boolean[][] move = GameState.currentPlayer.getMoveableTiles(GameState.posMap.get(Arrays.toString(GameState.currentPlayer.getPosition())));

        if(move[pos[0]][pos[1]]){
            setMoveNumber(moveNumber+1);
             return true;
        }
        else
            return false;
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


    public void addCards(ArrayList<String> cardsToAdd) {
        for(String card: cardsToAdd) playerDeck.add(card);
    }

}
