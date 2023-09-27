import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseQueryService queryService = new DatabaseQueryService();
        System.out.println("\nYoungestEldestWorkers");
        for (DatabaseQueryService.YoungestEldestWorkers res: queryService.findYoungestEldestWorkers()) {
            System.out.println(res.getType()+ " " + res.getName() + " " + res.getBirthday());
        }
        System.out.println("\nMaxSalaryWorker");
        for (DatabaseQueryService.MaxSalaryWorker res: queryService.findMaxSalaryWorker()) {
            System.out.println(res.getName() + " " + res.getSalary());
        }
        System.out.println("\nMaxProjectsClient");
        for (DatabaseQueryService.MaxProjectsClient res: queryService.findMaxProjectsClient()) {
            System.out.println(res.getName() + " " + res.getProjectCount());
        }
        System.out.println("\nLongestProject");
        for (DatabaseQueryService.LongestProject res: queryService.findLongestProject()) {
            System.out.println(res.getName() + " " + res.getMonthCount());
        }
        System.out.println("\nProjectPrices");
        for (DatabaseQueryService.ProjectPrices res: queryService.findProjectPrices()) {
            System.out.println(res.getName() + " " + res.getPrice());
        }
    }
}
