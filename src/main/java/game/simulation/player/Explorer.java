package game.simulation.player;

import game.simulation.board.GameTile;
import java.util.ArrayList;

public class Explorer
{
    private boolean[][] moveable;
    private int[] moveTo;
    private Player player;

    public Explorer(Player p, int[] c)
    {
        player = p;
        moveable = new boolean[3][3];
    }

    public boolean[][] moveableTiles(GameTile tile)
    {
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                if(r == 1 && c == 1 || tile.isGone())
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

    public void movePawn(GameTile tile, int[] coords)
    {
        moveTo = coords;

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
