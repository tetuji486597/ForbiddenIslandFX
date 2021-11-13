package game.graphics;

import game.simulation.board.GameTile;
import game.simulation.brains.GameState;
import game.simulation.brains.Initialize;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class GameBoardController {

    @FXML
    private GridPane gridPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ImageView r0c2;

    @FXML
    private ImageView r0c3;

    @FXML
    private ImageView r1c1;

    @FXML
    private ImageView r1c2;

    @FXML
    private ImageView r1c3;

    @FXML
    private ImageView r1c4;

    @FXML
    private ImageView r2c0;

    @FXML
    private ImageView r2c1;

    @FXML
    private ImageView r2c2;

    @FXML
    private ImageView r2c3;

    @FXML
    private ImageView r2c4;

    @FXML
    private ImageView r2c5;

    @FXML
    private ImageView r3c0;

    @FXML
    private ImageView r3c1;

    @FXML
    private ImageView r3c2;

    @FXML
    private ImageView r3c3;

    @FXML
    private ImageView r3c4;

    @FXML
    private ImageView r3c5;

    @FXML
    private ImageView r4c1;

    @FXML
    private ImageView r4c2;

    @FXML
    private ImageView r4c3;

    @FXML
    private ImageView r4c4;

    @FXML
    private ImageView r5c2;

    @FXML
    private ImageView r5c3;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void startGame(ActionEvent event) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        String tiles[] = GameState.allTiles;
        System.out.println(Arrays.toString(tiles));
        for(int i = 0; i < 24; i++) {
            imageViews[i].setImage(Initialize.tiles.get(tiles[i]));
        }
//        r0c2.setImage(new Image("@../../Images/Tiles/Fools_ Landing@2x.png"));
    }

    private static Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }

        return new ImageView(wr).getImage();
    }


    public void r3c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 3 Clicked");
    }
}
