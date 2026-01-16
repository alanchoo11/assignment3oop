import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SportsClub {
    private String clubName;
    private List<Athlete> athletes = new ArrayList<>();

    public SportsClub(String clubName) {
        this.clubName = clubName;
    }

    public void addAthlete(Athlete athlete) {
        athletes.add(athlete);
    }

    public String getClubName() {
        return clubName;
    }

    // Filtering
    public List<Athlete> filterBySport(String sportName) {
        List<Athlete> result = new ArrayList<>();
        for (Athlete a : athletes) {
            if (a.getSport().getName().equalsIgnoreCase(sportName)) {
                result.add(a);
            }
        }
        return result;
    }

    // Searching
    public Athlete findByName(String name) {
        for (Athlete a : athletes) {
            if (a.getFullName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    // Sorting
    public List<Athlete> sortByAge() {
        athletes.sort(Comparator.comparingInt(Person::getAge));
        return athletes;
    }
}
