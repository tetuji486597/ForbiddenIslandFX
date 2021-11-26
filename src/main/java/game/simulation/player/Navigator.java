package game.simulation.player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Navigator extends Player{
    public Navigator(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
    }
}
