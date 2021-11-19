package game.simulation.player;

import game.simulation.board.GameTile;

public class Explorer
{
    private boolean[][] moveable;
    private int[] moveTo;

    public Explorer()
    {
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

    public void movePawn(GameTile tile, int[] coords, Player p)
    {
        moveTo = coords;
        if(moveable[moveTo[0]][moveTo[1]] && tile.isGone() == false)
        {
            p.updatePosition(moveTo);
        }
    }

    public void shoreUp(GameTile tile, Player p)
    {
        int[] tilePos = tile.getPosition();
        if((p.getPos() == tilePos || moveable[tilePos[0]][tilePos[1]]) && tile.getFloodState() == true)
        {
            tile.setFlooded(false);
        }
    }
}
