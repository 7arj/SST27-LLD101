public class Demo10 {
    public static void main(String[] args) {
        System.out.println("---- Report Service Demo ----");
        
        //loggers
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();
        
        //report services
        ReportService consoleReportService = new ReportService(consoleLogger);
        ReportService fileReportService = new ReportService(fileLogger);
        
        //functionality demo
        consoleReportService.generate();
        
        System.out.println("\n---- File Logger Demo ----");
        fileReportService.generate();
        
        System.out.println("\n---- Multiple Reports ----");
        consoleReportService.generate();
    }
}