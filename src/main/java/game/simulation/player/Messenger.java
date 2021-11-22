package game.simulation.player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Messenger extends Player{
    public Messenger(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
    }
}
