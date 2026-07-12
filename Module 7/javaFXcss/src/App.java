/*
 MOdule 7.2 Assignment by Noah McCarthy
 create a javafx window and use a css style sheet to style the objects in it
*/

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class App extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 325, 300);
        scene.getStylesheets().add("mystyle.css"); // Add CSS sheet
        Circle circle1 = new Circle(50,150,25);
        Circle circle2 = new Circle(125,150,25);
        Circle circle3 = new Circle(200,150,25);
        Circle circle4 = new Circle(275,150,25);
        Rectangle rectangle = new Rectangle(20, 0, 60, 300);
        //Set Styles
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle"); 
        circle3.getStyleClass().add("plaincircle"); 
        circle4.getStyleClass().add("plaincircle");
        rectangle.getStyleClass().add("plainrectangle");
        //Set IDs for special circles
        circle3.setId("redcircle");
        circle4.setId("greencircle");
        // group it to present on stage
        Group group = new Group(rectangle, circle1,  circle2, circle3, circle4);
        scene.setRoot(group);
        stage.setTitle("Css Practice");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}