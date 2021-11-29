package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pilot extends Player{
    private boolean[][] moveableTiles;
    private int[] moveTo;
    private boolean[][] shoreableTiles;



    public Pilot(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
    }

    @Override
    public boolean[][] getMoveableTiles(GameTile gameTile){
        char[][] board = GameState.getCurrentState();
        for(int r = 0; r < 6; r++)
        {
            for(int c = 0; c < 6; c++)
            {
                if(board[r][c] == 'S')
                    moveableTiles[r][c] = false;

                else moveableTiles[r][c] = true;
            }
        }
        int pos[] = gameTile.getPosition();
        moveableTiles[pos[0]][pos[1]] = false;
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
