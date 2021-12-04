package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Engineer extends Player {
    private boolean[][] moveableTiles;
    private boolean[][] shoreableTiles;


    public Engineer(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role, startingDeck);
        moveableTiles = new boolean[6][6];
        shoreableTiles = new boolean[6][6];
    }

    @Override
    public boolean[][] getMoveableTiles(GameTile tile) {
        char[][] board = GameState.getCurrentState();
        int[] pos = tile.getPosition();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
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

    public void shoreUp(GameTile tile, Player p)
    {
        int[] tilePos = tile.getPosition();
        if((p.getPos() == tilePos || moveableTiles[tilePos[0]][tilePos[1]]) && tile.getFloodState() == true)
        {
            tile.setFlooded(false);
            setMoveNumber(moveNumber+1);
        }
    }

}
