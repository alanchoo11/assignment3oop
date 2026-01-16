import java.util.Objects;

public class Sport {
    private String name;
    private int teamSize;

    public Sport(String name, int teamSize) {
        this.name = name;
        this.teamSize = teamSize;
    }

    public String getName() {
        return name;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public String toString() {
        return name + " (team size: " + teamSize + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sport)) return false;
        Sport sport = (Sport) o;
        return name.equals(sport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
