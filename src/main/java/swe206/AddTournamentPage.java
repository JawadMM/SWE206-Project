package swe206;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AddTournamentPage extends Scene {
  
  
  public AddTournamentPage() {
    super(getPane(), 1024, 768);
    String css = this.getClass().getResource("style.css").toExternalForm();
    this.getStylesheets().add(css);
  }

  public static Pane getPane() {

    Label enterTournamentName = new Label("Enter Tournament Name");
    TextField tournamentNamTextField = new TextField();
    VBox nameVBox = new VBox(enterTournamentName, tournamentNamTextField);

    Label enterTournmanetType = new Label("Choose Tournament Type");
    MenuItem elimination = new MenuItem("Elimination");
    MenuItem roundRobin = new MenuItem("Round Robin");
    Menu tournamentType = new Menu("Type");
    tournamentType.getItems().add(elimination);
    tournamentType.getItems().add(roundRobin);
    MenuBar mainMenu = new MenuBar();
    mainMenu.getMenus().add(tournamentType);
    VBox typeVBox = new VBox(enterTournmanetType, mainMenu);

    elimination.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        tournamentType.setText("Elimination");
        // System.out.println(tournamentType.getText());
      }
    });

    elimination.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        tournamentType.setText("Round Robin");
        // System.out.println(tournamentType.getText());
      }
    });



    Label enterTeamSizeLabel = new Label("Enter Team Size");
    TextField tournamentTeamSizeTextField = new TextField();
    VBox teamSizeVBox = new VBox(enterTeamSizeLabel, tournamentTeamSizeTextField);

    Label enterDateLabel = new Label("Enter Tournament Date");
    TextField tournamentDateTextField = new TextField();
    VBox DateVBox = new VBox(enterDateLabel, tournamentDateTextField);

    Button addTournamentButton = new Button("Add Tournament");
    addTournamentButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        String tournamentName = tournamentNamTextField.getText();
        String tournamentType = mainMenu.getAccessibleText();
        int teamSize = Integer.parseInt(tournamentTeamSizeTextField.getText());
        String tournamentDate = tournamentDateTextField.getText();

        Tournament tournament = new Tournament(tournamentName, tournamentType, teamSize, tournamentDate);
        App.stage.setScene(new TournamentsPage());
      }
      
    });

    VBox mainVBox = new VBox(nameVBox, typeVBox, teamSizeVBox, DateVBox, addTournamentButton);
    mainVBox.setSpacing(30);
    VBox.setMargin(mainVBox , new Insets(100, 100, 100, 100));
    Pane container = new Pane(mainVBox);
    container.setMinWidth(1024);
    return container;
  }
}
