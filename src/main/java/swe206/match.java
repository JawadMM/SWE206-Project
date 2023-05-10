package swe206;

import java.io.Serializable;

// public class Match {
//   private int matchID;
//   private Team team1;
//   private Team team2;
//   private Team winner;

//   private static int counter;
  
//   public Match(Team team1, Team team2){

//     counter +=1;
//     this.matchID = counter;
//     this.team1 = team1;
//     this.team2 = team2;
//     team1.setScore(0);
//     team2.setScore(0);
//   }

//   public Team getTeam1() {
//     return team1;
//   }
  
//   public Team getTeam2() {
//     return team2;
//   }
  
//   public void updateScore(Team team, int score) {
//     team.setScore(score);
//   }
  
//   public String toString() {
//     return "Match " + matchID;
//   }

//       public void setWinner(Team winner) {
//         this.winner = winner;
//     }

// //   public static void generateKnockoutRounds(ArrayList<Team> teams) {
// //     int numTeams = teams.size();
// //     int numRounds = (int) ((int) Math.log(numTeams) / Math.log(2));
// //     int teamsPerRound = numTeams;

// //     Scanner scanner = new Scanner(System.in);

// //     for (int i = 0; i < numRounds; i++) {
// //         teamsPerRound /= 2;
// //         System.out.println("Round " + (i+1));
// //         for (int j = 0; j < teamsPerRound; j++) {
// //             Team team1 = teams.get(j);
// //             Team team2 = teams.get(numTeams-j-1);
// //             System.out.println("Match " + (j+1) + " : " + team1.getTeamName() + " vs " + team2.getTeamName());
// //             System.out.print("Enter the winner (1 for " + team1.getTeamName() + ", 2 for " + team2.getTeamName() + "): ");
// //             int winner = scanner.nextInt();
// //             if (winner == 1) {
// //                 teams.set(numTeams-j-1, team1);
// //             } else {
// //                 teams.set(j, team2);
// //             }
// //         }
// //         numTeams /= 2;
// //         System.out.println("");
// //     }

// //     System.out.println("The winner is " + teams.get(0).getTeamName() + "!");
// // }

// // public static void main(String[] args) {
// //     ArrayList<Team> teams = new ArrayList<Team>();
// //     teams.add(new Team("Team 1"));
// //     teams.add(new Team("Team 2"));
// //     teams.add(new Team("Team 3"));
// //     teams.add(new Team("Team 4"));
// //     teams.add(new Team("Team 5"));
// //     teams.add(new Team("Team 6"));
// //     teams.add(new Team("Team 7"));
// //     teams.add(new Team("Team 8"));

// //     generateKnockoutRounds(teams);
// // }

// }


public class Match implements Serializable {
      private Team team1;
      private Team team2;
      private Team winner;
  
      public Match(Team team1, Team team2) {
          this.team1 = team1;
          this.team2 = team2;
      }
  
      public Team getTeam1() {
          return team1;
      }
  
      public Team getTeam2() {
          return team2;
      }
  
      public Team getWinner() {
          return winner;
      }
  
      public void setWinner(Team winner) {
          this.winner = winner;
      }

      public void updateScore(Team team, int score) {
      }
  }