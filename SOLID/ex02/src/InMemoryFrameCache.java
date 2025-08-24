public class InMemoryFrameCache implements FrameCache {
    private Frame lastFrame;
    
    @Override
    public void cacheFrame(Frame frame) {
        this.lastFrame = frame;
        System.out.println("Cached last frame: " + (lastFrame != null));
    }
    
    @Override
    public boolean hasLastFrame() {
        return lastFrame != null;
    }
}