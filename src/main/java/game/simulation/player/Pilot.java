package game.simulation.player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pilot extends Player{
    public Pilot(String role, ArrayList<String> startingDeck) throws FileNotFoundException {
        super(role,startingDeck);
    }
}
