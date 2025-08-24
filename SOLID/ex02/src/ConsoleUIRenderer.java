public class ConsoleUIRenderer implements UIRenderer {
    @Override
    public void renderPlayback(int dataSize) {
        System.out.println("Playing " + dataSize + " bytes");
    }
}