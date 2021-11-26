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
    public static Map<String, Image> roles;
    public static ArrayList tilesList = new ArrayList(Arrays.asList("Breakers Bridge", "Bronze Gate", "Cave of Embers", "Cave of Shadows", "Cliffs of Abandon", "Copper Gate", "Coral Palace", "Crimson Forest", "Dunes of Deception", "Fools Landing", "Gold Gate", "Howling Garden", "Iron Gate", "Lost Lagoon", "Misty Marsh", "Observatory", "Phantom Rock", "Silver Gate", "Temple of the Moon", "Temple of the Sun", "Tidal Palace", "Twilight Hollow", "Watchtower", "Whispering Garden"));
    public static Map.Entry waterrise;

    public static void init() throws IOException {

        waterrise = Map.entry("WaterRise", new Image(new FileInputStream("src/main/resources/Images/TreasureCards/Card_Waters_Rise.png")));

        treasures = Map.ofEntries(
                Map.entry("OceansChalice", new Image(new FileInputStream("src/main/resources/Images/Treasures/EAU.png"))),
                Map.entry("CrystalOfFire", new Image(new FileInputStream("src/main/resources/Images/Treasures/FEU.png"))),
                Map.entry("EarthStone", new Image(new FileInputStream("src/main/resources/Images/Treasures/TERRE.png"))),
                Map.entry("StatueOfWind", new Image(new FileInputStream("src/main/resources/Images/Treasures/AIR.png")))
        );

        roles = Map.ofEntries(
                Map.entry("Navigator", new Image(new FileInputStream("src/main/resources/Images/Icons/RoleTable_Icon_Navigator@2x.png"))),
                Map.entry("Messenger", new Image(new FileInputStream("src/main/resources/Images/Icons/RoleTable_Icon_Messenger@2x.png"))),
                Map.entry("Engineer", new Image(new FileInputStream("src/main/resources/Images/Icons/RoleTable_Icon_Engineer@2x.png"))),
                Map.entry("Pilot", new Image(new FileInputStream("src/main/resources/Images/Icons/RoleTable_Icon_Pilot@2x.png"))),
                Map.entry("Explorer", new Image(new FileInputStream("src/main/resources/Images/Icons/RoleTable_Icon_Explorer@2x.png"))),
                Map.entry("Diver", new Image(new FileInputStream("src/main/resources/Images/Icons/RoleTable_Icon_Diver@2x.png")))
        );

        floodcards = Map.ofEntries(
                Map.entry("BeakersBridge", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Breakers Bridge@2x.png"))),
                Map.entry("BronzeGate", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Bronze Gate@2x.png"))),
                Map.entry("CaveOfEmbers", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Cave of Embers@2x.png"))),
                Map.entry("CaveOfShadows", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Cave of Shadows@2x.png"))),
                Map.entry("CliffsOfAbandon", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Cliffs of Abandon@2x.png"))),
                Map.entry("CopperGate", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Copper Gate@2x.png"))),
                Map.entry("CoralPalace", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Coral Palace@2x.png"))),
                Map.entry("CrimsonForest", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Crimson Forest@2x.png"))),
                Map.entry("DunesOfDeception", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Dunes of Deception@2x.png"))),
                Map.entry("FoolsLanding", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Fools_ Landing@2x.png"))),
                Map.entry("GoldGate", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Gold Gate@2x.png"))),
                Map.entry("HowlingGarden", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Howling Garden@2x.png"))),
                Map.entry("IronGate", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Iron Gate@2x.png"))),
                Map.entry("LostLagoon", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Lost Lagoon@2x.png"))),
                Map.entry("MistyMarsh", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Misty Marsh@2x.png"))),
                Map.entry("Observatory", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Observatory@2x.png"))),
                Map.entry("PhantomRock", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Phantom Rock@2x.png"))),
                Map.entry("SilverGate", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Silver Gate@2x.png"))),
                Map.entry("TempleOfTheMoon", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Temple of the Moon@2x.png"))),
                Map.entry("TempleOfTheSun", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Temple of the Sun@2x.png"))),
                Map.entry("TidalPalace", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Tidal Palace@2x.png"))),
                Map.entry("TwilightHollow", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Twilight Hollow@2x.png"))),
                Map.entry("Watchtower", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Watchtower@2x.png"))),
                Map.entry("WhisperingGarden", new Image(new FileInputStream("src/main/resources/Images/FloodCards/Flood_Card_Whispering Garden@2x.png")))
        );

        treasurecards = Map.ofEntries(
                Map.entry("OceansChalice", new Image(new FileInputStream("src/main/resources/Images/TreasureCards/Card_Oceans_Chalice.png"))),
                Map.entry("CrystalOfFire", new Image(new FileInputStream("src/main/resources/Images/TreasureCards/Card_Crystal_of_Fire.png"))),
                Map.entry("EarthStone", new Image(new FileInputStream("src/main/resources/Images/TreasureCards/Card_Earth_Stone.png"))),
                Map.entry("StatueOfWind", new Image(new FileInputStream("src/main/resources/Images/TreasureCards/Card_Statue_of_the_Wind.png"))),
                Map.entry("HelicopterLift", new Image(new FileInputStream("src/main/resources/Images/TreasureCards/Card_Helicopter.png"))),
                Map.entry("Sandbag", new Image(new FileInputStream("src/main/resources/Images/TreasureCards/Card_Sand_Bag.png")))
        );

        tiles = Map.ofEntries(
                Map.entry("BreakersBridge", new Image(new FileInputStream("src/main/resources/Images/Tiles/Breakers Bridge@2x.png"))),
                Map.entry("BreakersBridgeFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Breakers Bridge_flood@2x.png"))),
                Map.entry("BronzeGate", new Image(new FileInputStream("src/main/resources/Images/Tiles/Bronze Gate@2x.png"))),
                Map.entry("BronzeGateFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Bronze Gate_flood@2x.png"))),
                Map.entry("CaveOfEmbers", new Image(new FileInputStream("src/main/resources/Images/Tiles/Cave of Embers@2x.png"))),
                Map.entry("CaveOfEmbersFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Cave of Embers_flood@2x.png"))),
                Map.entry("CaveOfShadows", new Image(new FileInputStream("src/main/resources/Images/Tiles/Cave of Shadows@2x.png"))),
                Map.entry("CaveOfShadowsFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Cave of Shadows_flood@2x.png"))),
                Map.entry("CliffsOfAbandon", new Image(new FileInputStream("src/main/resources/Images/Tiles/Cliffs of Abandon@2x.png"))),
                Map.entry("CliffsOfAbandonFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Cliffs of Abandon_flood@2x.png"))),
                Map.entry("CopperGate", new Image(new FileInputStream("src/main/resources/Images/Tiles/Copper Gate@2x.png"))),
                Map.entry("CopperGateFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Copper Gate_flood@2x.png"))),
                Map.entry("CoralPalace", new Image(new FileInputStream("src/main/resources/Images/Tiles/Coral Palace@2x.png"))),
                Map.entry("CoralPalaceFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Coral Palace_flood@2x.png"))),
                Map.entry("CrimsonForest", new Image(new FileInputStream("src/main/resources/Images/Tiles/Crimson Forest@2x.png"))),
                Map.entry("CrimsonForestFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Crimson Forest_flood@2x.png"))),
                Map.entry("DunesOfDeception", new Image(new FileInputStream("src/main/resources/Images/Tiles/Dunes of Deception@2x.png"))),
                Map.entry("DunesOfDeceptionFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Dunes of Deception_flood@2x.png"))),
                Map.entry("FoolsLanding", new Image(new FileInputStream("src/main/resources/Images/Tiles/Fools_ Landing@2x.png"))),
                Map.entry("FoolsLandingFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Fools_ Landing_flood@2x.png"))),
                Map.entry("GoldGate", new Image(new FileInputStream("src/main/resources/Images/Tiles/Gold Gate@2x.png"))),
                Map.entry("GoldGateFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Gold Gate_flood@2x.png"))),
                Map.entry("HowlingGarden", new Image(new FileInputStream("src/main/resources/Images/Tiles/Howling Garden@2x.png"))),
                Map.entry("HowlingGardenFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Howling Garden_flood@2x.png"))),
                Map.entry("IronGate", new Image(new FileInputStream("src/main/resources/Images/Tiles/Iron Gate@2x.png"))),
                Map.entry("IronGateFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Iron Gate_flood@2x.png"))),
                Map.entry("LostLagoon", new Image(new FileInputStream("src/main/resources/Images/Tiles/Lost Lagoon@2x.png"))),
                Map.entry("LostLagoonFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Lost Lagoon_flood@2x.png"))),
                Map.entry("MistyMarsh", new Image(new FileInputStream("src/main/resources/Images/Tiles/Misty Marsh@2x.png"))),
                Map.entry("MistyMarshFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Misty Marsh_flood@2x.png"))),
                Map.entry("Observatory", new Image(new FileInputStream("src/main/resources/Images/Tiles/Observatory@2x.png"))),
                Map.entry("ObservatoryFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Observatory_flood@2x.png"))),
                Map.entry("PhantomRock", new Image(new FileInputStream("src/main/resources/Images/Tiles/Phantom Rock@2x.png"))),
                Map.entry("PhantomRockFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Phantom Rock_flood@2x.png"))),
                Map.entry("SilverGate", new Image(new FileInputStream("src/main/resources/Images/Tiles/Silver Gate@2x.png"))),
                Map.entry("SilverGateFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Silver Gate_flood@2x.png"))),
                Map.entry("TempleOfTheMoon", new Image(new FileInputStream("src/main/resources/Images/Tiles/Temple of the Moon@2x.png"))),
                Map.entry("TempleOfTheMoonFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Temple of the Moon_flood@2x.png"))),
                Map.entry("TempleOfTheSun", new Image(new FileInputStream("src/main/resources/Images/Tiles/Temple of the Sun@2x.png"))),
                Map.entry("TempleOfTheSunFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Temple of the Sun_flood@2x.png"))),
                Map.entry("TidalPalace", new Image(new FileInputStream("src/main/resources/Images/Tiles/Tidal Palace@2x.png"))),
                Map.entry("TidalPalaceFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Tidal Palace_flood@2x.png"))),
                Map.entry("TwilightHollow", new Image(new FileInputStream("src/main/resources/Images/Tiles/Twilight Hollow@2x.png"))),
                Map.entry("TwilightHollowFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Twilight Hollow_flood@2x.png"))),
                Map.entry("Watchtower", new Image(new FileInputStream("src/main/resources/Images/Tiles/Watchtower@2x.png"))),
                Map.entry("WatchtowerFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Watchtower_flood@2x.png"))),
                Map.entry("WhisperingGarden", new Image(new FileInputStream("src/main/resources/Images/Tiles/Whispering Garden@2x.png"))),
                Map.entry("WhisperingGardenFlooded", new Image(new FileInputStream("src/main/resources/Images/Tiles/Whispering Garden_flood@2x.png"))),
                Map.entry("Sunk",new Image(new FileInputStream("src/main/resources/Images/Tiles/extra/Tile_Flood_Water@2x.png")))
        );

    }
}
