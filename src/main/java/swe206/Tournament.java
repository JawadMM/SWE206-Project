package swe206;

import java.util.ArrayList;
import java.util.Date;

public class Tournament {
  private int tournamentID;
  private String tournamentName;
  private type tournmetType;
  private String Status;
  private ArrayList<Team> teams;
  private int teamsSize;
  private ArrayList<Match> matches;
  private String date;




  public static ArrayList<Tournament> ongoingTournaments = new ArrayList<>();
  public static ArrayList<Tournament> archivedTournaments = new ArrayList<>();

  private static int counter;
  enum type {
    Elimination,
    RoundRobin
  }

  public Tournament(String tournamentName, type tournamentType, int teamsSize, String date) {

    counter +=1;
    this.tournamentID = counter;
    this.tournamentName = tournamentName;
    this.tournmetType = tournamentType;
    this.teams = new ArrayList<>();
    this.teamsSize = teamsSize;
    this.matches = new ArrayList<>();
    this.date = date;
    this.Status = "Ongoing";

    ongoingTournaments.add(this);
  }

  private int getTournamentID() {
    return tournamentID;
  }

  public String getTournamentName() {
    return tournamentName;
  }
  
  public type getTournamentType() {
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

  public String getDate() {
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

  public void setStatus(String status) {
    if (status.toLowerCase().equals("ended")) {
      this.Status = "Ended";
      archivedTournaments.add(this);
      ongoingTournaments.remove(this);
    }
  }

  public void updateEliminationMatch(Match match, String winner) {
    
  }
  
  public void updateRobinMatch(Match match, Team team, int score) {
    match.updateScore(team, score);
  }

    public String toString() {
    return "ID: " + tournamentID + ", Tournament Name: " + tournamentName + ", Tournament Type: " + tournmetType + ", Status: " + Status 
            + ", Team Size: " + teamsSize + "\nTeams: " + teams + "\nMatches: " + matches + "\nDate: " + date;
  }
  public static void main(String[] args) {
    // testing methods
    Tournament t = new Tournament("t1", Tournament.type.Elimination, 2, "26/4/2023");
    Participant p1 = new Participant("p1", null);
    Participant p2 = new Participant("p2", null);
    Team team1 = new Team("team1");
    team1.addParticipant(p1);
    team1.addParticipant(p2);
    t.addTeam(team1);
    Participant p11 = new Participant("p1", null);
    Participant p22 = new Participant("p2", null);
    Team team2 = new Team("team2");
    team2.addParticipant(p11);
    team2.addParticipant(p22);
    t.addTeam(team2);
    Match match = new Match(team1, team2);
    t.addMatch(match);
    System.out.println(t.toString());
  }
}
