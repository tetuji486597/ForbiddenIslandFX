package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Engineer extends Player{
    private boolean[][] moveableTiles;

    public Engineer(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role, startingDeck);//
        // moveableTiles = new boolean[GameState.tiles.length];
        moveableTiles = new boolean[3][3];
        }

    public boolean[][] getMoveableTiles(GameTile tile){
       int [] pos = tile.getPosition();
       int i = 0;
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {

                if(r == 1 && c == 1 || GameState.tiles[i].isGone())
                {
                    moveableTiles[r][c] = false;
                }

                else
                {
                    moveableTiles[r][c] = true;
                }
                i++;
            }
        }
        return moveableTiles;

       /*
        for(int i = 0; i<GameState.tiles.length; i++){
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

*/
    }
}
