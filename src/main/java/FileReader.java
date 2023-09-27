import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    public String sqlQueryFromFileReader(String filePath) {
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader("sql/" + filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sqlQuery.append(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("The file with instructions for creating the table does not exist");
        }
        return sqlQuery.toString();
    }
}
