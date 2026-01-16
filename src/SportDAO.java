import java.sql.*;

public class SportDAO {
    public void addSport(Sport sport) throws SQLException {
        String sql = "INSERT INTO sport(name, team_size) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sport.getName());
            ps.setInt(2, sport.getTeamSize());
            ps.executeUpdate();
        }
    }

    public Sport getSportByName(String name) throws SQLException {
        String sql = "SELECT * FROM sport WHERE name=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return new Sport(rs.getString("name"), rs.getInt("team_size"));
        }
        return null;
    }

    public void updateTeamSize(String name, int teamSize) throws SQLException {
        String sql = "UPDATE sport SET team_size=? WHERE name=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, teamSize);
            ps.setString(2, name);
            ps.executeUpdate();
        }
    }

    public void deleteSport(String name) throws SQLException {
        String sql = "DELETE FROM sport WHERE name=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }
}
