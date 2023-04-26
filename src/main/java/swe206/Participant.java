package swe206;

import java.util.ArrayList;

public class Participant extends User {
  private static int participantId;
  private ArrayList<Tournament> previousTournments;

  public Participant(String username, String password) {
    super(username, password);
    this.previousTournments = new ArrayList<>();
  }
  
  public void joinTournment(Tournament tournment) {
    previousTournments.add(tournment);
  };

  public void leaveTournment(Tournament tournment) {
    previousTournments.remove(tournment);
  };
}
