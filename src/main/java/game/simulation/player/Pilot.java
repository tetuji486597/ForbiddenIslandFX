package game.simulation.player;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pilot extends Player{
    private boolean[][] moveableTiles;
    private int[] moveTo;
    private boolean[][] shoreableTiles;
    private boolean specialMove;



    public Pilot(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
        moveableTiles = new boolean[6][6];
        shoreableTiles = new boolean[6][6];
        specialMove = false;
    }

    @Override
    public boolean[][] getMoveableTiles(GameTile gameTile){
        char[][] board = GameState.getCurrentState();
        if(specialMove){
            int[] pos = gameTile.getPosition();
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 6; c++) {
                    if(board[r][c] == 'S' || r == pos[0] && c == pos[1])
                        moveableTiles[r][c] = false;
                    else if(r == pos[0]-1 && c == pos[1] || r == pos[0] && c == pos[1]-1 || r == pos[0] && c == pos[1]+1
                            || r == pos[0] +1 && c == pos[1]){
                        moveableTiles[r][c] = true;
                    }
                    else moveableTiles[r][c] = false;

                }
            }
            return moveableTiles;

        }
        else {
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 6; c++) {
                    if (board[r][c] == 'S')
                        moveableTiles[r][c] = false;

                    else moveableTiles[r][c] = true;
                }
            }
            int pos[] = gameTile.getPosition();
            moveableTiles[pos[0]][pos[1]] = false;
            return moveableTiles;
        }
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

    public void resetSpecialMove(){
        specialMove = true;
    }

    public void movePawn(GameTile tile, int[] coords, Player p)
    {
        moveTo = coords;
        if(moveableTiles[moveTo[0]][moveTo[1]] )
        {
            setMoveNumber(moveNumber+1);
            p.updatePosition(moveTo);
        }
    }

    public void shoreUp(GameTile tile, Player p)
    {
        int[] tilePos = tile.getPosition();
        if((p.getPos() == tilePos || moveableTiles[tilePos[0]][tilePos[1]]) && tile.getFloodState() == true)
        {
            setMoveNumber(moveNumber+1);
            tile.setFlooded(false);
        }
    }

}
