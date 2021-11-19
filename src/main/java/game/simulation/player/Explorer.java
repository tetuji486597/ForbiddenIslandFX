package game.simulation.player;

import game.simulation.board.GameTile;
import java.util.ArrayList;

public class Explorer
{
    private boolean[][] moveable;
    private int[] moveTo, tilePos, coords;
    private Player player;
    private GameTile tile;

    public Explorer(Player p, GameTile t, int[] c)
    {
        player = p;
        tile = t;
        coords = c;
        moveable = new boolean[3][3];
    }

    public boolean[][] moveableTiles()
    {
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                if(r == 1 && c == 1)
                {
                    moveable[r][c] = false;
                }

                else
                {
                    moveable[r][c] = true;
                }
            }
        }
        return moveable;
    }

    public void movePawn() {
        moveTo = new int[2];

        moveTo[0] = coords[0]; // X Coord
        moveTo[1] = coords[1]; // Y Coord

        if (moveable[moveTo[0]][moveTo[1]] && tile.isGone() == false)
        {
            player.updatePosition(moveTo);
        }
    }

    public void shoreUp()
    {
        /*
        tilePos = tile.getPosition();

        if((player.getPos() == tilePos || moveTo[0] == tilePos[0] || moveTo[1] == tilePos[1] || moveTo[0] == tilePos[0] && moveTo[1] == tilePos[1]) && tile.getFloodState() == true)
        {
            tile.setFlooded(false);
        }
         */
    }
}
