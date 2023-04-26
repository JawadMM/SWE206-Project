package swe206;

import java.util.ArrayList;

public class Tournment {
  private int tournmentID;
  private String tournmentName;
  private type tournmetType;
  private String Status;
  private ArrayList<Team> teams;
  private int teamsSize;
  // private List<Team> teams;
  private ArrayList<Match> matches;

  private static int counter;
  enum type {
    Elimination,
    RoundRobin
  }

  public Tournment(String tournmentName, type tournmentType, int teamsSize) {

    counter +=1;
    this.tournmentID = counter;
    this.tournmentName = tournmentName;
    this.tournmetType = tournmentType;
    this.teams = new ArrayList<>();
    this.teamsSize = teamsSize;
    this.matches = new ArrayList<>();
  }

  public void addTeam() {}
  
  public void removeTeam() {}

  public void addMatch() {}

  public void updateMatchScore() {}
}
