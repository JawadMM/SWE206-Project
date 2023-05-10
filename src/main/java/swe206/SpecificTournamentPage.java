package swe206;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

  public static FlowPane getMainPane(Tournament tournament) {
    VBox mainVBox = new VBox();
    mainVBox.setPrefSize(1024, 768);

    HBox header = new HBox();

    Button backButton = new Button("Back");
backButton.setOnAction(new EventHandler<ActionEvent>() {
  
  @Override
  public void handle(ActionEvent arg0) {
    App.getStage().setScene(scene);
  }
  
});

    Label tournamentNameLabel = new Label(tournament.getTournamentName());
    header.getChildren().addAll(backButton, tournamentNameLabel);
    header.setSpacing(500);

    mainVBox.getChildren().add(header);
    
    ArrayList<VBox> matches = new ArrayList<>();
    for(Match match: tournament.getMatches()) {
      VBox card = matchCard(match);
      // mainVBox.getChildren().add(card);
      matches.add(card);
    }

    GridPane table = eliminationTable(matches, tournament);

    FlowPane mainPane = new FlowPane();

    mainPane.getChildren().addAll(header, table);

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
