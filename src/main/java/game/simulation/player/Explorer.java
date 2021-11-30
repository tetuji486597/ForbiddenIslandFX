package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Explorer extends Player
{
    private boolean[][] moveableTiles;
    private boolean[][] shoreableTiles;
    private int[] moveTo;

    public Explorer(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
        shoreableTiles = new boolean[6][6];

    }

    @Override
    public boolean[][] getMoveableTiles(GameTile tile)
    {   char[][] board = GameState.getCurrentState();
        int[] pos = tile.getPosition();
        moveableTiles = new boolean[6][6];
        int r = pos[0], c = pos[1];

        try {
            checkMoveable(r - 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkMoveable(r + 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkMoveable(r, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkMoveable(r, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkMoveable(r - 1, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkMoveable(r - 1, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkMoveable(r + 1, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkMoveable(r + 1, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
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

    public void movePawn(GameTile tile, int[] coords, Player p)
    {
        moveTo = coords;
        if(moveableTiles[moveTo[0]][moveTo[1]] && tile.isGone() == false)
        {
            p.updatePosition(moveTo);
        }
    }

    public void shoreUp(GameTile tile, Player p)
    {
        int[] tilePos = tile.getPosition();
        if((p.getPos() == tilePos || moveableTiles[tilePos[0]][tilePos[1]]) && tile.getFloodState() == true)
        {
            tile.setFlooded(false);
        }
    }

    @Override
    public boolean[][] getShoreableTiles(GameTile gameTile){
        shoreableTiles = new boolean[6][6];
        System.out.println("4");
        int[] pos = gameTile.getPosition();
        int r = pos[0], c = pos[1];

        try {
            checkShoreableSurroundings(r - 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkShoreableSurroundings(r + 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkShoreableSurroundings(r, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkShoreableSurroundings(r, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkShoreableSurroundings(r - 1, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkShoreableSurroundings(r - 1, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkShoreableSurroundings(r + 1, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            checkShoreableSurroundings(r + 1, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        return shoreableTiles;
    }

    public void checkShoreableSurroundings(int r, int c){
        char[][] board = GameState.getCurrentState();
        if(board[r][c] == 'F') shoreableTiles[r][c] = true;
    }
}
