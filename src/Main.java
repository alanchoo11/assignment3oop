public class Main {
    public static void main(String[] args) {

        Sport basketball = new Sport("Basketball", 5);
        Sport football = new Sport("Football", 11);

        Athlete athlete2 = new Athlete("ISAEV ASYLZHAN", 22, basketball);
        Athlete athlete1 = new Athlete("AITBEKOV ALTAIR", 20, football);

        SportsClub club1 = new SportsClub("Eagles Club", athlete1);
        SportsClub club2 = new SportsClub("Tigers Club", athlete2);

        club1.displayInfo();
        System.out.println();
        club2.displayInfo();

        System.out.println("\nComparison:");
        if (athlete1.getAge() > athlete2.getAge()) {
            System.out.println(athlete1.getFullName() + " is older than " + athlete2.getFullName());
        } else {
            System.out.println(athlete2.getFullName() + " is older than " + athlete1.getFullName());
        }
    }
}
