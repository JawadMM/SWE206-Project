package swe206;

import java.util.ArrayList;

public class Team {

  private int teamID;
  private String teamName;
  private int score;
  private ArrayList<Participant> participants;

  private static int counter;

public Team(String teamName) {

  counter +=1;
  this.teamID = counter;
  this.teamName = teamName;
  this.participants = new ArrayList<>();
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
