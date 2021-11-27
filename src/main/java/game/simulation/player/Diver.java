package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Diver extends Player{
    private boolean[][] moveableTiles;

    public Diver(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
    }

    public boolean[][] getMoveableTiles(GameTile tile) {
        int [] pos = tile.getPosition();
        int i = 0;
        for(int r = 0; r < 6; r++)
        {
            for(int c = 0; c < 6; c++)
            {
                if(r == pos[0] && c == pos[1] || GameState.tiles[i].isGone() || r != pos[0] && c != pos[1]) {
                    moveableTiles[r][c] = false;
                }
                else if(r != pos[0] && c == pos[1] && r > pos[0]){
                    //fix condition
                    if(moveableTiles[r][c-1] = false)
                    moveableTiles[r][c] = true;
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


    /*
    public boolean[] getMoveableTiles(GameTile tile){
        int [] pos = tile.getPosition();
        for(int i = 0; i<GameState.tiles.length; i++){
            int[] temp = GameState.tiles[i].getPosition();

            if(GameState.tiles[i].isGone())
                moveableTiles[i] = false;

            else if(temp[0] == pos[0]) {
                //same row
                if(temp[1] < pos[1] -1 &&
                        !GameState.tiles[i+1].isGone() && !GameState.tiles[i+1].getFloodState()){
                    //on left of current tile
                   moveableTiles[i] = false;
                }
                else if(temp[1] > pos[1] +1 &&
                        !GameState.tiles[i-1].isGone() && !GameState.tiles[i-1].getFloodState()){
                    // on right of current tile
                    moveableTiles[i] = false;
                }
                else{
                    moveableTiles[i] = true;
                }
            }

            else if(temp[1] == pos[1]) {
                //same column

                if(temp[0] < pos[0] -1 ) {
                      //  GameTile below = GameState.tiles[];
                    if (!GameState.tiles[i + 1].isGone() && !GameState.tiles[i + 1].getFloodState()) {
                        //on bottom of current tile
                        //find next tile correctly
                        moveableTiles[i] = false;
                    }
                }
                else if(temp[0] > pos[0] +1 &&
                        !GameState.tiles[i+1].isGone() && !GameState.tiles[i+1].getFloodState()){
                    // on top of current tile
                    moveableTiles[i] = false;
                }
                else{
                    moveableTiles[i] = true;
                }
            }


        }


        return moveableTiles;
    }


     */
}
