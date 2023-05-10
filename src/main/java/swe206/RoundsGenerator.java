package swe206;

import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoundsGenerator extends Application {

    private ArrayList<Team> teams;
    private int numTeams;
    private int numRounds;
    private int teamsPerRound;
    private int currentRound;
    private ArrayList<Match> matches;
    private int currentMatch;

    private Label headerLabel;
    private Label matchLabel;
    private Label team1Label;
    private Label team2Label;
    private RadioButton team1Button;
    private RadioButton team2Button;
    private Button nextButton;

    public void start(Stage primaryStage) {
        teams = new ArrayList<Team>();
        teams.add(new Team("Team 1"));
        teams.add(new Team("Team 2"));
        teams.add(new Team("Team 3"));
        teams.add(new Team("Team 4"));
        teams.add(new Team("Team 5"));
        teams.add(new Team("Team 6"));
        teams.add(new Team("Team 7"));
        teams.add(new Team("Team 8"));
    
        numTeams = teams.size();
        numRounds = (int) ((int) Math.log(numTeams) / Math.log(2));
        teamsPerRound = numTeams;
        currentRound = 1;
        matches = new ArrayList<Match>();
        currentMatch = 0;
    
        for (int i = 0; i < numRounds; i++) {
            teamsPerRound /= 2;
            for (int j = 0; j < teamsPerRound; j++) {
                Team team1 = teams.get(j);
                Team team2 = teams.get(numTeams-j-1);
                matches.add(new Match(team1, team2));
            }
            numTeams /= 2;
        }
    
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
    
        int row = 0;
        int col = 0;
    
        for (int i = 0; i < matches.size(); i++) {
            Match match = matches.get(i);
            Label team1Label = new Label(match.getTeam1().getTeamName());
            Label team2Label = new Label(match.getTeam2().getTeamName());
            RadioButton team1Button = new RadioButton();
            RadioButton team2Button = new RadioButton();
            ToggleGroup toggleGroup = new ToggleGroup();
            team1Button.setToggleGroup(toggleGroup);
            team2Button.setToggleGroup(toggleGroup);
            HBox matchBox = new HBox(10);
            matchBox.setAlignment(Pos.CENTER);
            matchBox.getChildren().addAll(team1Label, new Label("vs."), team2Label, team1Button, team2Button);
            gridPane.add(matchBox, col, row);
    
            col++;
            if (col >= Math.pow(2, numRounds - currentRound)) {
                row++;
                col = 0;
            }
        }
    
        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> {
            if (team1Button.isSelected()) {
                matches.get(currentMatch).setWinner(matches.get(currentMatch).getTeam1());
            } else if (team2Button.isSelected()) {
                matches.get(currentMatch).setWinner(matches.get(currentMatch).getTeam2());
            }
    
            currentMatch++;
            if (currentMatch >= matches.size()) {
                currentRound++;
                if (currentRound > numRounds) {
                    showWinner();
                } else {
                    teamsPerRound /= 2;
                    numTeams = teamsPerRound;
                    for (int i = 0; i < numRounds - currentRound; i++) {
                        numTeams *= 2;
                    }
                    currentMatch = 0;
                    matches = new ArrayList<Match>();
                    for (int i = 0; i < teamsPerRound; i++) {
                        Team team1 = teams.get(i);
                        Team team2 = teams.get(numTeams-i-1);
                        matches.add(new Match(team1, team2));
                    }
                    gridPane.getChildren().clear();
                    
                    int row1 = 0;
                    int col1 = 0;
                    for (int i = 0; i < matches.size(); i++) {
                        Match match = matches.get(i);
                        Label team1Label = new Label(match.getTeam1().getTeamName());
                        Label team2Label = new Label(match.getTeam2().getTeamName());
                        RadioButton team1Button = new RadioButton();
                        RadioButton team2Button = new RadioButton();
                        ToggleGroup toggleGroup = new ToggleGroup();
                        team1Button.setToggleGroup(toggleGroup);
                        team2Button.setToggleGroup(toggleGroup);
                        HBox matchBox = new HBox(10);
                        matchBox.setAlignment(Pos.CENTER);
                        matchBox.getChildren().addAll(team1Label, new Label("vs."), team2Label, team1Button, team2Button);
                        gridPane.add(matchBox, col1, row1);
    
                        col1++;
                        if (col1 >= Math.pow(2, numRounds - currentRound)) {
                            row1++;
                            col1 = 0;
                        }
                    }
                }
            }
        });
    
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(gridPane, nextButton);
    
        Scene scene = new Scene(vbox);
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void updateHeader(String text) {
        headerLabel.setText(text);
    }

    private void updateMatch() {
        Match match = matches.get(currentMatch);
        team1Label.setText(match.getTeam1().getTeamName());
        team2Label.setText(match.getTeam2().getTeamName());
        matchLabel.setText("Match " + (currentMatch+1) + " of " + matches.size());
        team1Button.setSelected(false);
        team2Button.setSelected(false);
    }

       public static void main(String[] args) {
        launch(args);
    }

    public void showWinner() {
        Map<Team, Integer> teamWins = new HashMap<>();
        for (Match match : matches) {
            Team winner = match.getWinner();
            if (teamWins.containsKey(winner)) {
                teamWins.put(winner, teamWins.get(winner) + 1);
            } else {
                teamWins.put(winner, 1);
            }
        }
    
        Team winner = null;
        int maxWins = 0;
        for (Team team : teamWins.keySet()) {
            int wins = teamWins.get(team);
            if (wins > maxWins) {
                winner = team;
                maxWins = wins;
            }
        }
    
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Tournament Winner");
        alert.setHeaderText("The winner of the tournament is:");
        alert.setContentText(winner.getTeamName());
        alert.showAndWait();
    }
}