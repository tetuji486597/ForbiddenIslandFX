package game.simulation.card;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class TreasureCard implements Card {
    private String type;
    private String color;
    private Image image;

    public TreasureCard(String x) throws IOException {
        color = x;
        type = "Treasure";

//
    }

    @Override
    public String getType() {
        return type;
    }
}
