public class BasicFrameDecoder implements FrameDecoder {
    @Override
    public Frame decode(byte[] fileBytes) {
        // Pretend decoding logic
        return new Frame(fileBytes);
    }
}