package game.simulation.player;

import java.util.ArrayList;
import java.util.TreeMap;

public class Engineer {
    private boolean[][] moveableTiles;

    public Engineer(){ moveableTiles = new boolean[6][6]; }

    public boolean[][] getMoveableTiles(int[] pos){
        for(int r = 0; r<6; r++){
            for(int c = 0; c<6; c++){

            //    moveableTiles[r][c] == false;
            }
        }
        moveableTiles[pos[0]][pos[1]] = false;

        return moveableTiles;
    }
}
