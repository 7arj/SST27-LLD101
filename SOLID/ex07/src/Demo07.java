public class Demo07 {
    public static void main(String[] args) {
        System.out.println("---- Machine Demo ----");
        
        // Basic printer
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello");
        
        // Multi-function printer
        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Hello from MFP");
        mfp.scan("/tmp/out");
        mfp.fax("555-1234");
        
        // Scanner only supports scanning
        Scanner scanner = new DocumentScanner();
        scanner.scan("/tmp/scanned");
        
        System.out.println("\n---- Polymorphic Demo ----");
        // Safe polymorphic usage
        Printer[] printers = {basicPrinter, mfp};
        for (Printer p : printers) {
            p.print("Polymorphic printing");
        }
    }
}