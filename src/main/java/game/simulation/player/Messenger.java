package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Messenger extends Player{
    private boolean[][] moveableTiles;

    public Messenger(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[3][3];

    }

    public boolean[][] getMoveableTiles(GameTile tile){
        int [] pos = tile.getPosition();
        int i = 0;
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {

                if(r == 1 && c == 1 || GameState.tiles[i].isGone()||
                        r == 0 && c != 1 || r == 2 && c!= 1)
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


    }
}
