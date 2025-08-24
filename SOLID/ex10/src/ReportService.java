public class ReportService {
    private final Logger logger;
    
    // Dependency injection
    public ReportService(Logger logger) {
        this.logger = logger;
    }
    
    // Single responsibility: generate reports
    public void generate() {
        logger.log("Generating daily report...");
        System.out.println("Report contents...");
    }
}