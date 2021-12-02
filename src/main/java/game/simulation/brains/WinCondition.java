package game.simulation.brains;
import game.simulation.player.Player;

public class WinCondition
{
    private boolean win;
    public WinCondition(GameState g)
    {
        if(g.checkWinning())
            win= true;
        else if(g.checkLosing())
            win = false;
    }

    public void displayWinOrLose()
    {
        if(win)
        {
            System.out.println("WINNER");
        }

        else if(!win)
        {
            System.out.println("LOSER");
        }
    }

    public boolean isWin() {
        return win;
    }
}


