import java.sql.*;

public class SportsClubDAO {
    public void addClub(SportsClub club) throws SQLException {
        String sql = "INSERT INTO sports_club(name) VALUES (?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, club.getClubName());
            ps.executeUpdate();
        }
    }

    public SportsClub getClubByName(String name) throws SQLException {
        String sql = "SELECT * FROM sports_club WHERE name=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return new SportsClub(rs.getString("name"));
        }
        return null;
    }

    public void deleteClub(String name) throws SQLException {
        String sql = "DELETE FROM sports_club WHERE name=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }
}
