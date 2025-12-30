public class Athlete {
    private String fullName;
    private int age;
    private Sport sport;

    public Athlete(String fullName, int age, Sport sport) {
        this.fullName = fullName;
        this.age = age;
        this.sport = sport;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public void displayInfo() {
        System.out.println("Athlete: " + fullName + ", Age: " + age +
                ", Sport: " + sport.getName());
    }
}
