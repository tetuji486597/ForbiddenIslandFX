package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Navigator extends Player{
    private boolean[][] moveableTiles;
    private boolean[][] otherMoveableTiles;
    private boolean[][] shoreableTiles;


    public Navigator(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
        otherMoveableTiles = new boolean [6][6];
        shoreableTiles = new boolean[6][6];

    }

    @Override
    public boolean[][] getMoveableTiles(GameTile tile){
        moveableTiles = new boolean[6][6];
        int pos[] = tile.getPosition();
        int r = pos[0], c = pos[1];
        try {checkMoveable(r-1,c);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try {checkMoveable(r,c-1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try {checkMoveable(r+1,c);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try {checkMoveable(r,c+1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        moveableTiles[r][c] = false;
        return moveableTiles;
    }

    public void checkMoveable(int r, int c) {
        char[][] board = GameState.getCurrentState();
        if (board[r][c] == 'O') {
            moveableTiles[r][c] = true;
        } else if (board[r][c] == 'F') {
            moveableTiles[r][c] = true;
        } else if (board[r][c] == 'S') {
            moveableTiles[r][c] = false;
        }
    }

    public boolean[][] getOtherMoveableTiles(GameTile tile) {
        int [] pos = tile.getPosition();
        char[][] board = GameState.getCurrentState();
        for(int r = 0; r < 5; r++)
        {
            for(int c = 0; c < 5; c++)
            {
                if(board[r][c] == 'S' || r == pos[0] && c == pos[1])
                    moveableTiles[r][c] = false;
                else if( r == pos[0]-2 && c == pos[1] ||r == pos[0]-1 && c == pos[1] ||r == pos[0] && c == pos[1] - 2||
                        r == pos[0] && c == pos[1]-1 || r == pos[0] && c == pos[1]+1 || r == pos[0] && c == pos[1] + 2||
                        r == pos[0] +1 && c == pos[1]|| r == pos[0] + 2 && c == pos[1]){
                    moveableTiles[r][c] = true;
                }
                else moveableTiles[r][c] = false;


            }
        }

         return otherMoveableTiles;
    }

    public void shoreUp(GameTile tile, Player p)
    {
        int[] tilePos = tile.getPosition();
        if((p.getPos() == tilePos || moveableTiles[tilePos[0]][tilePos[1]]) && tile.getFloodState() == true)
        {
            tile.setFlooded(false);
        }
    }

}