public class SportsClub {
    private String clubName;
    private Athlete athlete;

    public SportsClub(String clubName, Athlete athlete) {
        this.clubName = clubName;
        this.athlete = athlete;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public void displayInfo() {
        System.out.println("Sports Club: " + clubName);
        athlete.displayInfo();
    }
}
