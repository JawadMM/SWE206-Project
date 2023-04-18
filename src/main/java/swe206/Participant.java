package swe206;

public class Participant extends User {
  private static int participantId;
  private Tournment tournments[];

  public Participant(String username, String password) {
    super(username, password);
  }
  
  public void joinTournment() {};
  public void leaveTournment() {};
}
