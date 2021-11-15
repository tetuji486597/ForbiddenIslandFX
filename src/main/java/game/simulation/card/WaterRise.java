package game.simulation.card;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WaterRise implements Card {
    private String type;
    private Image image;

    public WaterRise() throws IOException {
        type = "WatersRise";
        //image = ImageIO.read(getClass().getClassLoader().getResource("Images/TreasureCards/Card_Waters_Rise.png"));
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Image getImage() {
        return image;
    }
}
