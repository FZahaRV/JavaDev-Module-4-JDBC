import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class DatabaseQueryService {
    FileReader reader = new FileReader();
    private final Statement stmt;

    {
        try {
            stmt = Database.getInstance().getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static class MaxSalaryWorker {
        private final String name;
        private final int salary;
        public MaxSalaryWorker(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }
    }
    public static class MaxProjectsClient {
        private final String name;
        private final int projectCount;
        public MaxProjectsClient(String name, int projectCount) {
            this.name = name;
            this.projectCount = projectCount;
        }

        public String getName() {
            return name;
        }

        public int getProjectCount() {
            return projectCount;
        }
    }
    public static class LongestProject {
        private final String name;
        private final int monthCount;
        public LongestProject(String name, int monthCount) {
            this.name = name;
            this.monthCount = monthCount;
        }

        public String getName() {
            return name;
        }

        public int getMonthCount() {
            return monthCount;
        }
    }
    public static class YoungestEldestWorkers {
        private final String type;
        private final String name;
        private final LocalDate birthday;
        public YoungestEldestWorkers(String type, String name, LocalDate birthday) {
            this.type = type;
            this.name = name;
            this.birthday = birthday;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public LocalDate getBirthday() {
            return birthday;
        }
    }
    public static class ProjectPrices {
        private final String name;
        private final int price;
        public ProjectPrices(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }
    public List<YoungestEldestWorkers>  findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_youngest_eldest_workers.sql"));
        while(rs.next()) {
            list.add(new YoungestEldestWorkers( rs.getString("type"),
                    rs.getString("name"),
                    LocalDate.parse(rs.getString("birthday"))));
        }
        if(list.isEmpty()){
            System.out.println("List is empty");
        }
        return list;
    }
    public List<MaxSalaryWorker>  findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryWorker> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_max_salary_worker.sql"));
        while(rs.next()) {
            list.add(new MaxSalaryWorker( rs.getString("name"),
                    rs.getInt("salary")));
        }
        if(list.isEmpty()){
            System.out.println("List is empty");
        }
        return list;
    }
    public List<MaxProjectsClient>  findMaxProjectsClient() throws SQLException {
        List<MaxProjectsClient> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_max_projects_client.sql"));
        while(rs.next()) {
            list.add(new MaxProjectsClient( rs.getString("name"),
                    rs.getInt("project_count")));
        }
        if(list.isEmpty()){
            System.out.println("List is empty");
        }
        return list;
    }
    public List<LongestProject>  findLongestProject() throws SQLException {
        List<LongestProject> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_longest_project.sql"));
        while(rs.next()) {
            list.add(new LongestProject( rs.getString("name"),
                    rs.getInt("month_count")));
        }
        if(list.isEmpty()){
            System.out.println("List is empty");
        }
        return list;
    }
    public List<ProjectPrices>  findProjectPrices() throws SQLException {
        List<ProjectPrices> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("print_project_prices.sql"));
        while(rs.next()) {
            list.add(new ProjectPrices( rs.getString("name"),
                    rs.getInt("price")));
        }
        if(list.isEmpty()){
            System.out.println("List is empty");
        }
        return list;
    }
}
