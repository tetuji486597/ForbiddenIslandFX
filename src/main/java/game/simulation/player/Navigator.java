package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Navigator extends Player{
    private boolean[][] moveableTiles;
    private boolean[][] otherMoveableTiles;

    public Navigator(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[3][3];
        otherMoveableTiles = new boolean [5][5];
    }

    @Override
    public boolean[][] getMoveableTiles(GameTile tile){
        int [] pos = tile.getPosition();
        int i = 0;
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {

                if(r == 1 && c == 1 || GameState.tiles[i].isGone() || r == 0 && c != 1 || r == 2 && c!= 1)
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


    public boolean[][] getOtherMoveableTiles(GameTile tile) {
        int [] pos = tile.getPosition();
        int i = 0;
        for(int r = 0; r < 5; r++)
        {
            for(int c = 0; c < 5; c++)
            {

                if(r == 2 && c == 2 || GameState.tiles[i].isGone() || r == 0 && c != 2 || r == 1 && c!= 2 ||
                        r == 3 && c != 2|| r == 4 && c != 2)
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

         return otherMoveableTiles;
    }
}