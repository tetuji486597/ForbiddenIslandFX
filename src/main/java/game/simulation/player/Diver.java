package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Diver extends Player {
    private boolean[][] moveableTiles;
    private boolean[][] checkedTiles;
    private boolean[][] shoreableTiles;


    public Diver(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role, startingDeck);
        moveableTiles = new boolean[6][6];
        shoreableTiles = new boolean[6][6];

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
            return true;
        }
        return true;
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
