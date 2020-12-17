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
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Java Lab 5");

        GridPane gridPane = new GridPane();

        Scene scene = new Scene(gridPane, 400, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

        Label heightLabel = new Label("Height (m) ");
        Label weightLabel = new Label("Weight (kg)");

        TextField heightField = new TextField();
        TextField weightField = new TextField();

        Button calculate = new Button("Calculate BMI");

        Label bmiLabel = new Label("BMI");
        TextField bmiField = new TextField();

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

        HBox heightBox = new HBox(10, heightLabel, heightField);
        HBox weightBox = new HBox(10, weightLabel, weightField);
        HBox bmiBox = new HBox(10, bmiLabel, bmiField);

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        calculate.setAlignment(Pos.CENTER);

        gridPane.add(heightBox, 0, 0);
        gridPane.add(weightBox,0,1);
        gridPane.add(calculate, 0, 2);
        gridPane.add(bmiBox, 0, 3);
        gridPane.setStyle("-fx-font-size: 20");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
