package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Messenger extends Player{
    private boolean[][] moveableTiles;
    private boolean[][] shoreableTiles;


    public Messenger(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
        shoreableTiles = new boolean[6][6];

    }

    @Override
    public boolean[][] getMoveableTiles(GameTile tile){
        char[][] board = GameState.getCurrentState();
        int[] pos = tile.getPosition();
        int r = pos[0], c = pos[1];
        moveableTiles = new boolean[6][6];

        try {
            checkMoveable(r - 1, c);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }

        try {
            checkMoveable(r + 1, c);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }

        try {
            checkMoveable(r, c - 1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }

        try {
            checkMoveable(r, c + 1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("null");
        }

        return moveableTiles;
    }

    public void checkMoveable(int r, int c) {
        char[][] board = GameState.getCurrentState();
        if (board[r][c] == 'O') {
            moveableTiles[r][c] = true;
        } else if (board[r][c] == 'F') {
            moveableTiles[r][c] = true;
        } else if (board[r][c] == 'S') {
            moveableTiles[r][c] = false;
        }
    }

    public void shoreUp(GameTile tile, Player p)
    {
        int[] tilePos = tile.getPosition();
        if((p.getPosition() == tilePos || moveableTiles[tilePos[0]][tilePos[1]]) && tile.getFloodState() == true)
        {
            tile.setFlooded(false);
            setMoveNumber(moveNumber+1);
        }
    }

}
