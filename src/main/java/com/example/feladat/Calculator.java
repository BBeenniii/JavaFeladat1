package com.example.feladat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Szamologep");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField num1Field = new TextField();
        num1Field.setPromptText("Első szam");
        GridPane.setConstraints(num1Field, 0, 0);

        TextField num2Field = new TextField();
        num2Field.setPromptText("Masodik szam");
        GridPane.setConstraints(num2Field, 1, 0);

        // Buttons
        Button addButton = new Button("+");
        GridPane.setConstraints(addButton, 0, 1);

        Button subtractButton = new Button("-");
        GridPane.setConstraints(subtractButton, 1, 1);

        Button multiplyButton = new Button("*");
        GridPane.setConstraints(multiplyButton, 0, 2);

        Button divideButton = new Button("/");
        GridPane.setConstraints(divideButton, 1, 2);

        Button modulusButton = new Button("%");
        GridPane.setConstraints(modulusButton, 0, 3);

        // Result label
        Label resultLabel = new Label("Eredmeny: ");
        GridPane.setConstraints(resultLabel, 0, 4, 2, 1);

        // Add elements to the grid
        grid.getChildren().addAll(num1Field, num2Field, addButton, subtractButton, multiplyButton, divideButton, modulusButton, resultLabel);

        // Button actions
        addButton.setOnAction(e -> {
            calculate(num1Field, num2Field, resultLabel, "add");
        });

        subtractButton.setOnAction(e -> {
            calculate(num1Field, num2Field, resultLabel, "subtract");
        });

        multiplyButton.setOnAction(e -> {
            calculate(num1Field, num2Field, resultLabel, "multiply");
        });

        divideButton.setOnAction(e -> {
            calculate(num1Field, num2Field, resultLabel, "divide");
        });

        modulusButton.setOnAction(e -> {
            calculate(num1Field, num2Field, resultLabel, "modulus");
        });

        // Scene setup
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(TextField num1Field, TextField num2Field, Label resultLabel, String operation) {
        try {
            if (num1Field.getText().isEmpty() || num2Field.getText().isEmpty()) {
                resultLabel.setText("Hiba: Mindket mezot ki kell tolteni!");
                return;
            }

            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            double result = 0;
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    if (num2 == 0) {
                        resultLabel.setText("Hiba: 0-val valo osztas!");
                        return;
                    }
                    result = num1 / num2;
                    break;
                case "modulus":
                    result = num1 % num2;
                    break;
            }

            resultLabel.setText("Eredmeny: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Hiba: nem megfelelo szamformatum");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
