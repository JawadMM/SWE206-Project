package swe206;

public class Tournment {
  private int tournmentID;
  private String tournmentName;
  private type tournmetType;
  private String Status;
  private Team[] teams;
  // private List<Team> teams;
  private match[] matches;

  private static int counter;

  enum type {
    Elimination,
    RoundRobin
  }

  public Tournment(String tournmentName, type tournmentType) {

    counter +=1;
    this.tournmentID = counter;
    this.tournmentName = tournmentName;
    this.tournmetType = tournmentType;
    this.teams = new Team[0];
    this.matches = new match[0];
  }

  public void addTeam() {}
  
  public void removeTeam() {}

  public void addMatch() {}

  public void updateMatchScore() {}

  
}
