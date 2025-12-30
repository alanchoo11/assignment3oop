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

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public void displayInfo() {
        System.out.println("Sport: " + name + ", Team size: " + teamSize);
    }
}
