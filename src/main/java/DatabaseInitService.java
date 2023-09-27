import java.sql.*;

public class DatabaseInitService {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        try (Statement stmt = Database.getInstance().getConnection().createStatement()) {
            if(stmt.execute(reader.sqlQueryFromFileReader("init_db.sql"))) {
                System.out.println("Table creation successful");
            }else{
                System.err.println("Failed to create tables");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error: " + e.getMessage());
        }
    }
}
