package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;
import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pilot extends Player {
    private boolean[][] moveableTiles;
    private int[] moveTo;
    private boolean[][] shoreableTiles;
    private boolean specialMove;


    public Pilot(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role, startingDeck);
        moveableTiles = new boolean[6][6];
        shoreableTiles = new boolean[6][6];
        specialMove = false;
    }

    @Override
    public boolean[][] getPilotTiles(GameTile gameTile){
        char[][] board = GameState.getCurrentState();
            int[] pos = gameTile.getPosition();
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 6; c++) {
                    if(board[r][c] == 'S' || r == pos[0] && c == pos[1])
                        moveableTiles[r][c] = false;
                    else moveableTiles[r][c] = true;

                }
            }
            moveableTiles[getPos()[0]][getPos()[1]] = false;
            return moveableTiles;


    }

    @Override
    public boolean[][] getMoveableTiles(GameTile gameTile) {
        moveableTiles = new boolean[6][6];
        int pos[] = getPos();
        int r = pos[0], c = pos[1];
        try {checkMoveable(r - 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {        }
        try {checkMoveable(r + 1, c);
        } catch (ArrayIndexOutOfBoundsException ignored) {        }
        try {checkMoveable(r, c - 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {        }
        try {checkMoveable(r, c + 1);
        } catch (ArrayIndexOutOfBoundsException ignored) {        }

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

    public void resetSpecialMove() {
        specialMove = true;
    }

    public void movePawn(GameTile tile, int[] coords, Player p) {
        moveTo = coords;
        if (moveableTiles[moveTo[0]][moveTo[1]]) {
            setMoveNumber(moveNumber + 1);
            p.updatePosition(moveTo);
        }
    }

    public void shoreUp(GameTile tile, Player p) {
        int[] tilePos = tile.getPosition();
        if ((p.getPos() == tilePos || moveableTiles[tilePos[0]][tilePos[1]]) && tile.getFloodState() == true) {
            setMoveNumber(moveNumber + 1);
            tile.setFlooded(false);
        }
    }

}
