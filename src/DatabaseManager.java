import java.sql.*; // Импортируем пакет java.sql по лекции

public class DatabaseManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/oop assignment";
    private static final String USER = "postgres";
    private static final String PASS = "ALAN2007"; //

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Соединение установлено!");

            String insertSql = "INSERT INTO athlete (full_name, age) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertSql);
            pstmt.setString(1, "ISAEV ASYLZHAN");
            pstmt.setInt(2, 22);
            pstmt.executeUpdate();
            System.out.println("Данные атлета добавлены!");

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM athlete");

            System.out.println("\nСписок атлетов из БД:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Имя: " + rs.getString("full_name") +
                        ", Возраст: " + rs.getInt("age"));
            }

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("\nСоединение закрыто.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}