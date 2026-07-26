package com.mycompany.mod10.assignment;

/*
    Module Assignment 10.2, Noah McCarthy
    Use javafx to make a GUI that works with a database
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class App extends Application {

    @Override
    public void start(Stage stage) {
        String url = "jdbc:mysql://localhost:3306/databasedb";
        String user = "student1";
        String password = "pass";
        //Create Label
        Label updateLab = new Label("");
        updateLab.setLayoutX(150);
        updateLab.setLayoutY(25);
        Label label = new Label("Enter ID:");
        label.setLayoutX(10);
        label.setLayoutY(50);
        Label label2 = new Label("First Name:");
        label2.setLayoutX(10);
        label2.setLayoutY(100);
        Label label3 = new Label("Last Name:");
        label3.setLayoutX(10);
        label3.setLayoutY(150);
        Label label4 = new Label("Favorite Team:");
        label4.setLayoutX(10);
        label4.setLayoutY(200);
        //Create TextField
        TextField textFieldID = new TextField();
        textFieldID.setLayoutX(100);
        textFieldID.setLayoutY(50);
        TextField textFieldFirstName = new TextField();
        textFieldFirstName.setLayoutX(100); 
        textFieldFirstName.setLayoutY(100);
        TextField textFieldLastName = new TextField();
        textFieldLastName.setLayoutX(100);
        textFieldLastName.setLayoutY(150);
        TextField textFieldFavoriteTeam = new TextField();
        textFieldFavoriteTeam.setLayoutX(100);
        textFieldFavoriteTeam.setLayoutY(200);
        //Create button
        Button buttonDisplay = new Button("Display");
        buttonDisplay.setLayoutX(180);
        buttonDisplay.setLayoutY(270);
        buttonDisplay.setOnAction(displayEvent -> { //lambda usage
            try  {
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM fans WHERE id = ?");
                
                    int id = Integer.parseInt(textFieldID.getText());
                    statement.setInt(1, id);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                    
                    textFieldFirstName.setText(rs.getString("first_name"));
                    textFieldLastName.setText(rs.getString("last_name"));
                    textFieldFavoriteTeam.setText(rs.getString("favorite_team"));
                } 
                
                  
                conn.close();
            } 
            catch (NumberFormatException numbahex)
                {
                    updateLab.setText("Error: Id out of bounds");
                }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Button buttonUpdate = new Button("Update");
        buttonUpdate.setLayoutX(250);
        buttonUpdate.setLayoutY(270);
        buttonUpdate.setOnAction(updateEvent -> { //lambda usage
             try  {
                Connection conn = DriverManager.getConnection(url, user, password);              
                String firstName = textFieldFirstName.getText();
                String lastName = textFieldLastName.getText();
                String favTeam = textFieldFavoriteTeam.getText();
                PreparedStatement statement = conn.prepareStatement("UPDATE fans SET first_name = ?, last_name = ?, favorite_team = ? WHERE id = ?");
                
                    int id = Integer.parseInt(textFieldID.getText());
                    statement.setString(1, firstName);
                    statement.setString(2, lastName);
                    statement.setString(3, favTeam);
                    statement.setInt(4, id);
                    statement.executeUpdate();
                    updateLab.setText("Database ID: " + id + ", has been Updated.");
                
                
                conn.close();
            }
             catch (NumberFormatException numbahex)
                {
                    updateLab.setText("Error: Id out of bounds");
                }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        //Group nodes
        Group root = new Group();
        root.getChildren().add(buttonUpdate);
        root.getChildren().add(buttonDisplay);
        root.getChildren().add(label);
        root.getChildren().add(label2);
        root.getChildren().add(label3);
        root.getChildren().add(label4);
        root.getChildren().add(textFieldID);
        root.getChildren().add(textFieldFirstName); 
        root.getChildren().add(textFieldLastName);
        root.getChildren().add(textFieldFavoriteTeam);
        root.getChildren().add(updateLab);
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}