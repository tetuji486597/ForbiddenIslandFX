package game.simulation.brains;
//
import game.graphics.GameBoardController;
import game.simulation.board.*;
import game.simulation.card.*;
import game.simulation.card.Card;
import game.simulation.player.*;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
//
public class GameState {
    public static int waterLevel;
    private TreasurePiece[] treasuresCollected;
    public static GameTile[] tiles;
    private HashMap<int[],GameTile> posMap;
    public static int numPlayers;
    public String[] allRoles;
    public static ArrayList<Player> allPlayers;
    private int playerTurn = 0;
    private Player currentPlayer;
    private WaterLevelMeter meter;
    private ArrayList<Card> currentDeck;
    private static Stack<String> cardDeck;
    private static Stack<String> discardPile;
    private ArrayList<GameTile> moveableSpaces;
    public static String[] allTiles;
    Iterator<Player> playerIterator;

    public GameState(int difficulty, int numPlayers) throws IOException {
        this.numPlayers = numPlayers;

        //Tile Shuffle
        allTiles = new String[]{"MistyMarsh", "Observatory", "IronGate", "TidalPalace", "CrimsonForest",
                "BreakersBridge", "CaveOfEmbers", "TwilightHollow", "DunesOfDeception",
                "TempleOfTheMoon", "LostLagoon", "CaveOfShadows", "PhantomRock", "SilverGate",
                "Watchtower", "CopperGate", "CliffsOfAbandon", "WhisperingGarden", "TempleOfTheSun",
                "CoralPalace", "GoldGate", "FoolsLanding", "HowlingGarden", "BronzeGate"};
        int[][] pos = {
                {0,2},{0,3},{1,1},{1,2},{1,3},{1,4},{2,0},{2,1},{2,2},{2,3},{2,4},{2,5},{3,0},{3,1},{3,2},{3,3},{3,4},{3,5},{4,1},{4,2},{4,3},{4,4},{5,2},{5,3}
        };
        List<String> tileShuffle = Arrays.asList(allTiles);
        Collections.shuffle(tileShuffle);
        allTiles = tileShuffle.toArray(new String[tileShuffle.size()]);
        tiles = new GameTile[24];
        posMap = new HashMap<>();
        for(int i = 0; i < 24; i++){
            tiles[i] = new GameTile(allTiles[i], Initialize.tiles.get(allTiles[i]));
            tiles[i].setPosition(pos[i]);
            posMap.put(pos[i],tiles[i]);
        }



        waterLevel = difficulty;

        allRoles = new String[]{"Navigator", "Messenger", "Engineer", "Pilot", "Explorer", "Diver"};
        List<String> roleShuffle = Arrays.asList(allRoles);
        Collections.shuffle(roleShuffle);
        allRoles = roleShuffle.toArray(new String[roleShuffle.size()]);

        cardDeck = new Stack<>();
        for(int i = 0; i < 4; i++) cardDeck.push("CrystalOfFire");
        for(int i = 0; i < 4; i++) cardDeck.push("StatueOfWind");
        for(int i = 0; i < 4; i++) cardDeck.push("OceansChalice");
        for(int i = 0; i < 4; i++) cardDeck.push("EarthStone");
        for(int i = 0; i < 3; i++) cardDeck.push("HelicopterLift");
        for(int i = 0; i < 2; i++) cardDeck.push("Sandbag");
        Collections.shuffle(cardDeck);
        allPlayers = new ArrayList<Player>();
        for(int i = 0; i < numPlayers; i++) {
            ArrayList<String> startingDeck = new ArrayList<>();
            startingDeck.add(cardDeck.pop());
            startingDeck.add(cardDeck.pop());
            Player p = new Player(allRoles[i], startingDeck);
            allPlayers.add(p);
        }
        for(int i = 0; i < 3; i++) cardDeck.push("WatersRise");
        Collections.shuffle(cardDeck);
        playerIterator = allPlayers.iterator();
    }

    public void shuffle(Stack<Card> pile) {
        Collections.shuffle(pile);
    }

    public void drawCard(Graphics g) {
    }

    public void setWater(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void raiseWater() {
        ++waterLevel;
    }

    public Player nextTurn() {
        if(!playerIterator.hasNext()) playerIterator = allPlayers.iterator();
        return playerIterator.next();
    }

    public void drawFlood(GameTile tile) {

    }

    public boolean checkWinning() {
        return true;
    }

    public boolean checkLosing() {
        return true;
    }

    public ArrayList<GameTile> findMovable() {
        String role = currentPlayer.getRole();
        int[] pos = currentPlayer.getPos();
        int x = pos[0];
        int y = pos[1];
        Set<int[]> moveable = new HashSet<>();

        moveable.add(new int[]{x+1,y});
        moveable.add(new int[]{x-1,y});
        moveable.add(new int[]{x, y+1});
        moveable.add(new int[]{x, y-1});
//        switch (role) {
//            case "Explorer":
//                moveable.add(new int[]{x+1,y+1});
//                moveable.add(new int[]{x-1,y-1});
//                moveable.add(new int[]{x-1, y+1});
//                moveable.add(new int[]{x+1, y-1});
//                break;
//            case "Pilot":
//                for(int i = -6; i < 6; i++) {
//                    for(int j = -6; j < 6; j++) {
//                        moveable.add(new int[]{i, j});
//                    }
//                }
//                break;
//            case "Navigator":
//                Player temp = currentPlayer;
//                currentPlayer =
//                Player p =
//      }
        ArrayList<GameTile> asdf = new ArrayList<>();
        for(int[] i: moveable) {
            if(posMap.get(i) != null) asdf.add(posMap.get(i));
        }
        return asdf;
    }

}
