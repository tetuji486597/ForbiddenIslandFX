package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pilot extends Player{
    private boolean[][] moveableTiles;
    private int[] moveTo;


    public Pilot(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
    }

    @Override
    public boolean[][] getMoveableTiles(GameTile gameTile){
        for(int r = 0; r < 6; r++)
        {
            for(int c = 0; c < 6; c++)
            {
                moveableTiles[r][c] = true;

            }
        }
        return moveableTiles;
    }

    public void movePawn(GameTile tile, int[] coords, Player p)
    {
        moveTo = coords;
        if(moveableTiles[moveTo[0]][moveTo[1]] )
        {
            p.updatePosition(moveTo);
        }
    }
}
