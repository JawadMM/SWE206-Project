package swe206;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    static ArrayList<Tournament> tournamentsList;
    static Stage stage;
    static Scene scene = new TournamentsPage();

    static BorderPane containter = new BorderPane();
    static final Label ONGOINGTOURNAMENTS_LABEL = new Label("Ongoing Tournaments");

    @Override
    public void start(Stage stage) throws IOException {

        String css = this.getClass().getResource("style.css").toExternalForm();

        App.stage = stage;
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
      return stage;
    }

}