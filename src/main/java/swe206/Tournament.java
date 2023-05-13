package swe206;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Tournament implements Serializable {
  private int tournamentID;
  private String tournamentName;
  private String tournmetType;
  private String Status;
  private ArrayList<Team> teams;
  private int teamsSize;
  private ArrayList<Match> matches;
  private String startDate;
  private String endDate;




  public static ArrayList<Tournament> ongoingTournaments = new ArrayList<>();
  public static ArrayList<Tournament> archivedTournaments = new ArrayList<>();

  private static int counter;
  enum type {
    Elimination,
    RoundRobin
  }

  public Tournament(String tournamentName, String tournamentType, int teamsSize, String startDate, String endDate) {

    counter +=1;
    this.tournamentID = counter;
    this.tournamentName = tournamentName;
    this.tournmetType = tournamentType;
    this.teams = new ArrayList<>();
    this.teamsSize = teamsSize;
    this.matches = new ArrayList<>();
    this.startDate = startDate;
    this.endDate = endDate;
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
  
  public String getTournamentType() {
    return tournmetType;
  }

  public void seTournamentType(String type) {
    this.tournmetType = type;
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

  public String getStartDate() {
    return startDate;
  }
  
  public String getEndDate() {
    return endDate;
  }

  public void addTeam(Team team) {
    this.teams.add(team);
    saveTournaments();
  }
  
  public void removeTeam(Team team) {
    this.teams.remove(team);
    saveTournaments();
  }

  public void addMatch(Match match) {
    matches.add(match);
    saveTournaments();
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
            + ", Team Size: " + teamsSize + "\nTeams: " + teams + "\nMatches: " + matches + "\nDate: " + startDate + " - " + endDate;
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

public static long tournamentDuratuion(String date1, String date2) {
  //Dates should be in this format: "yyyy-MM-dd"
  LocalDate localDate1 = LocalDate.parse(date1);
  LocalDate localDate2 = LocalDate.parse(date2);
  return ChronoUnit.DAYS.between(localDate1, localDate2);
}

public static int[] distributeMatches(int daysBetween, int numMatches) {
  int[] matchesPerDay = new int[daysBetween];
  int matchesPerDayFloor = numMatches / daysBetween;
  int remainingMatches = numMatches % daysBetween;
  Arrays.fill(matchesPerDay, matchesPerDayFloor);
  for (int i = 0; i < remainingMatches; i++) {
      matchesPerDay[i]++;
  }
  return matchesPerDay;
}

public static int[] distributeEliminationMatches(int numTeams) {
  int numRounds = (int) Math.ceil(Math.log(numTeams) / Math.log(2));
  int numMatches = (int) Math.pow(2, numRounds - 1);

  int[] matchesPerDay = new int[numRounds];
  Arrays.fill(matchesPerDay, 1);

  int remainingMatches = numMatches - numRounds;

  for (int i = 0; i < remainingMatches; i++) {
      int maxIndex = 0;
      for (int j = 1; j < numRounds; j++) {
          if (matchesPerDay[j] > matchesPerDay[maxIndex]) {
              maxIndex = j;
          }
      }
      matchesPerDay[maxIndex]++;
  }
  return matchesPerDay;
}

  public static void main(String[] args) {
    // testing methods
    // Load the saved tournaments
    loadTournaments();
    
    // Create and add a new tournament
    // Team team1 = new Team("Team1 Test");
    // Team team2 = new Team("Team2 Test");
    // // Match match1 = new Match(team1, team2);
    
    // ongoingTournaments.get(0).addTeam(team1);
    // ongoingTournaments.get(0).addTeam(team2);
    // ongoingTournaments.get(0).addMatch(match1);
    // ongoingTournaments.get(0).addTeam(team1);
    // ongoingTournaments.get(0).addTeam(team2);
    
    // System.out.println(ongoingTournaments.get(1).getTournamentType());
    
    for(Tournament tt: ongoingTournaments) {
     tt.seTournamentType("Elimination");
     System.out.println(tt.getTournamentType());
    }

   ongoingTournaments.get(1).seTournamentType("Round Robin");

    // ongoingTournaments.clear();
    // Save the tournaments
    saveTournaments();
  }

}

