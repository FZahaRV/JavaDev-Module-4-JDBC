import java.sql.*;

public class DatabaseInitService {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        try (Statement stmt = Database.getInstance().getConnection().createStatement()) {
            stmt.execute(reader.sqlQueryFromFileReader("init_db.sql"));
            System.out.println("Table creation successful");
            Database.getInstance().disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to create tables, SQL error: " + e.getMessage());
        }
    }
}
