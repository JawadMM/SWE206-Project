package swe206;

public class Admin extends User {

  private static int adminID;

  public Admin(String username, String password) {
    super(username, password);
  }

  public Tournment createTournment(String tournmentName, String date, String location) {
    return null;
  };

  public void deleteTournment(int tournmentID) {

  }
  
}
