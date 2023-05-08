package swe206;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Tournament implements Serializable {
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
    saveTournaments();
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

  public static void saveTournaments() {
    try {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("tournaments.ser"));
        outputStream.writeObject(ongoingTournaments);
        outputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  public static void loadTournaments() {
    try {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("tournaments.ser"));
        ongoingTournaments = (ArrayList<Tournament>) inputStream.readObject();
        inputStream.close();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}

  public static void main(String[] args) {
    // testing methods
    // Load the saved tournaments
    loadTournaments();
    
    // Create and add a new tournament
    // Tournament t = new Tournament("t1", Tournament.type.Elimination, 2, "26/4/2023");
    // ongoingTournaments.add(t);
    
    for(Tournament tt: ongoingTournaments) {
      System.out.println(tt);
    }
    // Save the tournaments
    // saveTournaments();
  }

}

