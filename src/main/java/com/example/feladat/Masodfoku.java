package com.example.feladat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Masodfoku extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Másodfokú Egyenlet");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(7);
        grid.setVgap(7);

        TextField aField = new TextField();
        aField.setPromptText("a");
        GridPane.setConstraints(aField, 0, 0);

        Label aLabel = new Label("x^2 +");
        GridPane.setConstraints(aLabel, 1, 0);

        TextField bField = new TextField();
        bField.setPromptText("b");
        GridPane.setConstraints(bField, 2, 0);

        Label bLabel = new Label("x +");
        GridPane.setConstraints(bLabel, 3, 0);

        TextField cField = new TextField();
        cField.setPromptText("c");
        GridPane.setConstraints(cField, 4, 0);

        Label cLabel = new Label("= 0");
        GridPane.setConstraints(cLabel, 5, 0);

        Button solveButton = new Button("Számol");
        GridPane.setConstraints(solveButton, 2, 1);

        Label resultLabel = new Label("x1 = ");
        GridPane.setConstraints(resultLabel, 0, 2, 6, 1);

        grid.getChildren().addAll(aField, aLabel, bField, bLabel, cField, cLabel, solveButton, resultLabel);

        solveButton.setOnAction(e -> {
            try {
                if (aField.getText().isEmpty() || bField.getText().isEmpty() || cField.getText().isEmpty()) {
                    resultLabel.setText("Hiba: Minden mezőt ki kell tölteni!");
                    return;
                }

                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());

                if (a == 0) {
                    resultLabel.setText("Hiba: Az 'a' nem lehet nulla!");
                    return;
                }

                double discriminant = b * b - 4 * a * c;

                if (discriminant < 0) {
                    resultLabel.setText("Nem oldható meg a valós számok halmazán.");
                } else if (discriminant == 0) {
                    double x = -b / (2 * a);
                    resultLabel.setText("x1 = x2 = " + x);
                } else {
                    double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    resultLabel.setText("x1 = " + x1 + ", x2 = " + x2);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Hiba: Csak számokat adjon meg!");
            }
        });

        Scene scene = new Scene(grid, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

