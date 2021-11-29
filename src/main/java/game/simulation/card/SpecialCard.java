package game.simulation.card;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpecialCard implements Card {
    private String type;

    private SpecialCard(String x) throws IOException {
        type = x;
//
    }

    @Override
    public String getType() {
        return type;
    }
}
