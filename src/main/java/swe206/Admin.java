package swe206;

import java.util.ArrayList;
import java.util.Date;

import swe206.Tournament.type;

public class Admin extends User {

  private static ArrayList<Admin> admins = new ArrayList<>();
  private static int adminID;

  public Admin(String username, String password) {
    super(username, password);
    admins.add(this);
    printAdmins();
  }

  public Tournament createTournament(String tournamentName, String tournamentType, int teamsSize, String startDate, String endDate) {
    
    Tournament tournament = new Tournament(tournamentName, tournamentType, teamsSize, startDate, endDate);
    return tournament;
  };

  public void deleteTournament(int tournamentID) {

  }

  public void printAdmins() {
    for (int i = 0; i < admins.size(); i++) {
      System.out.println(admins.get(i));
    }
  }
  
}
