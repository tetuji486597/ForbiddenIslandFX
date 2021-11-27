package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Messenger extends Player{
    private boolean[][] moveableTiles;

    public Messenger(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];

    }

    @Override
    public boolean[][] getMoveableTiles(GameTile tile){
        char[][] board = GameState.getCurrentState();
        int [] pos = tile.getPosition();
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                if(board[r][c] == 'S' || r == pos[0] && c == pos[1])
                    moveableTiles[r][c] = false;
                else if(r == pos[0]-1 && c == pos[1] || r == pos[0] && c == pos[1]-1 || r == pos[0] && c == pos[1]+1
                        || r == pos[0] +1 && c == pos[1]){
                    moveableTiles[r][c] = true;
                }
                else moveableTiles[r][c] = false;

            }
        }
        return moveableTiles;


    }
}
