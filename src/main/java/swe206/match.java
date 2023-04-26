package swe206;

public class Match {
  private int matchID;
  private Team team1;
  private Team team2;

  private static int counter;
  
  public Match(Team team1, Team team2){

    counter +=1;
    this.matchID = counter;
    this.team1 = team1;
    this.team2 = team2;
    team1.setScore(0);
    team2.setScore(0);
  }

  public Team getTeam1() {
    return team1;
  }
  
  public Team getTeam2() {
    return team2;
  }
  
  public void updateScore(Team team, int score) {
    team.setScore(score);
  }
  
  public String toString() {
    return "Match " + matchID;
  }
}
