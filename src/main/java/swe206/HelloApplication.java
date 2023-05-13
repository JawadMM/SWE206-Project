package swe206;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private TextField username = new TextField();
    private TextField password = new TextField();
    private Button Login = new Button("Login");
    static Scene trntmnts = new TournamentsPage();
    static Stage stage;
    

    @Override
    public void start(Stage stage) throws IOException {
        // Login Page -ALI ALNASSIR
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Username: "),0,0);
        gridPane.add(username,1,0);
        gridPane.add(new Label("Password: "),0,1);
        gridPane.add(password,1,1);
        gridPane.add(Login,1,2);
        gridPane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(Login, HPos.RIGHT);
        Login.setOnAction(e -> { System.out.println(Validate());

        HelloApplication.stage = stage;
        stage.setScene(trntmnts);});

        // Scene

        Scene scene = new Scene(gridPane,1024,768);
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Tournament");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public String Validate() {
        ArrayList<Participant> participants = ReadParticipants.reader("/Users/zac/Desktop/Universty/Term 222/SWE206/SWE206-Project/src/main/java/swe206/StudentDetails.csv");
        ArrayList<Admin> admins = ReadAdmins.reader("/Users/zac/Desktop/Universty/Term 222/SWE206/SWE206-Project/src/main/java/swe206/AdminDetails.csv");
            for(int i = 0; i< participants.size();i++){
               if ((username.getText()).equals(participants.get(i).getUsername()) && ((password.getText()).equals(participants.get(i).getPassword()))) {
                  return "participant"; }
            }
            for(int i = 0; i< admins.size();i++) {
                if ((username.getText()).equals(admins.get(i).getUsername()) && ((password.getText()).equals(admins.get(i).getpasswoed()))) {
                    return "admin"; }
            }
            return "None";
    }
}
