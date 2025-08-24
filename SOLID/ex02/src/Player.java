public class Player {
    private final FrameDecoder decoder;
    private final UIRenderer renderer;
    private final FrameCache cache;
    
    // Dependency injection
    public Player(FrameDecoder decoder, UIRenderer renderer, FrameCache cache) {
        this.decoder = decoder;
        this.renderer = renderer;
        this.cache = cache;
    }
    
    // Single responsibility
    public void play(byte[] fileBytes) {
        Frame frame = decoder.decode(fileBytes);
        renderer.renderPlayback(fileBytes.length);
        cache.cacheFrame(frame);
    }
}