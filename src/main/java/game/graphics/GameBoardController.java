package game.graphics;

import game.simulation.brains.*;
import game.simulation.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameBoardController {

    public static ImageView[]                   waterlevels;
    public static GridPane[]                    playerInv;
    public static ImageView[]                   playerRoles;
    public static HashMap<String, GridPane>     gridMap;
    public static HashMap<int[], ImageView>     tilesMap;
    public static Map<Integer,ImageView[]>      playerCards;

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
    private ImageView r0c21;

    @FXML
    private ImageView r0c3;

    @FXML
    private ImageView r0c31;

    @FXML
    private ImageView r1c1;

    @FXML
    private ImageView r1c11;

    @FXML
    private ImageView r1c2;

    @FXML
    private ImageView r1c21;

    @FXML
    private ImageView r1c3;

    @FXML
    private ImageView r1c31;

    @FXML
    private ImageView r1c4;

    @FXML
    private ImageView r1c41;

    @FXML
    private ImageView r2c0;

    @FXML
    private ImageView r2c01;

    @FXML
    private ImageView r2c1;

    @FXML
    private ImageView r2c11;

    @FXML
    private ImageView r2c2;

    @FXML
    private ImageView r2c21;

    @FXML
    private ImageView r2c3;

    @FXML
    private ImageView r2c31;

    @FXML
    private ImageView r2c4;

    @FXML
    private ImageView r2c41;

    @FXML
    private ImageView r2c5;

    @FXML
    private ImageView r2c51;

    @FXML
    private ImageView r3c0;

    @FXML
    private ImageView r3c01;

    @FXML
    private ImageView r3c1;

    @FXML
    private ImageView r3c11;

    @FXML
    private ImageView r3c2;

    @FXML
    private ImageView r3c21;

    @FXML
    private ImageView r3c3;

    @FXML
    private ImageView r3c31;

    @FXML
    private ImageView r3c4;

    @FXML
    private ImageView r3c41;

    @FXML
    private ImageView r3c5;

    @FXML
    private ImageView r3c51;

    @FXML
    private ImageView r4c1;

    @FXML
    private ImageView r4c11;

    @FXML
    private ImageView r4c2;

    @FXML
    private ImageView r4c21;

    @FXML
    private ImageView r4c3;

    @FXML
    private ImageView r4c31;

    @FXML
    private ImageView r4c4;

    @FXML
    private ImageView r4c41;

    @FXML
    private ImageView r5c2;

    @FXML
    private ImageView r5c21;

    @FXML
    private ImageView r5c3;

    @FXML
    private ImageView r5c31;

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
    private ImageView blackpawn;

    @FXML
    private ColumnConstraints blkn;

    @FXML
    private Button floodButton;

    @FXML
    private GridPane g0p2;

    @FXML
    private GridPane g0p3;

    @FXML
    private GridPane g1p1;

    @FXML
    private GridPane g1p2;

    @FXML
    private GridPane g1p3;

    @FXML
    private GridPane g1p4;

    @FXML
    private GridPane g2p0;

    @FXML
    private GridPane g2p1;

    @FXML
    private GridPane g2p2;

    @FXML
    private GridPane g2p3;

    @FXML
    private GridPane g2p4;

    @FXML
    private GridPane g2p5;

    @FXML
    private GridPane g3p0;

    @FXML
    private GridPane g3p1;

    @FXML
    private GridPane g3p2;

    @FXML
    private GridPane g3p3;

    @FXML
    private GridPane g3p4;

    @FXML
    private GridPane g3p5;

    @FXML
    private GridPane g4p1;

    @FXML
    private GridPane g4p2;

    @FXML
    private GridPane g4p3;

    @FXML
    private GridPane g4p4;

    @FXML
    private GridPane g5p2;

    @FXML
    private GridPane g5p3;

    @FXML
    private Circle action1;

    @FXML
    private Circle action2;

    @FXML
    private Circle action3;

    @FXML
    private ToggleButton moveButton;

    @FXML
    private Button retrieveButton;

    @FXML
    private Label player1Role;

    @FXML
    private Label player2Role;

    @FXML
    private Label player3Role;

    @FXML
    private Label player4Role;

    @FXML
    private ToggleButton shoreButton;

    @FXML
    private ToggleButton tradeButton;

    @FXML
    private ToggleButton abilityButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ToggleButton useButton;

    @FXML
    private ImageView floodDiscardImage;

    @FXML
    private ImageView treasureDiscardImage;

    @FXML
    private Label choosePlayerText;

    @FXML
    private Label actionUsedText;

    @FXML
    private ImageView nextPlayer;

    @FXML
    private ImageView nextPlayer2;

    @FXML
    private ImageView nextPlayer3;

    @FXML
    public void initialize() throws FileNotFoundException {
        waterlevels = new ImageView[]{waterLevel1,waterLevel2,waterLevel3,waterLevel4,waterLevel5,waterLevel6,waterLevel7,waterLevel8,waterLevel9,waterLevel10};
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
        GridPane[] gridPanes = new GridPane[]{g0p2,g0p3,g1p1,g1p2,g1p3,g1p4,g2p0,g2p1,g2p2,g2p3,g2p4,g2p5,g3p0,g3p1,g3p2,g3p3,g3p4,g3p5,g4p1,g4p2,g4p3,g4p4,g5p2,g5p3};
        gridMap = new HashMap<String, GridPane>();
        ToggleGroup toggleGroup = new ToggleGroup();
        moveButton.setToggleGroup(toggleGroup);
        shoreButton.setToggleGroup(toggleGroup);

        actionUsedText.setTranslateY(42);
        action1.setTranslateY(42);
        action2.setTranslateY(42);
        action3.setTranslateY(42);

        choosePlayerText.setVisible(false);
        nextPlayer.setVisible(false);
        nextPlayer2.setVisible(false);
        nextPlayer3.setVisible(false);
    }

    @FXML
    void startGame(ActionEvent event) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        GridPane[] gridPanes = new GridPane[]{g0p2,g0p3,g1p1,g1p2,g1p3,g1p4,g2p0,g2p1,g2p2,g2p3,g2p4,g2p5,g3p0,g3p1,g3p2,g3p3,g3p4,g3p5,g4p1,g4p2,g4p3,g4p4,g5p2,g5p3};
        int[][] pos = GameState.pos;
        Label[] labels = new Label[]{player1Role,player2Role,player3Role,player4Role};
        tilesMap = new HashMap<>();
        for(int i =0;i<24;i++) {
            tilesMap.put(pos[i],imageViews[i]);
            gridMap.put(Arrays.toString(pos[i]),gridPanes[i]);
        }
        for(GridPane gp : playerInv){
            gp.setVisible(false);
        }
        for(int i = 0; i < GameState.numPlayers; i++){
            playerInv[i].setVisible(true);
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
            updateDiscard();
        }

        checkNavigator();
//        System.out.println(GameState.allPlayers.get(0).getStartingPos());
//        gridMap.get(GameState.allPlayers.get(0).getStartingPos()).add(pawn,GameState.allPlayers.get(0).getIndex(),0,1,1);
//        for(Player p: GameState.allPlayers){
//            ImageView pawn = p.getCurrentPawn();
//            p.setCurrentTile(gridMap.get(Arrays.toString(p.getStartingPos())));
//            p.getCurrentTile().add(pawn,p.getIndex(),0,1,1);
//        }
        startButton.setVisible(false);

        for(int i = 0; i < 4; i ++){
            labels[i].setText(GameState.allPlayers.get(i).getRole());
        }

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GREEN);
        dropShadow.setHeight(21);
        Player1Inv.setEffect(dropShadow);
        resetActionCounter();

    }

    void checkNavigator(){
        if(GameState.currentPlayer.getRole().equals("Navigator")){
            abilityButton.setVisible(true);
        }
    }

    public void updateDiscard(){
        floodDiscardImage.setImage(Initialize.floodcards.get(GameState.floodDiscard.peek()));
//        treasureDiscardImage.setImage(Initialize.treasurecards.get(GameState.discardPile.peek()));
    }

    void drawBoard() throws FileNotFoundException {
        GridPane[] gridPanes = new GridPane[]{g0p2,g0p3,g1p1,g1p2,g1p3,g1p4,g2p0,g2p1,g2p2,g2p3,g2p4,g2p5,g3p0,g3p1,g3p2,g3p3,g3p4,g3p5,g4p1,g4p2,g4p3,g4p4,g5p2,g5p3};
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        for(int i = 0; i < 24; i++) {
            imageViews[i].setImage(GameState.tiles[i].getTile());
        }
        for(Player p: GameState.allPlayers){
            try {
                ImageView pawn = p.getCurrentPawn();
                pawn.setFitWidth(34);
                pawn.setFitHeight(50);
                p.getCurrentTile().getChildren().remove(pawn);
                p.getCurrentTile().getChildren().removeAll();
            }catch (NullPointerException ex){
                System.out.println("null");
            }
        }
        for(Player p: GameState.allPlayers){
            ImageView pawn = p.getCurrentPawn();
            pawn.setFitWidth(34);
            pawn.setFitHeight(50);
            p.setCurrentTile(gridMap.get(Arrays.toString(p.getStartingPos())));
            p.getCurrentTile().add(pawn,p.getIndex(),0,1,1);
        }
    }

    void updateTiles() throws FileNotFoundException {
        GridPane[] gridPanes = new GridPane[]{g0p2,g0p3,g1p1,g1p2,g1p3,g1p4,g2p0,g2p1,g2p2,g2p3,g2p4,g2p5,g3p0,g3p1,g3p2,g3p3,g3p4,g3p5,g4p1,g4p2,g4p3,g4p4,g5p2,g5p3};
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        for(int i = 0; i < 24; i++) {
            imageViews[i].setImage(GameState.tiles[i].getTile());
        }
    }

    void removePawns(){
        for(Player p: GameState.allPlayers){
            try {
                ImageView pawn = p.getCurrentPawn();
                pawn.setFitWidth(34);
                pawn.setFitHeight(50);
                p.getCurrentTile().getChildren().remove(pawn);
            }catch (NullPointerException ex){
                System.out.println("null");
            }
        }
    }

    void drawPawns(){
        for(Player p: GameState.allPlayers){
            ImageView pawn = p.getCurrentPawn();
            pawn.setFitWidth(34);
            pawn.setFitHeight(50);
            p.getCurrentTile().add(pawn,p.getIndex(),0,1,1);
        }
    }

    void updateCards() throws FileNotFoundException {
        for(int i = 0; i < GameState.numPlayers; i++){
            ImageView[] imageviewdeck = playerCards.get(i+1);
            for(int j = 0; j < 5; j++){
                imageviewdeck[j].setImage(new Image(new FileInputStream("/Images/TreasureCards/Pressed.png")));
            }
        }
        for(int i = 0; i < GameState.numPlayers; i++){
            ArrayList<String> playerdeck  = GameState.allPlayers.get(i).getDeck();
            int playerdecksize  = GameState.allPlayers.get(i).getDeck().size();
            ImageView[] imageviewdeck = playerCards.get(i+1);
            for(int j = 0; j < playerdecksize; j++){
                imageviewdeck[j].setImage(Initialize.treasurecards.get(playerdeck.get(j)));
            }
        }
    }

    @FXML
    void showHelp(ActionEvent event) {
        ParentPanel.helpPanel.show();
    }

    public void nextTurn(){
        resetActionCounter();
    }

    public void moveClicked(MouseEvent mouseEvent) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        for (ImageView im : imageViews)
            im.setEffect(null);
        if(!moveButton.isSelected()) {
            removePawns();
            GameState.currentPlayer.setActivePawn("active");
            drawPawns();
            return;
        }

        removePawns();
        GameState.currentPlayer.setActivePawn("move");
        drawPawns();
        boolean[][] moveableTiles = GameState.currentPlayer.getMoveableTiles(GameState.posMap.get(Arrays.toString(GameState.currentPlayer.getPos())));
        System.out.println(Arrays.deepToString(moveableTiles));
        int i = 0;
        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(5.0);
        dropShadow.setColor(Color.GREENYELLOW);
        dropShadow.setWidth(5.0);
        dropShadow.setSpread(1.0);
        Image image = new Image(new FileInputStream("/Images/Tiles/extra/Tile_Movement_Icon@2x.png"));
        for(int r = 0; r < moveableTiles.length; r++){
            for(int c = 0; c < moveableTiles[r].length; c++){
                if(r == 0 && c == 0 || r == 0 && c == 1 || r == 0 && c == 4 || r == 0 && c == 5) continue;
                else if(r == 1 && c == 0 || r == 1 && c == 5) continue;
                else if(r == 4 && c == 0 || r == 4 && c == 5) continue;
                else if(r == 5 && c == 0 || r == 5 && c == 1 || r == 5 && c == 4 || r == 5 && c == 5) continue;
                else if(moveableTiles[r][c]) {
                    imageViews[i].setEffect(dropShadow);
                    i++;
                }
                else i++;
            }
        }
    }

    public void shoreClicked(MouseEvent mouseEvent) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        for (ImageView im : imageViews)
            im.setEffect(null);
        if(!shoreButton.isSelected()) {
            return;
        }
        Image image = new Image(new FileInputStream("/Images/Tiles/extra/Tile_Flood_Icon@2x.png"));
        boolean[][] shoreableTiles = GameState.currentPlayer.getShoreableTiles(GameState.posMap.get(Arrays.toString(GameState.currentPlayer.getPos())));
        int i = 0;
        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(5.0);
        dropShadow.setColor(Color.YELLOW);
        dropShadow.setWidth(5.0);
        dropShadow.setSpread(1.0);
        for(int r = 0; r < shoreableTiles.length; r++){
            for(int c = 0; c < shoreableTiles[r].length; c++){
                if(r == 0 && c == 0 || r == 0 && c == 1 || r == 0 && c == 4 || r == 0 && c == 5) continue;
                else if(r == 1 && c == 0 || r == 1 && c == 5) continue;
                else if(r == 4 && c == 0 || r == 4 && c == 5) continue;
                else if(r == 5 && c == 0 || r == 5 && c == 1 || r == 5 && c == 4 || r == 5 && c == 5) continue;
                else if(shoreableTiles[r][c]) {
                    imageViews[i].setEffect(dropShadow);
                    i++;
                }
                else i++;
            }
        }
    }
    private boolean useHelicopter;
    private boolean useSandbag;
    private int useCardPlayer;

    public void cardClicked(int player, int card) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        String[] tiles = new String[]{"[0, 2]","[0, 3]","[1, 1]","[1, 2]","[1, 3]","[1, 4]","[2, 0]","[2, 1]","[2, 2]","[2, 3]","[2, 4]","[2, 5]","[3, 0]","[3, 1]","[3, 2]","[3, 3]","[3, 4]","[3, 5]","[4, 1]","[4, 2]","[4, 3]","[4, 4]","[5, 2]","[5, 3]"};
        ImageView[][] cards = {
                {Player1Card1,Player1Card2,Player1Card3,Player1Card4,Player1Card5},
                {Player2Card1,Player2Card2,Player2Card3,Player2Card4,Player2Card5},
                {Player3Card1,Player3Card2,Player3Card3,Player3Card4,Player3Card5},
                {Player4Card1,Player4Card2,Player4Card3,Player4Card4,Player4Card5}
        };
        DropShadow highlight = new DropShadow();
        highlight.setColor(Color.YELLOW);
        if(!useButton.isSelected()) return;
        else{
            switch (GameState.allPlayers.get(player-1).getDeck().get(card-1)){
                case "Sandbag":
                    DropShadow dropShadow = new DropShadow();
                    dropShadow.setHeight(5.0);
                    dropShadow.setColor(Color.YELLOW);
                    dropShadow.setWidth(5.0);
                    dropShadow.setSpread(1.0);
                    cancelButton.setVisible(true);
                    useSandbag = true;
                    cards[player-1][card-1].setEffect(highlight);
                    Image image = new Image(new FileInputStream("/Images/Tiles/extra/Tile_Flood_Icon@2x.png"));
                    char[][] shoreableTiles = GameState.getCurrentState();
                    int i = 0;
                    for(int r = 0; r < shoreableTiles.length; r++){
                        for(int c = 0; c < shoreableTiles[r].length; c++){
                            if(r == 0 && c == 0 || r == 0 && c == 1 || r == 0 && c == 4 || r == 0 && c == 5) continue;
                            else if(r == 1 && c == 0 || r == 1 && c == 5) continue;
                            else if(r == 4 && c == 0 || r == 4 && c == 5) continue;
                            else if(r == 5 && c == 0 || r == 5 && c == 1 || r == 5 && c == 4 || r == 5 && c == 5) continue;
                            else if(shoreableTiles[r][c] == 'F') {
                                imageViews[i].setEffect(dropShadow);
                            }
                            i++;
                        }
                    }
                    useCardPlayer = player-1;
                    break;
                case "HelicopterLift":
                    DropShadow dropShadow1 = new DropShadow();
                    dropShadow1.setHeight(5.0);
                    dropShadow1.setColor(Color.GREEN);
                    dropShadow1.setWidth(5.0);
                    dropShadow1.setSpread(1.0);
                    cancelButton.setVisible(true);
                    useHelicopter = true;
                    cards[player-1][card-1].setEffect(highlight);
                    int[] pos = GameState.allPlayers.get(player-1).getPos();
                    System.out.println(Arrays.toString(pos));
                    int iu = 0;
                    removePawns();
                    GameState.allPlayers.get(player-1).setActivePawn("move");
                    drawPawns();
                    Image imagee = new Image(new FileInputStream("/Images/Tiles/extra/Tile_Movement_Icon@2x.png"));
                    for(int r = 0; r < 6; r++){
                        for(int c = 0; c < 6; c++){
                            if(r == 0 && c == 0 || r == 0 && c == 1 || r == 0 && c == 4 || r == 0 && c == 5) continue;
                            else if(r == 1 && c == 0 || r == 1 && c == 5) continue;
                            else if(r == 4 && c == 0 || r == 4 && c == 5) continue;
                            else if(r == 5 && c == 0 || r == 5 && c == 1 || r == 5 && c == 4 || r == 5 && c == 5) continue;
                            else if(tiles[iu].equals(Arrays.toString(pos))) iu++;
                            else {
                                imageViews[iu].setEffect(dropShadow1);
                                iu++;
                            }
                        }
                    }
                    useCardPlayer = player-1;
                    break;
                default:
                    return;
            }
        }
    }

    @FXML
    void cancelUseCard(ActionEvent event){
        if(useButton.isSelected()) {
            removePawns();
            if (GameState.currentPlayer.equals(GameState.allPlayers.get(useCardPlayer)))
                GameState.currentPlayer.setActivePawn("active");
            GameState.allPlayers.get(useCardPlayer).setActivePawn("pawn");
            drawPawns();
            useCardPlayer = -1;
            useHelicopter = false;
            useSandbag = false;
            ImageView[][] cards = {
                    {Player1Card1, Player1Card2, Player1Card3, Player1Card4, Player1Card5},
                    {Player2Card1, Player2Card2, Player2Card3, Player2Card4, Player2Card5},
                    {Player3Card1, Player3Card2, Player3Card3, Player3Card4, Player3Card5},
                    {Player4Card1, Player4Card2, Player4Card3, Player4Card4, Player4Card5}
            };
            for (int i = 0; i < cards.length; i++) {
                for (int j = 0; j < cards[i].length; j++) {
                    cards[i][j].setEffect(null);
                }
            }
            ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
            for (ImageView iv : imageViews) {
                iv.setEffect(null);
            }
            cancelButton.setVisible(false);
        }
        else if(abilityButton.isSelected()){
            ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
            ImageView playerPawns[] = {nextPlayer,nextPlayer2,nextPlayer3};
            navigatorPawnChoosen = false;

            for(ImageView im : imageViews){
                im.setEffect(null);
            }
            for(ImageView p: playerPawns){
                p.setEffect(null);
            }
            removePawns();
            navigatorChoosenPlayer.setActivePawn("pawn");
            drawPawns();
            navigatorChoosenPlayer = null;
            cancelButton.setVisible(false);
        }
    }

    public void useHelicopterLift(int[] pos) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        int count = 0;
        for(Player p : GameState.allPlayers)
            if(GameState.posMap.get(Arrays.toString(p.getPos())).equals("FoolsLanding")) count++;
        if(count == GameState.numPlayers)  {
            Stage win = new Stage();
            FXMLLoader menuLoader = new FXMLLoader(GameRunner.class.getResource("victcory.fxml"));
            win.setTitle("Congratulations");
            Scene winScene = null;
            try {
                winScene = new Scene(menuLoader.load(), 600, 800);
            } catch(IOException e) {
                e.printStackTrace();
            }
            win.setScene(winScene);
            win.setResizable(false);
            winScene.getStylesheets().add("moderna-darl.css");
            ParentPanel.setVictoryPanel(win);
        }
        if(useHelicopter){
            GameState.allPlayers.get(useCardPlayer).setPosition(pos);
            removePawns();
            if(GameState.currentPlayer.equals(GameState.allPlayers.get(useCardPlayer))) GameState.currentPlayer.setActivePawn("active");
            GameState.allPlayers.get(useCardPlayer).setActivePawn("pawn");
            drawPawns();
            ImageView pawn = GameState.allPlayers.get(useCardPlayer).getCurrentPawn();
            pawn.setFitWidth(34);
            pawn.setFitHeight(50);
            GameState.allPlayers.get(useCardPlayer).getCurrentTile().getChildren().remove(pawn);
            GameState.allPlayers.get(useCardPlayer).setCurrentTile(gridMap.get(Arrays.toString(pos)));
            GameState.allPlayers.get(useCardPlayer).getCurrentTile().add(pawn,GameState.allPlayers.get(useCardPlayer).getIndex(),0,1,1);

            for (ImageView im : imageViews)
                im.setEffect(null);
            useButton.setSelected(false);
            cancelButton.setVisible(false);

            System.out.println(GameState.allPlayers.get(useCardPlayer).getDeck());
            GameState.allPlayers.get(useCardPlayer).getDeck().remove("HelicopterLift");
            updateCards();

            ImageView[][] cards = {
                    {Player1Card1,Player1Card2,Player1Card3,Player1Card4,Player1Card5},
                    {Player2Card1,Player2Card2,Player2Card3,Player2Card4,Player2Card5},
                    {Player3Card1,Player3Card2,Player3Card3,Player3Card4,Player3Card5},
                    {Player4Card1,Player4Card2,Player4Card3,Player4Card4,Player4Card5}
            };
            for(int i = 0; i < cards.length; i++){
                for(int j = 0; j < cards[i].length; j++){
                    cards[i][j].setEffect(null);
                }
            }

            useHelicopter = false;
            useCardPlayer = -1;
        }
    }

    void updateActionCounter(){
        Circle[] circles = {action1,action2,action3};
        for(int i = 0; i < GameState.currentPlayer.getMoveNumber(); i++){
            circles[i].setFill(Color.rgb(142,208,85));
        }
    }

    void resetActionCounter(){
        Circle[] circles = {action1,action2,action3};
        for(int i = 0; i < 3; i++){
            circles[i].setFill(Color.rgb(221,84,84));
        }
    }

    public void abilityButtonClicked(MouseEvent mouseEvent) {
        if(abilityButton.isSelected()){
            actionUsedText.setTranslateY(-21);
            action1.setTranslateY(-21);
            action2.setTranslateY(-21);
            action3.setTranslateY(-21);
            ImageView playerPawns[] = {nextPlayer,nextPlayer2,nextPlayer3};
            choosePlayerText.setVisible(true);

            Player players[] = new Player[GameState.numPlayers -1];
            int index = 0;
            for(int i = 0; i < GameState.numPlayers; i++){
                if(GameState.allPlayers.get(i).equals(GameState.currentPlayer)) System.out.println(i);
                else {
                    System.out.println(i);
                    players[index] = GameState.allPlayers.get(i);
                    index++;
                }
            }

            for(int i = 0; i < players.length; i++){
                playerPawns[i].setVisible(true);
                playerPawns[i].setImage(players[i].getPawn());
            }

        }else{
            actionUsedText.setTranslateY(42);
            action1.setTranslateY(42);
            action2.setTranslateY(42);
            action3.setTranslateY(42);
            cancelButton.setVisible(false);

            choosePlayerText.setVisible(false);
            nextPlayer.setVisible(false);
            nextPlayer2.setVisible(false);
            nextPlayer3.setVisible(false);

            ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
            for(ImageView im: imageViews){
                im.setEffect(null);
            }
            ImageView playerPawns[] = {nextPlayer,nextPlayer2,nextPlayer3};
            for(ImageView p: playerPawns){
                p.setEffect(null);
            }

        }
    }

    private boolean navigatorPawnChoosen;
    private Player navigatorChoosenPlayer;
    void navigatorPawnChosen(int x) throws FileNotFoundException {
        if(abilityButton.isSelected() && !navigatorPawnChoosen){
            navigatorPawnChoosen = true;
            ImageView playerPawns[] = {nextPlayer,nextPlayer2,nextPlayer3};
            DropShadow highlight = new DropShadow();
            highlight.setColor(Color.YELLOW);
            playerPawns[x].setEffect(highlight);
            Player players[] = new Player[GameState.numPlayers -1];
            int index = 0;
            for(int i = 0; i < GameState.numPlayers; i++){
                if(GameState.allPlayers.get(i).equals(GameState.currentPlayer)) continue;
                else {
                    players[index] = GameState.allPlayers.get(i);
                    index++;
                }
            }
            navigatorChoosenPlayer = players[x];
            removePawns();
            navigatorChoosenPlayer.setActivePawn("move");
            drawPawns();

            DropShadow dropShadow = new DropShadow();
            dropShadow.setHeight(5.0);
            dropShadow.setColor(Color.GREEN);
            dropShadow.setWidth(5.0);
            dropShadow.setSpread(1.0);
            ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
            boolean navigableTiles[][] = players[x].getNavigableTile();
            int iu = 0;
            Image imagee = new Image(new FileInputStream("/Images/Tiles/extra/Tile_Movement_Icon@2x.png"));
            for(int r = 0; r < 6; r++){
                for(int c = 0; c < 6; c++){
                    if(r == 0 && c == 0 || r == 0 && c == 1 || r == 0 && c == 4 || r == 0 && c == 5) continue;
                    else if(r == 1 && c == 0 || r == 1 && c == 5) continue;
                    else if(r == 4 && c == 0 || r == 4 && c == 5) continue;
                    else if(r == 5 && c == 0 || r == 5 && c == 1 || r == 5 && c == 4 || r == 5 && c == 5) continue;
                    else if(navigableTiles[r][c] == true){
                        imageViews[iu].setEffect(dropShadow);
                        iu++;
                    }else iu++;
                }
            }
            cancelButton.setVisible(true);
        }
    }

    public void useSandbag(int pos[]) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[]{r0c2,r0c3,r1c1,r1c2,r1c3,r1c4,r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r4c1,r4c2,r4c3,r4c4,r5c2,r5c3};
        if(useSandbag){
            GameState.posMap.get(Arrays.toString(pos)).setFlooded(false);
            updateTiles();

            for (ImageView im : imageViews)
                im.setEffect(null);
            useButton.setSelected(false);
            cancelButton.setVisible(false);



            ImageView[][] cards = {
                    {Player1Card1,Player1Card2,Player1Card3,Player1Card4,Player1Card5},
                    {Player2Card1,Player2Card2,Player2Card3,Player2Card4,Player2Card5},
                    {Player3Card1,Player3Card2,Player3Card3,Player3Card4,Player3Card5},
                    {Player4Card1,Player4Card2,Player4Card3,Player4Card4,Player4Card5}
            };
            for(int i = 0; i < cards.length; i++){
                for(int j = 0; j < cards[i].length; j++){
                    cards[i][j].setEffect(null);
                }
            }
            GameState.allPlayers.get(useCardPlayer).getDeck().remove("Sandbag");
            updateCards();
            useSandbag = false;
            useCardPlayer = -1;
        }
    }

    public void r0c2Clicked(MouseEvent mouseEvent){
        System.out.println("Row 0 Column 2 Clicked");
        try { movePawn(new int[]{0, 2}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }

    public void r0c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 0 Column 3 Clicked");
        try { movePawn(new int[]{0, 3}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r1c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 1 Clicked");
        try { movePawn(new int[]{1, 1}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r1c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 2 Clicked");
        try { movePawn(new int[]{1, 2}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r1c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 3 Clicked");
        try { movePawn(new int[]{1, 3}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r1c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 1 Column 4 Clicked");
        try { movePawn(new int[]{1, 4}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r2c0Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 0 Clicked");
        try { movePawn(new int[]{2, 0}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r2c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 1 Clicked");
        try { movePawn(new int[]{2, 1}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r2c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 2 Clicked");
        try { movePawn(new int[]{2, 2}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r2c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 3 Clicked");
        try { movePawn(new int[]{2, 3}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r2c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 4 Clicked");
        try { movePawn(new int[]{2, 4}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r2c5Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 2 Column 5 Clicked");
        try { movePawn(new int[]{2, 5}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r3c0Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 0 Clicked");
        try { movePawn(new int[]{3, 0}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r3c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 1 Clicked");
        try { movePawn(new int[]{3, 1}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r3c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 2 Clicked");
        try { movePawn(new int[]{3, 2}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r3c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 3 Clicked");
        try { movePawn(new int[]{3, 3}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r3c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 4 Clicked");
        try { movePawn(new int[]{3, 4}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r3c5Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 3 Column 5 Clicked");
        try { movePawn(new int[]{3, 5}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r4c1Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 1 Clicked");
        try { movePawn(new int[]{4, 1}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r4c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 2 Clicked");
        try { movePawn(new int[]{4, 2}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r4c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 3 Clicked");
        try { movePawn(new int[]{4, 3}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r4c4Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 4 Column 4 Clicked");
        try { movePawn(new int[]{4, 4}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r5c2Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 5 Column 2 Clicked");
        try { movePawn(new int[]{5, 2}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }
    public void r5c3Clicked(MouseEvent mouseEvent) {
        System.out.println("Row 5 Column 3 Clicked");
        try { movePawn(new int[]{5, 3}, mouseEvent);
        }catch (FileNotFoundException ignored){}
    }

    public void player1card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 1 Clicked");
        try{ cardClicked(1,1);
        }catch (FileNotFoundException ignored){}
    }
    public void player1card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 2 Clicked");
        try{ cardClicked(1,2);
        }catch (FileNotFoundException ignored){}
    }
    public void player1card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 3 Clicked");
        try{ cardClicked(1,3);
        }catch (FileNotFoundException ignored){}
    }
    public void player1card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 4 Clicked");
        try{ cardClicked(1,4);
        }catch (FileNotFoundException ignored){}
    }
    public void player1card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 1 Card 5 Clicked");
        try{ cardClicked(1,5);
        }catch (FileNotFoundException ignored){}
    }

    public void player2card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 1 Clicked");
        try{ cardClicked(2,1);
        }catch (FileNotFoundException ignored){}
    }
    public void player2card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 2 Clicked");
        try{ cardClicked(2,2);
        }catch (FileNotFoundException ignored){}
    }
    public void player2card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 3 Clicked");
        try{ cardClicked(2,3);
        }catch (FileNotFoundException ignored){}
    }
    public void player2card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 4 Clicked");
        try{ cardClicked(2,4);
        }catch (FileNotFoundException ignored){}
    }
    public void player2card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 2 Card 5 Clicked");
        try{ cardClicked(2,5);
        }catch (FileNotFoundException ignored){}
    }

    public void player3card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 1 Clicked");
        try{ cardClicked(3,1);
        }catch (FileNotFoundException ignored){}
    }
    public void player3card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 2 Clicked");
        try{ cardClicked(3,2);
        }catch (FileNotFoundException ignored){}
    }
    public void player3card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 3 Clicked");
        try{ cardClicked(3,3);
        }catch (FileNotFoundException ignored){}
    }
    public void player3card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 4 Clicked");
        try{ cardClicked(3,4);
        }catch (FileNotFoundException ignored){}
    }
    public void player3card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 3 Card 5 Clicked");
        try{ cardClicked(3,5);
        }catch (FileNotFoundException ignored){}
    }

    public void player4card1Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 1 Clicked");
        try{ cardClicked(4,1);
        }catch (FileNotFoundException ignored){}
    }
    public void player4card2Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 2 Clicked");
        try{ cardClicked(4,2);
        }catch (FileNotFoundException ignored){}
    }
    public void player4card3Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 3 Clicked");
        try{ cardClicked(4,3);
        }catch (FileNotFoundException ignored){}
    }
    public void player4card4Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 4 Clicked");
        try{ cardClicked(4,4);
        }catch (FileNotFoundException ignored){}
    }
    public void player4card5Clicked(MouseEvent mouseEvent){
        System.out.println("Player 4 Card 5 Clicked");
        try{ cardClicked(4,5);
        }catch (FileNotFoundException ignored){}
    }



    public void nextPlayerClicked(MouseEvent mouseEvent) throws FileNotFoundException {
        System.out.println("Player 1 Clicked");
        navigatorPawnChosen(0);
    }
    public void nextPlayer2Clicked(MouseEvent mouseEvent) throws FileNotFoundException {
        System.out.println("Player 2 Clicked");
        navigatorPawnChosen(1);
    }
    public void nextPlayer3Clicked(MouseEvent mouseEvent) throws FileNotFoundException {
        System.out.println("Player 3 Clicked");
        navigatorPawnChosen(2);
    }

    public void movePawn(int[] pos, MouseEvent mouseEvent) throws FileNotFoundException {
        if(useSandbag) useSandbag(pos);
        else if(useHelicopter) useHelicopterLift(pos);
        else if(moveButton.isSelected()){
            boolean[][] move = GameState.currentPlayer.getMoveableTiles(GameState.posMap.get(Arrays.toString(GameState.currentPlayer.getPos())));
            System.out.println(move[pos[0]][pos[1]]);
            if(GameState.currentPlayer.movePawn(pos)){
                ImageView pawn = GameState.currentPlayer.getCurrentPawn();
                pawn.setFitWidth(34);
                pawn.setFitHeight(50);
                GameState.currentPlayer.setPosition(pos);

                GameState.currentPlayer.getCurrentTile().getChildren().remove(pawn);
                GameState.currentPlayer.setCurrentTile(gridMap.get(Arrays.toString(pos)));
                GameState.currentPlayer.getCurrentTile().add(pawn,GameState.currentPlayer.getIndex(),0,1,1);

                moveButton.setSelected(false);
                moveClicked(mouseEvent);
                //GameState.actionsRemaining++;
                updateActionCounter();
            }
        }
        else if(shoreButton.isSelected()){
            if(GameState.currentPlayer.shoreUp(pos)){
                GameState.posMap.get(Arrays.toString(pos)).setFlooded(false);
                GameState.posMap.get(Arrays.toString(pos)).setGone(false);
                System.out.println(Arrays.deepToString(GameState.getCurrentState()));
                updateTiles();
                shoreButton.setSelected(false);
                shoreClicked(mouseEvent);
                //GameState.actionsRemaining++;
                updateActionCounter();
            }
        }
        else if(abilityButton.isSelected()){
            if(navigatorPawnChoosen){

                ImageView pawn = navigatorChoosenPlayer.getCurrentPawn();
                pawn.setFitWidth(34);
                pawn.setFitHeight(50);
                navigatorChoosenPlayer.setPosition(pos);

                navigatorChoosenPlayer.getCurrentTile().getChildren().remove(pawn);
                navigatorChoosenPlayer.setCurrentTile(gridMap.get(Arrays.toString(pos)));
                navigatorChoosenPlayer.getCurrentTile().add(pawn,GameState.currentPlayer.getIndex(),0,1,1);

                removePawns();
                navigatorChoosenPlayer.setActivePawn("pawn");
                drawPawns();

                navigatorPawnChoosen = false;
                abilityButton.setSelected(false);
                abilityButtonClicked(mouseEvent);
                //GameState.actionsRemaining++;
                updateActionCounter();
            }
        }
    }

}

