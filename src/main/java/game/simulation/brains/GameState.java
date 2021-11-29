package game.simulation.brains;
//
import game.graphics.GameBoardController;
import game.simulation.board.*;
import game.simulation.card.Card;
import game.simulation.player.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

//
public class GameState {
    public static int                       waterLevel;
    private TreasurePiece[]                 treasuresCollected;
    public static GameTile[]                tiles;
    public static HashMap<String,GameTile>  tilesMap;
    public static HashMap<String,GameTile>  posMap;
    public static int                       numPlayers;
    public String[]                         allRoles;
    public static ArrayList<Player>         allPlayers;
    private int                             playerTurn = 0;
    public static Player                    currentPlayer;
    private WaterLevelMeter                 meter;
    private ArrayList<Card>                 currentDeck;
    public static Stack<String>             cardDeck;
    public static Stack<String>             discardPile;
    public static Stack<String>             floodDiscard;
    public static Stack<String>             floodDeck;
    private ArrayList<GameTile>             moveableSpaces;
    public static String[]                  allTiles;
    public static int[][]                   pos;
    Iterator<Player>                        playerIterator;

    public GameState(int difficulty, int numPlayers) throws IOException {
        this.numPlayers = numPlayers;

        //Tile Shuffle
        allTiles = new String[]{"MistyMarsh", "Observatory", "IronGate", "TidalPalace", "CrimsonForest",
                "BreakersBridge", "CaveOfEmbers", "TwilightHollow", "DunesOfDeception",
                "TempleOfTheMoon", "LostLagoon", "CaveOfShadows", "PhantomRock", "SilverGate",
                "Watchtower", "CopperGate", "CliffsOfAbandon", "WhisperingGarden", "TempleOfTheSun",
                "CoralPalace", "GoldGate", "FoolsLanding", "HowlingGarden", "BronzeGate"};
        pos = new int[][]{
                {0, 2}, {0, 3}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {5, 2}, {5, 3}
        };
        List<String> tileShuffle = Arrays.asList(allTiles);
        Collections.shuffle(tileShuffle);
        allTiles = tileShuffle.toArray(new String[tileShuffle.size()]);
        tiles = new GameTile[24];
        tilesMap = new HashMap<>();
        posMap = new HashMap<>();
        floodDeck = new Stack<>();
        floodDiscard = new Stack<>();
        for(int i = 0; i < 24; i++){
            floodDeck.push(allTiles[i]);
            GameTile gameTile = new GameTile(allTiles[i], Initialize.tiles.get(allTiles[i]), pos[i]);
            tiles[i] = gameTile;
            tilesMap.put(allTiles[i], gameTile);
            posMap.put(Arrays.toString(pos[i]),tiles[i]);
        }
        Collections.shuffle(floodDeck);


        waterLevel = difficulty;

        allRoles = new String[]{"Navigator", "Messenger", "Engineer", "Pilot", "Explorer", "Diver"};
//        allRoles = new String[]{"Explorer", "Navigator", "Messenger", "Engineer"};
        List<String> roleShuffle = Arrays.asList(allRoles);
        Collections.shuffle(roleShuffle);
        allRoles = roleShuffle.toArray(new String[roleShuffle.size()]);

        cardDeck = new Stack<>();
        for(int i = 0; i < 5; i++) cardDeck.push("CrystalOfFire");
        for(int i = 0; i < 5; i++) cardDeck.push("StatueOfWind");
        for(int i = 0; i < 5; i++) cardDeck.push("OceansChalice");
        for(int i = 0; i < 5; i++) cardDeck.push("EarthStone");
        for(int i = 0; i < 3; i++) cardDeck.push("HelicopterLift");
        for(int i = 0; i < 2; i++) cardDeck.push("Sandbag");
        Collections.shuffle(cardDeck);
        allPlayers = new ArrayList<Player>();
        System.out.println(Arrays.toString(allRoles));
        for(int i = 0; i < numPlayers; i++) {
            ArrayList<String> startingDeck = new ArrayList<>();
            startingDeck.add(cardDeck.pop());
            startingDeck.add(cardDeck.pop());
            currentPlayer = null;
            if(allRoles[i].equals("Engineer")){
                currentPlayer = new Engineer(allRoles[i],startingDeck);
            }else if(allRoles[i].equals("Diver")){
                currentPlayer = new Diver(allRoles[i],startingDeck);
            }else if(allRoles[i].equals("Explorer")){
                currentPlayer = new Explorer(allRoles[i],startingDeck);
            }else if(allRoles[i].equals("Messenger")){
                currentPlayer = new Messenger(allRoles[i],startingDeck);
            }else if(allRoles[i].equals("Navigator")){
                currentPlayer = new Navigator(allRoles[i],startingDeck);
            }else if(allRoles[i].equals("Pilot")){
                currentPlayer = new Pilot(allRoles[i],startingDeck);
            }
            assert currentPlayer != null;
            currentPlayer.setIndex(i);
            allPlayers.add(currentPlayer);
        }
        for(int i = 0; i < 3; i++) cardDeck.push("WatersRise");
        Collections.shuffle(cardDeck);
        playerIterator = allPlayers.iterator();
        for(int i = 0; i < 6; i++){
            floodDiscard.push(floodDeck.pop());
            for(int j = 0; j < 24; j++){
                if(tiles[j].getName().equals(floodDiscard.peek()))
                    tiles[j].flood();
            }
        }
        currentPlayer = allPlayers.get(0);
        currentPlayer.setActivePawn("active");

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
//        if(!playerIterator.hasNext()) playerIterator = allPlayers.iterator();
        return playerIterator.next();
    }

    public static void drawFlood(GameTile gameTile) throws FileNotFoundException {
        GameBoardController.tilesMap.get(gameTile.getPosition()).setImage(gameTile.getTile());
//        System.out.println(gameTile.getName());
    }

    public boolean checkWinning() {
        return true;
    }

    public boolean checkLosing() {
        return true;
    }

    public static char[][] getCurrentState(){
        char[][] board = new char[6][6];
        int i = 0;
        for(int r = 0; r < 6; r++){
            for(int c = 0; c < 6; c++){
                if(r == 0 && c == 0 || r == 0 && c == 1 || r == 0 && c == 4 || r == 0 && c == 5) board[r][c] = 'X';
                else if(r == 1 && c == 0 || r == 1 && c == 5) board[r][c] = 'X';
                else if(r == 4 && c == 0 || r == 4 && c == 5) board[r][c] = 'X';
                else if(r == 5 && c == 0 || r == 5 && c == 1 || r == 5 && c == 4 || r == 5 && c == 5) board[r][c] = 'X';
                else if(tiles[i].isGone()){
                    board[r][c] = 'S';
                    i++;
                }
                else if(tiles[i].getFloodState()){
                    board[r][c] = 'F';
                    i++;
                }
                else{
                    board[r][c] = 'O';
                    i++;
                }

            }
        }
        return board;
    }



}
