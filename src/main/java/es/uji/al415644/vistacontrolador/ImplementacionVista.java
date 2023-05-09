package es.uji.al415644.vistacontrolador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ImplementacionVista extends Application {
    public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            Label recommendationLabel = new Label("Recommendation Type:");
            ComboBox<String> recommendationComboBox = new ComboBox<>();
            recommendationComboBox.getItems().addAll("Recommended based on song features", "Recommended based on guessed genre");
            recommendationComboBox.getSelectionModel().selectFirst();

            Label distanceLabel = new Label("Distance Type:");
            ComboBox<String> distanceComboBox = new ComboBox<>();
            distanceComboBox.getItems().addAll("Euclidean", "Manhattan");
            distanceComboBox.getSelectionModel().selectFirst();

            Label songTitleLabel = new Label("Song Titles:");
            ListView<String> songTitleListView = new ListView<>();
            songTitleListView.getItems().addAll(
                    "Song 1", "Song 2", "Song 3", "Song 4", "Song 5", "Song 6", "Song 7", "Song 8", "Song 9", "Song 10",
                    "Song 11", "Song 12", "Song 13", "Song 14", "Song 15", "Song 16", "Song 17", "Song 18", "Song 19", "Song 20"
            );

            // Create the layout
            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(10));
            gridPane.addRow(0, recommendationLabel, recommendationComboBox);
            gridPane.addRow(1, distanceLabel, distanceComboBox);
            gridPane.addRow(2, songTitleLabel);
            gridPane.add(songTitleListView, 0, 3, 2, 1);
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(40);
            ColumnConstraints column2 = new ColumnConstraints();
            column2.setPercentWidth(60);
            gridPane.getColumnConstraints().addAll(column1, column2);

            // Create the scene
            Scene scene = new Scene(gridPane, 400, 300);

            // Set the stage
            primaryStage.setTitle("Song Recommendation App");
            primaryStage.setScene(scene);

        }
    }

