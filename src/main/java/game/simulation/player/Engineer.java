package game.simulation.player;

import java.util.ArrayList;
import java.util.TreeMap;

public class Engineer {
    private boolean[][] moveableTiles;

    public Engineer(){ moveableTiles = new boolean[6][6]; }

    public boolean[][] getMoveableTiles(int[] pos){
        for(int r = 0; r<pos[0]; r++){
            for(int c = 0; c<pos[1]; c++){
            //    moveableTiles[r][c] == false;
            }
        }
        return moveableTiles;
    }
}
