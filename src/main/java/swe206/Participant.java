package swe206;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class Participant {
    private String username;
    private String password;
    private List<Team> teams;
    private Map<Tournament, Integer> placements;
    private Map<Tournament, Integer> currentRanks;


    public Participant(String username, String password,String type,String email,String name) {
        this.username = username;
        this.password = password;
        this.teams = new ArrayList<>();
        this.placements = new HashMap<>();
        this.currentRanks = new HashMap<>();
    }


    public List<Team> getTeams() {
        return teams;
    }

    public Map<Tournament, Integer> getPlacements() {
        return placements;
    }

    public Map<Tournament, Integer> getCurrentRanks() {
        return currentRanks;
    }

    public void addTeam(Team team) {
    }

    public void addPlacement(Tournament tournament, int i) {
    }

    public void setCurrentRank(Tournament tournament, int i) {
    }


    // Add getters, setters, and other required methods here

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}