import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Sport basketball = new Sport("Basketball", 5);
        Athlete a1 = new Athlete("ISAEV ASYLZHAN", 22, basketball);

        String url = "jdbc:postgresql://localhost:5432/oop assignment";
        String user = "postgres";
        String pass = "ALAN2007";

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected successfully!");

            //(WRITE)
            String insertSql = "INSERT INTO athlete (full_name, age) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertSql)) {
                ps.setString(1, a1.getFullName());
                ps.setInt(2, a1.getAge());
                ps.executeUpdate();
                System.out.println("1. Data saved to DB!");
            }

            //(READ)
            String selectSql = "SELECT * FROM athlete";
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSql)) {
                System.out.println("\n--- Athletes List ---");
                while (rs.next()) {
                    System.out.println("Name: " + rs.getString("full_name") + ", Age: " + rs.getInt("age"));
                }
            }

            //(UPDATE)
            String updateSql = "UPDATE athlete SET age = ? WHERE full_name = ?";
            try (PreparedStatement up = con.prepareStatement(updateSql)) {
                up.setInt(1, 23);
                up.setString(2, "ISAEV ASYLZHAN");
                up.executeUpdate();
                System.out.println("\n3. Data updated!");
            }

            //(DELETE)
            String deleteSql = "DELETE FROM athlete WHERE full_name = ?";
            try (PreparedStatement del = con.prepareStatement(deleteSql)) {
                del.setString(1, "ISAEV ASYLZHAN");
                // del.executeUpdate();
                System.out.println("4. Delete command prepared.");
            }

        } catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());
            if (e.getMessage().contains("password authentication failed")) {
                System.out.println(">>> ПРОВЕРЬ ПАРОЛЬ В КОДЕ! Сейчас там ошибка авторизации.");
            }
        }
    }
}