package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Diver extends Player {
    private boolean[][] moveableTiles;
    private boolean[][] checkedTiles;

    public Diver(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role, startingDeck);
        moveableTiles = new boolean[6][6];
    }

    public boolean[][] getMoveableTiles(GameTile tile) {
        int[] pos = tile.getPosition();
        checkedTiles = new boolean[6][6];
        setSurroundings(pos[0], pos[1]);
        moveableTiles[pos[0]][pos[1]] = false;
        return moveableTiles;
    }

    public void setSurroundings(int r, int c) {
        try {
            if (!checkMoveable(r - 1, c)) {
                setSurroundings(r - 1, c);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }

        try {
            if (!checkMoveable(r + 1, c)) {
                setSurroundings(r + 1, c);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }

        try {
            if (!checkMoveable(r, c - 1)) {
                setSurroundings(r, c - 1);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }

        try {
            if (!checkMoveable(r, c + 1)) {
                setSurroundings(r, c + 1);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }
    }

    public boolean checkMoveable(int r, int c) {
        char[][] board = GameState.getCurrentState();
        if(checkedTiles[r][c]) return true;
        checkedTiles[r][c] = true;
        if (board[r][c] == 'O') {
            moveableTiles[r][c] = true;
            return true;
        } else if (board[r][c] == 'F') {
            moveableTiles[r][c] = true;
            return false;
        } else if (board[r][c] == 'S') {
            moveableTiles[r][c] = false;
            return false;
        }
        return true;
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
