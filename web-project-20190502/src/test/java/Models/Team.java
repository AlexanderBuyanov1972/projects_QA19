package Models;

public class Team {
    String teamName;
    String description;

    public Team() {
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    public void withTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void withDescription(String description) {
        this.description = description;
    }
}
