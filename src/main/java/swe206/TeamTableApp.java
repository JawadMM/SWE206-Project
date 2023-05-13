package swe206;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TeamTableApp extends Scene {

    private static ObservableList<Team> data =
            FXCollections.observableArrayList(
                    new Team("Team A", 10),
                    new Team("Team B", 12),
                    new Team("Team C", 8));
                    
                    private static TableView<Team> table = new TableView<>();
                    
     public TeamTableApp(Tournament tournament) {
        super(mainPane(tournament), 1024, 768);
        String css = this.getClass().getResource("style.css").toExternalForm();
        this.getStylesheets().add(css);
     }
    // public static void main(String[] args) {
    //     launch(args);
    // }

    // @Override
    public static VBox mainPane(Tournament tournament) {
        // primaryStage.setTitle("Editable Team Points");

        TableColumn<Team, String> nameCol = new TableColumn<>("Team");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Team, Integer> pointsCol = new TableColumn<>("Points");
        pointsCol.setMinWidth(100);
        pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
        pointsCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        pointsCol.setOnEditCommit(e -> {
            Team team = e.getTableView().getItems().get(e.getTablePosition().getRow());
            team.setPoints(e.getNewValue());
        });

        table.setItems(data);
        table.getColumns().addAll(nameCol, pointsCol);
        table.setEditable(true);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(table);

        // Scene scene = new Scene(vbox, 1024, 768);
        // String css = this.getClass().getResource("style.css").toExternalForm();
        // scene.getStylesheets().add(css);
        // primaryStage.setScene(scene);
        // primaryStage.show();

        return vbox;
    }
}