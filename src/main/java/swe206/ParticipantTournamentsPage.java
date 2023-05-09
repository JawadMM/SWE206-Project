package swe206;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParticipantTournamentsPage extends Scene {

  // private static Stage stage;
  public ParticipantTournamentsPage() {
    super(getScrollPane(), 1024, 768);
    // TournamentsPage.stage = stage;
    String css = this.getClass().getResource("style.css").toExternalForm();
    this.getStylesheets().add(css);
  }

  
  public static ScrollPane getScrollPane() {
    Tournament.loadTournaments();
    ScrollPane mainScrollPane = new ScrollPane();
    Label ongoingTournamentsLabel = new Label("Ongoing Tournaments");

    // Button addButton = new Button("Add Tournament");
    // addButton.setOnAction(event -> {
    //   Scene scene1 = new AddTournamentPage();
    //   // stage.setScene(scene1);
    //   App.getStage().setScene(scene1);
      
    // });

    HBox header = new HBox(ongoingTournamentsLabel);
    header.setSpacing(700);
    // HBox.setMargin(header, new Insets(20));

    VBox tournamentsVbox = new VBox(header);
    
    for (Tournament tournament: Tournament.ongoingTournaments) {
      // System.out.println(tournament);
      HBox card = tournamentCard(tournament);
      tournamentsVbox.getChildren().add(card);
    }
    
    VBox.setMargin(tournamentsVbox, new Insets(20, 20, 20, 20));
    mainScrollPane.setContent(tournamentsVbox);
    
    return mainScrollPane;
  
  }

  

  public static HBox tournamentCard(Tournament tournament) {

    Label tournamentNamLabel = new Label(tournament.getTournamentName());
    Label tournamentDateLabel = new Label(tournament.getDate());
    String teamsSizeString = Integer.toString(tournament.getTeamsSize());
    Label tournamentTeamsSizeLabel = new Label(teamsSizeString);

    
    
    HBox card = new HBox(tournamentNamLabel, tournamentDateLabel, tournamentTeamsSizeLabel);
    card.setSpacing(20);
    card.setOnMouseClicked(e -> {
      App.stage.setScene(new SpecificTournamentPage(tournament.getTournamentName(), tournament.getDate(), tournament.getTeamsSize(), tournament.getMatches()));
    });
    HBox.setMargin(card, new Insets(20));

    return card;
  }
}
