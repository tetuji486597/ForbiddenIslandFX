package game.simulation.brains;
import game.simulation.player.Player;

public class WinCondition
{
    private boolean winOrLose;
    public WinCondition(GameState g)
    {
        if(g.checkWinning())
            winOrLose = true;
        else if(g.checkLosing())
            winOrLose = false;
    }

    public void displayWinOrLose()
    {
        if(winOrLose)
        {
            System.out.println("WINNER");
        }

        else if(!winOrLose)
        {
            System.out.println("LOSER");
        }
    }
}


