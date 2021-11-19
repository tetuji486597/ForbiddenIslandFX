package game.simulation.player;
//import game.simulation.brains.GameState;
import game.simulation.board.*;
import game.simulation.brains.GameState;
import game.simulation.card.Card;
import game.simulation.card.TreasureCard;

//import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player
{
    private ArrayList<String> playerDeck;
    private boolean deckFilled, hasSunk;
    private String role;
    private int moveNumber;
    private int[] position;
    private boolean[] moveableTiles;
    private boolean[] shoreableTiles;

    public Player(String role, ArrayList<String> startingDeck)
    {
        playerDeck = startingDeck;
        deckFilled = false;
        hasSunk = false;
        this.role = role;
        moveNumber = 0;
        position = new int[2];
        moveableTiles = new boolean[GameState.tiles.length];
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

    public boolean[] getMoveableTiles(GameTile tile) {
        int [] pos = tile.getPosition();
        for(int i = 0; i< GameState.tiles.length; i++){
            int[] temp = GameState.tiles[i].getPosition();
            if(GameState.tiles[i].isGone()){
                moveableTiles[i] = false;
            }
            else if((temp[0] == pos[0] && temp[1] == pos[1] + 1) || (temp[0] == pos[0] && temp[1] == pos[1]-1) ||
                    (temp[0] == pos[0]+1 && temp[1] == pos[1]) || (temp[0] == pos[0] -1 && temp[1]==pos[1])){
                moveableTiles[i] = true;
            }
            else{
                moveableTiles[i] = false;
            }

        }


        return moveableTiles;
    }
    public boolean[] getShoreableTiles(GameTile tile) {
        int [] pos = tile.getPosition();
        for(int i = 0; i< GameState.tiles.length; i++){
            int[] temp = GameState.tiles[i].getPosition();
            if(GameState.tiles[i].isGone() || GameState.tiles[i].getFloodState()){
                shoreableTiles[i] = false;
            }
            else if((temp[0] == pos[0] && temp[1] == pos[1] + 1) || (temp[0] == pos[0] && temp[1] == pos[1]-1) ||
                    (temp[0] == pos[0]+1 && temp[1] == pos[1]) || (temp[0] == pos[0] -1 && temp[1]==pos[1])){
                shoreableTiles[i] = true;
            }
            else{
                shoreableTiles[i] = false;
            }

        }


        return shoreableTiles;
    }

    public void setDeckFilled(boolean deckFilled) {
        this.deckFilled = deckFilled;
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
