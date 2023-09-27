import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database database;
    private String dbUrl;
    private String dbUser;
    private String dbPass;
    private Connection conn;
    public Database() {
        dbUrl = "jdbc:h2:~/test";
        dbUser = "sa";
        dbPass = "";

    }
    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
    public Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        if (conn != null) {
            System.out.println("Connected to database");
            return conn;
        } else {
            System.err.println("Failed to connect to database");
            return null;
        }
    }
    public void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Disconnected from database");
        }
    }
}

