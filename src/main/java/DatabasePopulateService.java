import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        try (Statement stmt = Database.getInstance().getConnection().createStatement()) {
            stmt.execute(reader.sqlQueryFromFileReader("populate_db.sql"));
            System.out.println("Filling of the table is successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to fill tables, SQL error: " + e.getMessage());
        }
    }
}
