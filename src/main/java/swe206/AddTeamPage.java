package swe206;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddTeamPage extends Scene {
 
  public AddTeamPage(Tournament tournament) {
    super(getMainPane(tournament), 1024, 768);
    String css = this.getClass().getResource("style.css").toExternalForm();
    this.getStylesheets().add(css);
  }

  public static VBox getMainPane(Tournament tournament) {
    VBox mainBox = new VBox();

    Label enterTeam1Name = new Label("Enter Team1 Name");
    TextField  team1TextField = new TextField();
    VBox team1VBox = new VBox(enterTeam1Name, team1TextField);

    Label enterTeam2Name = new Label("Enter Team2 Name");
    TextField  team2TextField = new TextField();
    VBox team2VBox = new VBox(enterTeam2Name, team2TextField);

    
    Button addTeam = new Button("Add Team");
    

    addTeam.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        String team1Name = team1TextField.getText();
        String team2Name = team2TextField.getText();

        Team team1 = new Team(team1Name);
        tournament.getTeams().add(team1);

        Team team2 = new Team(team2Name);
        tournament.getTeams().add(team2);
        Tournament.saveTournaments();

        // Tournament.saveTournaments();
        // App.stage.setScene(scene);
        App.stage.setScene(new SpecificTournamentPage(tournament));
      }});
      mainBox.getChildren().addAll(team1VBox, team2VBox, addTeam);

    return mainBox;
  }
}
