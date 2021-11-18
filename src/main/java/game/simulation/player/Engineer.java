package game.simulation.player;

import java.util.ArrayList;
import java.util.TreeMap;

public class Engineer {
    private boolean[][] moveableTiles;

    public Engineer(){ moveableTiles = new boolean[6][6]; }

    public boolean[][] getMoveableTiles(int[] pos){
//        for(int r = 0; r<6; r++){
//            for(int c = 0; c<6; c++){
//                if((r == pos[0]+1 && c == pos[1])|| r == pos[0] - 1 && c == pos[1]||
//                        r == pos[0] && c == pos[1] -1 || r == pos[0] && c == pos[1] +1){
//                     int [] temp = new int [2];
//                     temp[0] = r;
//                     temp[1] = c;
//                     if(getTile(temp).getIsGone() == false)
//                         moveableTiles[r][c] = true;
//
//                     else
//                         moveableTiles[r][c] = false;
//
//                }
//                else
//                    moveableTiles[r][c] = false;
//
//            }
//        }

        return moveableTiles;
    }
}
