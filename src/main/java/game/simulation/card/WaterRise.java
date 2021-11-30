package game.simulation.card;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WaterRise implements Card {
    private String type;
    //private BufferedImage image;

    public WaterRise() throws IOException {
        type = "WatersRise";
    }

    @Override
    public String getType() {
        return type;
    }

}
