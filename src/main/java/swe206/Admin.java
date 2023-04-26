package swe206;

import java.util.Date;

import swe206.Tournament.type;

public class Admin extends User {

  private static int adminID;

  public Admin(String username, String password) {
    super(username, password);
  }

  public Tournament createTournament(String tournamentName, type tournamentType, int teamsSize, String date) {
    
    Tournament tournament = new Tournament(tournamentName, tournamentType, teamsSize, date);
    return tournament;
  };

  public void deleteTournament(int tournamentID) {

  }
  
}
