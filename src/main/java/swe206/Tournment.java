package swe206;

import java.util.ArrayList;
import java.util.Date;

public class Tournment {
  private int tournmentID;
  private String tournmentName;
  private type tournmetType;
  private String Status;
  private ArrayList<Team> teams;
  private int teamsSize;
  // private List<Team> teams;
  private ArrayList<Match> matches;
  private Date date;

  private static int counter;
  enum type {
    Elimination,
    RoundRobin
  }

  public Tournment(String tournmentName, type tournmentType, int teamsSize, Date date) {

    counter +=1;
    this.tournmentID = counter;
    this.tournmentName = tournmentName;
    this.tournmetType = tournmentType;
    this.teams = new ArrayList<>();
    this.teamsSize = teamsSize;
    this.matches = new ArrayList<>();
    this.date = date;
  }

  private int getTournmentID() {
    return tournmentID;
  }

  public String getTournmentName() {
    return tournmentName;
  }
  
  public type getTournmentType() {
    return tournmetType;
  }

  public String getStatus() {
    return Status;
  }

  public ArrayList<Team> getTeams() {
    return teams;
  }
  
  public int getTeamsSize() {
    return teamsSize;
  }

  public ArrayList<Match> getMatches() {
    return matches;
  }

  public Date getDate() {
    return date;
  }

  public void addTeam(Team team) {
    teams.add(team);
  }
  
  public void removeTeam(Team team) {
    teams.remove(team);
  }

  public void addMatch(Match match) {
    matches.add(match);
  }

  public void updateEliminationMatch(Match match, String winner) {
    
  }
  
  public void updateRobinMatch(Match match, Team team, int score) {
    match.updateScore(team, score);
  }
  
  public static void main(String[] args) {
    Tournment t = new Tournment("team1", Tournment.type.Elimination, 2, new Date());
    System.out.println(t.getDate());
  }
}
