import java.util.Objects;

public class Athlete extends Person {
    private Sport sport;

    public Athlete(String fullName, int age, Sport sport) {
        super(fullName, age);
        this.sport = sport;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String getRole() {
        return "Athlete";
    }

    @Override
    public String toString() {
        return fullName + ", age " + age + ", sport: " + sport.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete)) return false;
        Athlete athlete = (Athlete) o;
        return age == athlete.age &&
                fullName.equals(athlete.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age);
    }
}
