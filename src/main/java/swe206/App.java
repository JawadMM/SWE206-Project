package swe206;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        String css = this.getClass().getResource("style.css").toExternalForm();
        Pane p = LoginPage.LoginPage();

        scene = new Scene(p, 640, 480);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    // static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

//     public static VBox LoginPage() {

//     VBox p = new VBox();

//     Label nameLabel = new Label("Enter your name");
//     nameLabel.getStyleClass().add("label");
//     TextField nameTextField = new TextField();

//     VBox nameVBox = new VBox(nameLabel, nameTextField);
    
//     p.getChildren().addAll(nameVBox);
    
//     System.out.println(p.getClass());
//     p.setId("test");
    
//     p.getStyleClass().add("vbox");
//     return p;
//   }

}