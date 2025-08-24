public class MultiFunctionPrinter implements Printer, Scanner, Fax {
    @Override
    public void print(String text) {
        System.out.println("MFP Print: " + text);
    }
    
    @Override
    public void scan(String dstPath) {
        System.out.println("MFP Scan to: " + dstPath);
    }
    
    @Override
    public void fax(String number) {
        System.out.println("MFP Fax to: " + number);
    }
}