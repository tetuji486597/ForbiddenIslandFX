package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pilot extends Player{
    private boolean[][] moveableTiles;

    public Pilot(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
    }


    public boolean[][] getMoveableTiles(){
        for(int r = 0; r < 6; r++)
        {
            for(int c = 0; c < 6; c++)
            {
                moveableTiles[r][c] = true;

            }
        }
        return moveableTiles;
    }
}
