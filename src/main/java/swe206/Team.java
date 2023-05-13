package swe206;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Team implements Serializable {

  private int teamID;
  private String teamName;
  private int score;
  private ArrayList<Participant> participants;

  private static int counter;

  private SimpleStringProperty name;
  private SimpleIntegerProperty points;

  public Team(String name, int points) {
      this.name = new SimpleStringProperty(name);
      this.points = new SimpleIntegerProperty(points);
  }

  public Team(String teamName) {

    counter +=1;
    this.teamID = counter;
    this.teamName = teamName;
    this.participants = new ArrayList<>();
  }

  public String getName() {
      return name.get();
  }

  public void setName(String name) {
      this.name.set(name);
  }

  public int getPoints() {
      return points.get();
  }

  public void setPoints(int points) {
      this.points.set(points);
  }

  public SimpleStringProperty nameProperty() {
      return name;
  }

  public SimpleIntegerProperty pointsProperty() {
      return points; 
  }


  public int getTeamID() {
    return teamID;
  }

  public String getTeamName() {
    return teamName;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public ArrayList<Participant> getParticipants() {
    return participants;
  }

  public void addParticipant(Participant participant) {
    participants.add(participant);
  }
  
  public void removeParticipant(Participant participant) {
    participants.remove(participant);
  }

  public String toString() {
    return teamName;
  }
}
