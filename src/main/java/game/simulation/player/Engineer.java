package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.util.ArrayList;
import java.util.TreeMap;

public class Engineer {
    private boolean[][] moveableTiles;

    public Engineer(){//
        // moveableTiles = new boolean[GameState.tiles.length];
        }

    public boolean[][] getMoveableTiles(GameTile tile){
       int [] pos = tile.getPosition();
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


        return moveableTiles;
    }
}
