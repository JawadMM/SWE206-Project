package swe206;

public class Match {
  private int matchID;
  private Team team1;
  private Team team2;
  private int team1Score;
  private int team2Score;

  public void updateScore(Team team, int score) {}

  public int getScore(Team team) {
    return team.score;
  }

}
