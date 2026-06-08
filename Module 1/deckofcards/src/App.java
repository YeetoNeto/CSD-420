/*
    Module Assignment 1.3, Noah McCarthy
    Shuffle cards using button events in JavaFX
*/

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        //Pull Images and add them to ImageView nodes
        Image card = new Image("file:" + System.getProperty("user.dir") +"/AssignmentCards/Cards/b2fv.png");
        // found System.getPropert through https://forums.oracle.com/ords/apexds/post/finding-a-file-using-file-path-folder-name-inside-a-java-pr-1373
        ImageView[] cardView = new ImageView[4];
        int x = 50;
        int y = 100;
        for (int i = 0; i < cardView.length; i++) {
            cardView[i] = new ImageView(card);
            cardView[i].setLayoutX(x);
            cardView[i].setLayoutY(y);
            x+= 100;
        }

        //Create button
        Button buttonRefresh = new Button("Shuffle");
        buttonRefresh.setLayoutX(210);
        buttonRefresh.setLayoutY(225);
        buttonRefresh.setOnAction(e -> { //lambda usage
            for (int i = 0; i < cardView.length; i++) {
                Image newCard = new Image("file:" + System.getProperty("user.dir") +"/AssignmentCards/Cards/" + (int)(Math.random() * 52 + 1) + ".png");
                cardView[i].setImage(newCard);
                // found System.getPropert through https://forums.oracle.com/ords/apexds/post/finding-a-file-using-file-path-folder-name-inside-a-java-pr-1373
            }
        });

        //Group nodes
        Group root = new Group();
        root.getChildren().addAll(cardView); //addAll adds entire array
        root.getChildren().add(buttonRefresh);
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}