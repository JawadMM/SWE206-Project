package swe206;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SpecificTournamentPage extends Scene {
  
  public SpecificTournamentPage(String tournamentName, String tournamentDate, int tournamentTeamSize, ArrayList<Match> matches) {
    super(getMainPane(tournamentName, tournamentDate, tournamentTeamSize, matches), 1024, 768);
    String css = this.getClass().getResource("style.css").toExternalForm();
    this.getStylesheets().add(css);
  }

  public static VBox getMainPane(String tournamentName, String tournamentDate, int tournamentTeamSize, ArrayList<Match> matches) {
    VBox mainPane = new VBox();
    mainPane.setPrefSize(1024, 768);

    HBox header = new HBox();
    Button backButton = new Button("Back");
    Label tournamentNameLabel = new Label(tournamentName);
    header.getChildren().addAll(backButton, tournamentNameLabel);
    header.setSpacing(500);

    
    for(Match match: matches) {
      VBox card = matchCard(match);
      mainPane.getChildren().add(card);
    }


    mainPane.getChildren().add(header);

    return mainPane;
  }

  public static VBox matchCard(Match match) {
    VBox card = new VBox();
    
    HBox team1HBox = new HBox();
    Label team1Name = new Label(match.getTeam1().getTeamName());
    Label team1Score = new Label(Integer.toString((match.getTeam1().getScore())));
    team1HBox.getChildren().addAll(team1Name,team1Score);
    team1HBox.setSpacing(50);
    
    HBox team2HBox = new HBox();
    Label team2Name = new Label(match.getTeam2().getTeamName());
    Label team2Score = new Label(Integer.toString((match.getTeam2().getScore())));
    team2HBox.getChildren().addAll(team2Name,team2Score);
    team2HBox.setSpacing(50);

    card.getChildren().addAll(team1HBox, team2HBox);
    card.setSpacing(30);

    return card;
  }


}
