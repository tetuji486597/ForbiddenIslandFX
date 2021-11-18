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
            if(temp[0] == pos[0])
               moveableTiles[i] = true;

            if(GameState.tiles[i].isGone())
                moveableTiles[i] = false;
            if(GameState.tiles[i+1].isGone() == false){
                int[] right = GameState.tiles[i+1].getPosition();
                if(right[0] == pos[0]  ){
                    moveableTiles[i] = false;
                    //add in another condition in if statement
                }
            }

            if((temp[0] == pos[0] && temp[1] == pos[1] + 1) || (temp[0] == pos[0] && temp[1] == pos[1]-1) ||
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
