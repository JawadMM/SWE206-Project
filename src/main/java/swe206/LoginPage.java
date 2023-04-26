package swe206;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LoginPage {

  public static VBox LoginPage() {

    VBox p = new VBox();

    Label nameLabel = new Label("Enter your name");
    nameLabel.getStyleClass().add("label");
    TextField nameTextField = new TextField();

    VBox nameVBox = new VBox(nameLabel, nameTextField);
    
    p.getChildren().addAll(nameVBox);
    
    System.out.println(p.getClass());
    p.setId("test");

    double margin = p.getWidth() - (p.getWidth() - 60);
    System.out.println(margin);
    VBox.setMargin(nameVBox, new Insets(margin));
    
    p.getStyleClass().add("vbox");

    return p;
  }
}
