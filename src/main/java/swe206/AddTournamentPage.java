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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AddTournamentPage extends Scene {
  // public static Scene scene = new TournamentsPage();

  
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

    roundRobin.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        tournamentType.setText("Round Robin");
        // System.out.println(tournamentType.getText());
      }
    });



    Label enterTeamSizeLabel = new Label("Enter Team Size");
    TextField tournamentTeamSizeTextField = new TextField();
    VBox teamSizeVBox = new VBox(enterTeamSizeLabel, tournamentTeamSizeTextField);

    Label enterStartDateLabel = new Label("Enter Tournament Start Date");
    TextField tournamentStartDateTextField = new TextField();
    VBox startDateVBox = new VBox(enterStartDateLabel, tournamentStartDateTextField);

    Label enterEndDateLabel = new Label("Enter Tournament Date");
    TextField tournamentEndDateTextField = new TextField();
    VBox endDateVBox = new VBox(enterEndDateLabel, tournamentEndDateTextField);

    Button addTournamentButton = new Button("Add Tournament");
    addTournamentButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        String tournamentName = tournamentNamTextField.getText();
        String tournamentTypeString = tournamentType.getText();
        System.out.println(tournamentType);
        int teamSize = Integer.parseInt(tournamentTeamSizeTextField.getText());
        String tournamentStartDate = tournamentStartDateTextField.getText();
        String tournamentEndDate = tournamentEndDateTextField.getText();

        Tournament tournament = new Tournament(tournamentName, tournamentTypeString, teamSize, tournamentStartDate, tournamentEndDate);
        // App.stage.setScene(scene);
        HelloApplication.stage.setScene(new TournamentsPage());
      }
      
    });

    HBox dates = new HBox(startDateVBox, endDateVBox);
    dates.setSpacing(30);

    VBox mainVBox = new VBox(nameVBox, typeVBox, teamSizeVBox, dates, addTournamentButton);
    mainVBox.setSpacing(30);
    VBox.setMargin(mainVBox , new Insets(100, 100, 100, 100));
    Pane container = new Pane(mainVBox);
    container.setMinWidth(1024);
    return container;
  }
}
