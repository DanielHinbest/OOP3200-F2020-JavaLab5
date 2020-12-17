/* Program Name: OOP 3200 - Java Lab 5 - BMI Calculator
 * Authors: Ryan Clayson and Daniel Hinbest
 * Date: December 17, 2020
 * Description: A Calculator that acts as a BMI Calculator created using Javafx
 */
package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Sets the title
        primaryStage.setTitle("BMI Calculator");

        // Creates a new GridPane
        GridPane gridPane = new GridPane();

        // Creates a scene
        Scene scene = new Scene(gridPane, 400, 240);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Height Label/Textfield
        Label heightLabel = new Label("Height (m) ");
        TextField heightField = new TextField();

        // Weight Label/Textfield
        Label weightLabel = new Label("Weight (kg)");
        TextField weightField = new TextField();

        // Button to Calculate
        Button calculate = new Button("Calculate BMI");

        // BMI Calculation Label/Textfield
        Label bmiLabel = new Label("BMI");
        TextField bmiField = new TextField();

        // Button Logic to Calculate BMI
        class ButtonClickHandler implements EventHandler<ActionEvent>{
            @Override
            public void handle(ActionEvent event){
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());
                double BMI = Math.round(weight / (height * height));

                if (BMI < 18.5){
                    bmiField.setText(Double.toString(BMI) + "  - Underweight");
                }
                else if (BMI >= 18.5 && BMI <= 24.9){
                    bmiField.setText(Double.toString(BMI) + "  - Normal");
                }
                else if (BMI >= 25 && BMI <= 29.9){
                    bmiField.setText(Double.toString(BMI) + "  - Overweight");
                }
                else if (BMI >= 30){
                    bmiField.setText(Double.toString(BMI) + "  - Obese");
                }
            }
        }
        calculate.setOnAction(new ButtonClickHandler());

        // Container Creations for each label/textfield
        HBox heightBox = new HBox(10, heightLabel, heightField);
        HBox weightBox = new HBox(10, weightLabel, weightField);
        HBox calcBox = new HBox(10, calculate);
        HBox bmiBox = new HBox(10, bmiLabel, bmiField);

        // Styles
        heightBox.setStyle("-fx-alignment: center;");
        calcBox.setStyle("-fx-alignment: center;");
        weightBox.setStyle("-fx-alignment: center;");
        bmiBox.setStyle("-fx-alignment: center;");

        //Form Layout
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        // Adds all fields to the grid pane
        gridPane.add(heightBox, 0, 0);
        gridPane.add(weightBox,0,1);
        gridPane.add(calcBox, 0, 2);
        gridPane.add(bmiBox, 0, 3);
        gridPane.setStyle("-fx-font-size: 20");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
