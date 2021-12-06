package game.simulation.player;
//import game.simulation.brains.GameState;
import game.graphics.GameBoardController;
import game.simulation.board.*;
import game.simulation.brains.GameState;
import game.simulation.card.TreasureCard;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

//import java.lang.reflect.Array;
import javax.swing.*;
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
                pawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Diver_Adventurer_Icon@2x.png"));
                activePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Diver_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Diver_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Diver_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("IronGate").getPosition();
                break;
            case "Engineer":
                pawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Engineer_Adventurer_Icon@2x.png"));
                activePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Engineer_Adventurer_Icon_active@2x.png"));
                givePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Engineer_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Engineer_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("BronzeGate").getPosition();
                break;
            case "Explorer":
                pawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Explorer_Adventurer_Icon@2x.png"));
                activePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Explorer_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Explorer_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Explorer_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("CopperGate").getPosition();
                break;
            case "Messenger":
                pawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Messenger_Adventurer_Icon@2x.png"));
                activePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Messenger_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Messenger_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Messenger_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("SilverGate").getPosition();
                break;
            case "Navigator":
                pawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Navigator_Adventurer_Icon@2x.png"));
                activePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Navigator_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Navigator_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Navigator_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("GoldGate").getPosition();
                break;
            case "Pilot":
                pawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Pilot_Adventurer_Icon@2x.png"));
                activePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Pilot_Adventurer_IconSelect@2x.png"));
                givePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Pilot_Adventurer_Icon_give@2x.png"));
                movePawn = new Image(Player.class.getClassLoader().getResourceAsStream("Images/Pawns/Pilot_Adventurer_Icon_move@2x.png"));
                startingPos = GameState.tilesMap.get("FoolsLanding").getPosition();
                break;
        }
        position = startingPos;
        currentPawn = new ImageView(pawn);
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

//    public void disposeCard()
//    {
//        String[] filledDeck = playerDeck.toArray(new String[0]);
//        String cardToRemove;
//        cardToRemove = filledDeck[JOptionPane.showOptionDialog(
//                    null,
//                    "Choose one of these cards to discard from your deck.",
//                    "Deck Filled!",
//                    JOptionPane.YES_NO_CANCEL_OPTION,
//                    JOptionPane.INFORMATION_MESSAGE,
//                    null,
//                    filledDeck,
//                    0
//            )];
//           playerDeck.remove(playerDeck.indexOf(cardToRemove));
//
//    }

    public ArrayList<String> getDeck()
    {
        return playerDeck;
    }


    public ArrayList<Player> tradeablePlayers (){
        ArrayList<Player> tradeablePlayers = (ArrayList<Player>) GameState.allPlayers.clone();
        tradeablePlayers.remove(GameState.currentPlayer);
        String playerPos = Arrays.toString(getPos());
        if(getRole().equals("Messenger")){
            System.out.println(tradeablePlayers);
            return tradeablePlayers;
        }

        else{
            for(int i = tradeablePlayers.size()-1; i>=0 ; i--){
                if(Arrays.toString(tradeablePlayers.get(i).getPos()).equals(playerPos)){
                    continue;
                }
                else if(!Arrays.toString(tradeablePlayers.get(i).getPos()).equals(playerPos)){
                    tradeablePlayers.remove(i);
                }

            }
        }
        return tradeablePlayers;
    }

    public void giveTreasure(int treasure, Player send, Player receive) throws FileNotFoundException {
        ArrayList<String> rec = receive.getDeck();
        ArrayList<String> sen = send.getDeck();

        rec.add(sen.get(treasure));
        sen.get(treasure);
        GameBoardController.updateCards();
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

    public String getRetrievable(){
        int CrystalOfFire = 0;
        int StatueOfWind = 0;
        int OceansChalice = 0;
        int EarthStone = 0;
        ArrayList<String> deck = getDeck();
        for(String card: deck){
            switch (card) {
                case "CrystalOfFire" -> CrystalOfFire++;
                case "StatueOfWind" -> StatueOfWind++;
                case "OceansChalice" -> OceansChalice++;
                case "EarthStone" -> EarthStone++;
            }
        }
        if(CrystalOfFire == 4) return "CrystalOfFire";
        if(StatueOfWind == 4) return "StatueOfWind";
        if(OceansChalice == 4) return "OceansChalice";
        if(EarthStone == 4) return "EarthStone";
        return null;
    }

//    public boolean canRetrieve(){
//        int pos1[], pos2[];
//        switch (getRetrievable()){
//            case "CrystalOfFire":
//                pos1 = GameState.tilesMap.get()
//                break;
//            case "StatueOfWind" -> StatueOfWind++;
//            case "OceansChalice" -> OceansChalice++;
//            case "EarthStone" -> EarthStone++;
//        }
//    }


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
        for(String card: cardsToAdd) {
//            if(playerDeck.size() >= 5) disposeCard();
            playerDeck.add(card);
        }

    }

}
