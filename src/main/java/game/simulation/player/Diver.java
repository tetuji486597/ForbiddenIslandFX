package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

public class Diver {
    private boolean[] moveableTiles;

    public Diver(){ moveableTiles = new boolean[GameState.tiles.length]; }

    public boolean[] getMoveableTiles(GameTile tile){
        int [] pos = tile.getPosition();
        for(int i = 0; i<GameState.tiles.length; i++){
            int[] temp = GameState.tiles[i].getPosition();

            if(GameState.tiles[i].isGone())
                moveableTiles[i] = false;

            else if(temp[0] == pos[0]) {
                //same row
                if(temp[1] < pos[1] -1 &&
                        !GameState.tiles[i+1].isGone()){
                    //on left of current tile
                   moveableTiles[i] = false;
                }
                else if(temp[1] > pos[1] +1 &&
                        !GameState.tiles[i+1].isGone()){
                    // on right of current tile
                    moveableTiles[i] = false;
                }
                else{
                    moveableTiles[i] = true;
                }
            }

            else if(temp[1] == pos[1]) {
                //same column
                if(temp[0] < pos[0] -1 &&
                        !GameState.tiles[i+1].isGone() ){
                    //on bottom of current tile
                    moveableTiles[i] = false;
                }
                else if(temp[0] > pos[0] +1 &&
                        !GameState.tiles[i+1].isGone() ){
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
}
