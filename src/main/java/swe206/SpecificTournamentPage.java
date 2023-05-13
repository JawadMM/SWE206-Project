package swe206;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SpecificTournamentPage extends Scene {
  public static Scene scene = new TournamentsPage();

  // public SpecificTournamentPage(String tournamentName, String tournamentDate, int tournamentTeamSize, ArrayList<Match> matches) {
  public SpecificTournamentPage(Tournament tournament) {
    super(getMainPane(tournament), 1024, 768);
    String css = this.getClass().getResource("style.css").toExternalForm();
    this.getStylesheets().add(css);
  }

  public static VBox getMainPane(Tournament tournament) {
    VBox mainVBox = new VBox();
    mainVBox.setPrefSize(1024, 768);

    HBox header = new HBox();

    Button backButton = new Button("Back");
    backButton.setOnAction(new EventHandler<ActionEvent>() {
  
    @Override
    public void handle(ActionEvent arg0) {
      HelloApplication.stage.setScene(scene);
    }
  
  });

  Button addTeambButton = new Button("Add Team");

  addTeambButton.setOnAction(new EventHandler<ActionEvent>() {
  
    @Override
    public void handle(ActionEvent arg0) {
      HelloApplication.stage.setScene(new AddTeamPage(tournament));
    }
  
  });


    Label tournamentNameLabel = new Label(tournament.getTournamentName());
    header.getChildren().addAll(backButton, tournamentNameLabel, addTeambButton);
    header.setSpacing(300);

    mainVBox.getChildren().add(header);
    
    // ArrayList<VBox> matches = new ArrayList<>();
    // for(Match match: tournament.getMatches()) {
    //   VBox card = matchCard(match);
    //   // mainVBox.getChildren().add(card);
    //   matches.add(card);
    // }

    // GridPane table = eliminationTable(matches, tournament);

    VBox mainPane = new VBox();

    VBox table2 = eliminationBox(tournament);

    mainPane.getChildren().addAll(header, table2);

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


  public static VBox eliminationBox(Tournament tournament) {
    VBox mainBox = new VBox();

    Label lost = new Label("LostTeams:");
    HBox lostTeams = new HBox();
    VBox lostBox = new VBox(lost, lostTeams);

    Label current = new Label("Current Match:");
    HBox currnetMatch = new HBox();
    VBox currentBox = new VBox(current, currnetMatch);

    Label upcoming = new Label("Upcoming teams:");
    HBox upcomingTeams = new HBox();
    VBox upcomingBox = new VBox(upcoming, upcomingTeams);

    ArrayList<Team> teams = tournament.getTeams();

    if (tournament.getTeams().size() > 0) {
      for (int i = 0; i < teams.size(); i++) {
        // Team team = teams.get(i);
        
        if (i == 0) {
          Match match = new Match(teams.get(i), teams.get(i + 1));
          Label firstTeam = new Label(match.getTeam1().getTeamName());
          Label vs = new Label("VS");
          Label secondTeam = new Label(match.getTeam2().getTeamName());
  
          currnetMatch.getChildren().addAll(firstTeam, vs, secondTeam);
          currnetMatch.setSpacing(20);

          firstTeam.setOnMouseClicked(e -> {
            match.setWinner(match.getTeam1());
            lostTeams.getChildren().add(secondTeam);

            Team newTeam = new Team(((Labeled) upcomingTeams.getChildren().get(0)).getText());
            upcomingTeams.getChildren().remove(0);
            match.setTeam2(newTeam);
            
            Label newLabel = new Label(newTeam.getTeamName());
            firstTeam.setLabelFor(newLabel);
            currnetMatch.getChildren().add(newLabel);
          });

          
          secondTeam.setOnMouseClicked(e -> {
            match.setWinner(match.getTeam2());
            lostTeams.getChildren().add(firstTeam);

            Team newTeam = new Team(((Labeled) upcomingTeams.getChildren().get(0)).getText());
            upcomingTeams.getChildren().remove(0);
            match.setTeam2(newTeam);
            
            // currnetMatch.getChildren().add(0, new Label(newTeam.getTeamName()));
            Label newLabel = new Label(newTeam.getTeamName());
            secondTeam.setLabelFor(newLabel);
            currnetMatch.getChildren().add(0, newLabel);
          });

        }

        else if (i != 1) {
          Label nextTeam = new Label(teams.get(i).getTeamName());
          upcomingTeams.getChildren().add(nextTeam);
        }
      }
    }

    mainBox.getChildren().addAll(lostBox, currentBox, upcomingBox);

    return mainBox;
  }


  // public static GridPane eliminationTable(ArrayList<VBox> cards, Tournament tournament) {
  //   GridPane gridPane = new GridPane();

  //   int num_rows = (int) Tournament.tournamentDuratuion(tournament.getStartDate(), tournament.getEndDate());
  //   // int num_columns = tournament.getMatches().size();
  //   int[] num_columns = Tournament.distributeEliminationMatches(tournament.getTeams().size());
  //   for (int row = 0; row < num_rows; row++) {
  //     for (int col = 0; col < num_columns[0]; col++) {
  //       // Add content to each cell in the grid
  //       // For example, you can add a label or a button
  //       gridPane.add(new Label("Row " + row + ", Column " + col), col, row);
  //     }
  //   }

  //   gridPane.setHgap(20);
  //   gridPane.setVgap(20);

  //   return gridPane;
  // }

  public static GridPane eliminationTable(ArrayList<VBox> cards, Tournament tournament) {
    GridPane gridPane = new GridPane();
    // GridPane subGridPane = new GridPane();  

    // int num_col = (int) Tournament.tournamentDuratuion(tournament.getStartDate(), tournament.getEndDate());
    // int num_columns = tournament.getMatches().size();
    int num_col = tournament.distributeEliminationMatches(tournament.getTeams().size()).length;
    int[] num_rows = Tournament.distributeEliminationMatches(tournament.getTeams().size());
    System.out.println(Arrays.toString(num_rows));
    for (int col = 0; col < num_col; col++) {
      GridPane subGridPane = new GridPane();
      for (int index = 0; index < num_rows[col]; ++index) {
        for (int row = 0; row < num_rows.length; row++) {
          subGridPane.add(new Label("Col " + col + " Row " + index), col, index);
        }
      }
      subGridPane.setGridLinesVisible(true);
      gridPane.add(subGridPane, col, 0);
    }

    // for (int col = 0; col < num_columns[0]; col++) {
    //   GridPane subGridPane = new GridPane();
    //   // Add content to each cell in the grid
    //   // For example, you can add a label or a button
    //   subGridPane.add(new Label("Col " + col), row, col);
    //   gridPane.add(subGridPane, col, row);
    // }

    gridPane.setHgap(20);
    gridPane.setVgap(20);

    return gridPane;
  }

  
}
