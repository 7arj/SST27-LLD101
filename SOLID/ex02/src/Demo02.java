public class Demo02 {
    public static void main(String[] args) {
        //dependencies
        FrameDecoder decoder = new BasicFrameDecoder();
        UIRenderer renderer = new ConsoleUIRenderer();
        FrameCache cache = new InMemoryFrameCache();
        
        //player with dependency injection
        Player player = new Player(decoder, renderer, cache);
        
        //functionality demo
        System.out.println("---- Media Player Demo ----");
        player.play(new byte[]{1, 2, 3, 4});

        System.out.println("\n---- Playing different content ----");
        player.play(new byte[]{10, 20, 30, 40, 50});
    }
}