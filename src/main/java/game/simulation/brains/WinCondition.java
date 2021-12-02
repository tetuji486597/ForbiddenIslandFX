package game.simulation.brains;
import game.simulation.player.Player;

public class WinCondition
{
    private boolean win;
    public WinCondition(GameState g)
    {
        if(g.checkWinning() == true)
            win = true;
        else if(g.checkWinning() == false)
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


