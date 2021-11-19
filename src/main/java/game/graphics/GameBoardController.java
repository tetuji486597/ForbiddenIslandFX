package game.graphics;

import game.simulation.brains.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.util.*;

public class GameBoardController {

    public static ImageView[] waterlevels;
    public static GridPane[] playerInv;
    public static ImageView[] playerRoles;
    public static HashMap<int[], ImageView> tilesMap;
    public static Map<Integer,ImageView[]> playerCards;

    @FXML
    private ImageView Player1Card1;

    @FXML
    private ImageView Player1Card2;

    @FXML
    private ImageView Player1Card3;

    @FXML
    private ImageView Player1Card4;

    @FXML
    private ImageView Player1Card5;

    @FXML
    private GridPane Player1Inv;

    @FXML
    private ImageView Player1Role;

    @FXML
    private ImageView Player2Card1;

    @FXML
    private ImageView Player2Card2;

    @FXML
    private ImageView Player2Card3;

    @FXML
    private ImageView Player2Card4;

    @FXML
    private ImageView Player2Card5;

    @FXML
    private GridPane Player2Inv;

    @FXML
    private ImageView Player2Role;

    @FXML
    private ImageView Player3Card1;

    @FXML
    private ImageView Player3Card2;

    @FXML
    private ImageView Player3Card3;

    @FXML
    private ImageView Player3Card4;

    @FXML
    private ImageView Player3Card5;

    @FXML
    private GridPane Player3Inv;

    @FXML
    private ImageView Player3Role;

    @FXML
    private ImageView Player4Card1;

    @FXML
    private ImageView Player4Card2;

    @FXML
    private ImageView Player4Card3;

    @FXML
    private ImageView Player4Card4;

    @FXML
    private ImageView Player4Card5;

    @FXML
    private GridPane Player4Inv;

    @FXML
    private ImageView Player4Role;

    @FXML
    private GridPane gridPane;

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
    private ScrollPane scrollPane;

    @FXML
    private ImageView waterLevel1;

    @FXML
    private ImageView waterLevel2;

    @FXML
    private ImageView waterLevel3;

    @FXML
    private ImageView waterLevel4;

    @FXML
    private ImageView waterLevel5;

    @FXML
    private ImageView waterLevel6;

    @FXML
    private ImageView waterLevel7;

    @FXML
    private ImageView waterLevel8;

    @FXML
    private ImageView waterLevel9;

    @FXML
    private ImageView waterLevel10;

    @FXML
    private Button startButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button floodButton;

    @FXML
    public void initialize() {
        waterlevels = new ImageView[]{waterLevel1,waterLevel2,waterLevel3,waterLevel4,waterLevel5,waterLevel6,waterLevel7,waterLevel8,waterLevel9,waterLevel10};
        playerInv = new GridPane[]{Player1Inv,Player2Inv,Player3Inv,Player4Inv};
        playerCards = Map.ofEntries(
                Map.entry(1,new ImageView[]{Player1Card1,Player1Card2,Player1Card3,Player1Card4,Player1Card5}),
                Map.entry(2,new ImageView[]{Player2Card1,Player2Card2,Player2Card3,Player2Card4,Player2Card5}),
                Map.entry(3,new ImageView[]{Player3Card1,Player3Card2,Player3Card3,Player3Card4,Player3Card5}),
                Map.entry(4,new ImageView[]{Player4Card1,Player4Card2,Player4Card3,Player4Card4,Player4Card5})
        );
        playerRoles = new ImageView[]{Player1Role,Player2Role,Player3Role,Player4Role};
        System.out.println("water");
        for(ImageView im : waterlevels){
            im.setVisible(false);
        }
        ImageView helpImg = new ImageView(new Image("/Images/help.png"));
        ImageView settingsImg = new ImageView(new Image("/Images/settings.png"));
        helpButton.setGraphic(helpImg);
        helpButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 80; " +
                        "-fx-min-height: 80px; " +
                        "-fx-max-width: 80; " +
                        "-fx-max-height: 80px;"
        );
        settingsButton.setGraphic(settingsImg);
        settingsButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 80px; " +
                        "-fx-min-height: 80px; " +
                        "-fx-max-width: 80px; " +
                        "-fx-max-height: 80px;"
        );

    }

    @FXML
    void startGame(ActionEvent event) throws FileNotFoundException, InterruptedException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        int[][] pos = GameState.pos;
        tilesMap = new HashMap<int[], ImageView>();
        for(int i =0;i<24;i++) {
            tilesMap.put(pos[i],imageViews[i]);
        }
//        System.out.println(tilesMap.get(tilesMap.));
        String tiles[] = GameState.allTiles;
        System.out.println(Arrays.toString(tiles));
        drawBoard();
        waterlevels[GameState.waterLevel-1].setVisible(true);
        int numPlayers = GameState.numPlayers;
        for(int i = 0; i < numPlayers; i++){
            playerInv[i].setVisible(true);
            playerRoles[i].setImage(Initialize.roles.get(GameState.allPlayers.get(i).getRole()));

            ArrayList<String> playerdeck  = GameState.allPlayers.get(i).getDeck();
            System.out.println(playerdeck);
            int playerdecksize  = GameState.allPlayers.get(i).getDeck().size();
            ImageView[] imageviewdeck = playerCards.get(i+1);
            for(int j = 0; j < playerdecksize; j++){
                imageviewdeck[j].setImage(Initialize.treasurecards.get(playerdeck.get(j)));
            }
        }
        startButton.setVisible(false);
    }

    @FXML
    void floodFoolsLanding(ActionEvent event) throws FileNotFoundException, InterruptedException {
        GameState.tiles[1].setGone(true);
        GameState.tiles[1].setFlooded(true);
        GameState.tiles[2].setFlooded(true);
        GameState.tiles[3].setFlooded(true);
        GameState.tiles[4].setFlooded(true);
//        GameState.drawFlood(GameState.tiles[1]);
        drawBoard();
        System.out.println("clicked");
    }

    void drawBoard() throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        for(int i = 0; i < 24; i++) {
            imageViews[i].setImage(GameState.tiles[i].getTile());
        }
    }

    @FXML
    void showHelp(ActionEvent event) {
        ParentPanel.helpPanel.show();
    }
    public void r0c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 0 Column 2 Clicked");
    }
    public void r0c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 0 Column 3 Clicked");
    }
    public void r1c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 1 Clicked");
    }
    public void r1c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 2 Clicked");
    }
    public void r1c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 3 Clicked");
    }
    public void r1c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 4 Clicked");
    }
    public void r2c0Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 0 Clicked");
    }
    public void r2c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 1 Clicked");
    }
    public void r2c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 2 Clicked");
    }
    public void r2c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 3 Clicked");
    }
    public void r2c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 4 Clicked");
    }
    public void r2c5Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 5 Clicked");
    }
    public void r3c0Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 0 Clicked");
    }
    public void r3c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 1 Clicked");
    }
    public void r3c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 2 Clicked");
    }
    public void r3c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 3 Clicked");
    }
    public void r3c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 4 Clicked");
    }
    public void r3c5Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 5 Clicked");
    }
    public void r4c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 1 Clicked");
    }
    public void r4c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 2 Clicked");
    }
    public void r4c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 3 Clicked");
    }
    public void r4c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 4 Clicked");
    }
    public void r5c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 5 Column 2 Clicked");
    }
    public void r5c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 5 Column 3 Clicked");
    }

    public void player1card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 1 Clicked");
        System.out.println(GameState.allPlayers.get(0).getDeck().get(0));
    }
    public void player1card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 2 Clicked");
    }
    public void player1card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 3 Clicked");
    }
    public void player1card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 4 Clicked");
    }
    public void player1card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 5 Clicked");
    }

    public void player2card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 1 Clicked");
    }
    public void player2card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 2 Clicked");
    }
    public void player2card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 3 Clicked");
    }
    public void player2card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 4 Clicked");
    }
    public void player2card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 5 Clicked");
    }

    public void player3card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 1 Clicked");
    }
    public void player3card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 2 Clicked");
    }
    public void player3card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 3 Clicked");
    }
    public void player3card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 4 Clicked");
    }
    public void player3card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 5 Clicked");
    }

    public void player4card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 1 Clicked");
    }
    public void player4card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 2 Clicked");
    }
    public void player4card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 3 Clicked");
    }
    public void player4card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 4 Clicked");
    }
    public void player4card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 5 Clicked");
    }

}

