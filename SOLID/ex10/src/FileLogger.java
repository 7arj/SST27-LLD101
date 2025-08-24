public class FileLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("[FILE-LOG] " + msg + " -> saved to file");
    }
}