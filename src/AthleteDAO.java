import java.sql.*;

public class AthleteDAO {

    public void addAthlete(Athlete athlete, String clubName) throws SQLException {
        String sql = """
                INSERT INTO athlete(full_name, age, sport_id, club_id)
                VALUES (?, ?, 
                        (SELECT id FROM sport WHERE name=?),
                        (SELECT id FROM sports_club WHERE name=?))
                """;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, athlete.getFullName());
            ps.setInt(2, athlete.getAge());
            ps.setString(3, athlete.getSport().getName());
            ps.setString(4, clubName);
            ps.executeUpdate();
        }
    }

    public void updateAge(String fullName, int age) throws SQLException {
        String sql = "UPDATE athlete SET age=? WHERE full_name=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, age);
            ps.setString(2, fullName);
            ps.executeUpdate();
        }
    }

    public void deleteAthlete(String fullName) throws SQLException {
        String sql = "DELETE FROM athlete WHERE full_name=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fullName);
            ps.executeUpdate();
        }
    }

    public void getAllAthletes() throws SQLException {
        String sql = """
                SELECT a.full_name, a.age, s.name AS sport, c.name AS club
                FROM athlete a
                JOIN sport s ON a.sport_id = s.id
                JOIN sports_club c ON a.club_id = c.id
                """;
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("full_name") + ", age " +
                        rs.getInt("age") + ", sport: " + rs.getString("sport") +
                        ", club: " + rs.getString("club"));
            }
        }
    }
}
