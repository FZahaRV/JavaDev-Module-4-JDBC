public class DatabaseQueryService {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        System.out.println(reader.sqlQueryFromFileReader("init_db.sql"));
    }
}
