package game.simulation.brains;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Initialize {
    public static Map<String, Image> treasures;
    public static Map<String, Image> floodcards;
    public static Map<String, Image> treasurecards;
    public static Map<String, Image> tiles;
    public static ArrayList tilesList = new ArrayList(Arrays.asList("Breakers Bridge", "Bronze Gate", "Cave of Embers", "Cave of Shadows", "Cliffs of Abandon", "Copper Gate", "Coral Palace", "Crimson Forest", "Dunes of Deception", "Fools Landing", "Gold Gate", "Howling Garden", "Iron Gate", "Lost Lagoon", "Misty Marsh", "Observatory", "Phantom Rock", "Silver Gate", "Temple of the Moon", "Temple of the Sun", "Tidal Palace", "Twilight Hollow", "Watchtower", "Whispering Garden"));
    public static Map.Entry waterrise;

    public static void init() throws IOException {

        waterrise = Map.entry("WaterRise", new Image(new FileInputStream("/Images/TreasureCards/Card_Waters_Rise.png")));

        treasures = Map.ofEntries(
                Map.entry("Blue", new Image(new FileInputStream("/Images/Treasures/EAU.png"))),
                Map.entry("Red", new Image(new FileInputStream("/Images/Treasures/FEU.png"))),
                Map.entry("Purple", new Image(new FileInputStream("/Images/Treasures/TERRE.png"))),
                Map.entry("Yellow", new Image(new FileInputStream("/Images/Treasures/AIR.png")))
        );

        floodcards = Map.ofEntries(
                Map.entry("Beakers Bridge", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Breakers Bridge@2x.png"))),
                Map.entry("Bronze Gate", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Bronze Gate@2x.png"))),
                Map.entry("Cave of Embers", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Cave of Embers@2x.png"))),
                Map.entry("Cave of Shadows", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Cave of Shadows@2x.png"))),
                Map.entry("Cliffs of Abandon", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Cliffs of Abandon@2x.png"))),
                Map.entry("Copper Gate", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Copper Gate@2x.png"))),
                Map.entry("Coral Palace", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Coral Palace@2x.png"))),
                Map.entry("Crimson Forest", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Crimson Forest@2x.png"))),
                Map.entry("Dunes of Deception", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Dunes of Deception@2x.png"))),
                Map.entry("Fools Landing", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Fools_ Landing@2x.png"))),
                Map.entry("Gold Gate", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Gold Gate@2x.png"))),
                Map.entry("Howling Garden", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Howling Garden@2x.png"))),
                Map.entry("Iron Gate", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Iron Gate@2x.png"))),
                Map.entry("Lost Lagoon", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Lost Lagoon@2x.png"))),
                Map.entry("Misty Marsh", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Misty Marsh@2x.png"))),
                Map.entry("Observatory", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Observatory@2x.png"))),
                Map.entry("Phantom Rock", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Phantom Rock@2x.png"))),
                Map.entry("Silver Gate", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Silver Gate@2x.png"))),
                Map.entry("Temple of the Moon", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Temple of the Moon@2x.png"))),
                Map.entry("Temple of the Sun", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Temple of the Sun@2x.png"))),
                Map.entry("Tidal Palace", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Tidal Palace@2x.png"))),
                Map.entry("Twilight Hollow", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Twilight Hollow@2x.png"))),
                Map.entry("Watchtower", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Watchtower@2x.png"))),
                Map.entry("Whispering Garden", new Image(new FileInputStream("/Images/FloodCards/Flood_Card_Whispering Garden@2x.png")))
        );

        treasurecards = Map.ofEntries(
                Map.entry("Blue", new Image(new FileInputStream("/Images/TreasureCards/Card_Oceans_Chalice.png"))),
                Map.entry("Red", new Image(new FileInputStream("/Images/TreasureCards/Card_Crystal_of_Fire.png"))),
                Map.entry("Purple", new Image(new FileInputStream("/Images/TreasureCards/Card_Earth_Stone.png"))),
                Map.entry("Yellow", new Image(new FileInputStream("/Images/TreasureCards/Card_Statue_of_the_Wind.png")))
        );

        tiles = Map.ofEntries(
                Map.entry("BreakersBridge", new Image(new FileInputStream("/Images/Tiles/Breakers Bridge@2x.png"))),
                Map.entry("Breakers Bridge Flooded", new Image(new FileInputStream("/Images/Tiles/Breakers Bridge_flood@2x.png"))),
                Map.entry("BronzeGate", new Image(new FileInputStream("/Images/Tiles/Bronze Gate@2x.png"))),
                Map.entry("Bronze Gate Flooded", new Image(new FileInputStream("/Images/Tiles/Bronze Gate_flood@2x.png"))),
                Map.entry("CaveOfEmbers", new Image(new FileInputStream("/Images/Tiles/Cave of Embers@2x.png"))),
                Map.entry("Cave of Embers Flooded", new Image(new FileInputStream("/Images/Tiles/Cave of Embers_flood@2x.png"))),
                Map.entry("CaveOfShadows", new Image(new FileInputStream("/Images/Tiles/Cave of Shadows@2x.png"))),
                Map.entry("Cave of Shadows Flooded", new Image(new FileInputStream("/Images/Tiles/Cave of Shadows_flood@2x.png"))),
                Map.entry("CliffsOfAbandon", new Image(new FileInputStream("/Images/Tiles/Cliffs of Abandon@2x.png"))),
                Map.entry("Cliffs of Abandon Flooded", new Image(new FileInputStream("/Images/Tiles/Cliffs of Abandon_flood@2x.png"))),
                Map.entry("CopperGate", new Image(new FileInputStream("/Images/Tiles/Copper Gate@2x.png"))),
                Map.entry("Copper Gate Flooded", new Image(new FileInputStream("/Images/Tiles/Copper Gate_flood@2x.png"))),
                Map.entry("CoralPalace", new Image(new FileInputStream("/Images/Tiles/Coral Palace@2x.png"))),
                Map.entry("Coral Palace Flooded", new Image(new FileInputStream("/Images/Tiles/Coral Palace_flood@2x.png"))),
                Map.entry("CrimsonForest", new Image(new FileInputStream("/Images/Tiles/Crimson Forest@2x.png"))),
                Map.entry("Crimson Forest Flooded", new Image(new FileInputStream("/Images/Tiles/Crimson Forest_flood@2x.png"))),
                Map.entry("DunesOfDeception", new Image(new FileInputStream("/Images/Tiles/Dunes of Deception@2x.png"))),
                Map.entry("Dunes of Deception Flooded", new Image(new FileInputStream("/Images/Tiles/Dunes of Deception_flood@2x.png"))),
                Map.entry("FoolsLanding", new Image(new FileInputStream("/Images/Tiles/Fools_ Landing@2x.png"))),
                Map.entry("Fools Landing Flooded", new Image(new FileInputStream("/Images/Tiles/Fools_ Landing_flood@2x.png"))),
                Map.entry("GoldGate", new Image(new FileInputStream("/Images/Tiles/Gold Gate@2x.png"))),
                Map.entry("Gold Gate Flooded", new Image(new FileInputStream("/Images/Tiles/Gold Gate_flood@2x.png"))),
                Map.entry("HowlingGarden", new Image(new FileInputStream("/Images/Tiles/Howling Garden@2x.png"))),
                Map.entry("Howling Garden Flooded", new Image(new FileInputStream("/Images/Tiles/Howling Garden_flood@2x.png"))),
                Map.entry("IronGate", new Image(new FileInputStream("/Images/Tiles/Iron Gate@2x.png"))),
                Map.entry("Iron Gate Flooded", new Image(new FileInputStream("/Images/Tiles/Iron Gate_flood@2x.png"))),
                Map.entry("LostLagoon", new Image(new FileInputStream("/Images/Tiles/Lost Lagoon@2x.png"))),
                Map.entry("Lost Lagoon Flooded", new Image(new FileInputStream("/Images/Tiles/Lost Lagoon_flood@2x.png"))),
                Map.entry("MistyMarsh", new Image(new FileInputStream("/Images/Tiles/Misty Marsh@2x.png"))),
                Map.entry("Misty Marsh Flooded", new Image(new FileInputStream("/Images/Tiles/Misty Marsh_flood@2x.png"))),
                Map.entry("Observatory", new Image(new FileInputStream("/Images/Tiles/Observatory@2x.png"))),
                Map.entry("Observatory Flooded", new Image(new FileInputStream("/Images/Tiles/Observatory_flood@2x.png"))),
                Map.entry("PhantomRock", new Image(new FileInputStream("/Images/Tiles/Phantom Rock@2x.png"))),
                Map.entry("Phantom Rock Flooded", new Image(new FileInputStream("/Images/Tiles/Phantom Rock_flood@2x.png"))),
                Map.entry("SilverGate", new Image(new FileInputStream("/Images/Tiles/Silver Gate@2x.png"))),
                Map.entry("Silver Gate Flooded", new Image(new FileInputStream("/Images/Tiles/Silver Gate_flood@2x.png"))),
                Map.entry("TempleOfTheMoon", new Image(new FileInputStream("/Images/Tiles/Temple of the Moon@2x.png"))),
                Map.entry("Temple of the Moon Flooded", new Image(new FileInputStream("/Images/Tiles/Temple of the Moon_flood@2x.png"))),
                Map.entry("TempleOfTheSun", new Image(new FileInputStream("/Images/Tiles/Temple of the Sun@2x.png"))),
                Map.entry("Temple of the Sun Flooded", new Image(new FileInputStream("/Images/Tiles/Temple of the Sun_flood@2x.png"))),
                Map.entry("TidalPalace", new Image(new FileInputStream("/Images/Tiles/Tidal Palace@2x.png"))),
                Map.entry("Tidal Palace Flooded", new Image(new FileInputStream("/Images/Tiles/Tidal Palace_flood@2x.png"))),
                Map.entry("TwilightHollow", new Image(new FileInputStream("/Images/Tiles/Twilight Hollow@2x.png"))),
                Map.entry("Twilight Hollow Flooded", new Image(new FileInputStream("/Images/Tiles/Twilight Hollow_flood@2x.png"))),
                Map.entry("Watchtower", new Image(new FileInputStream("/Images/Tiles/Watchtower@2x.png"))),
                Map.entry("Watchtower Flooded", new Image(new FileInputStream("/Images/Tiles/Watchtower_flood@2x.png"))),
                Map.entry("WhisperingGarden", new Image(new FileInputStream("/Images/Tiles/Whispering Garden@2x.png"))),
                Map.entry("Whispering Garden Flooded", new Image(new FileInputStream("/Images/Tiles/Whispering Garden_flood@2x.png")))
        );

    }
}
