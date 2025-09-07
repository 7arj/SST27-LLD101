package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    private Decoder decoder;
    private FilterEngine filterEngine;
    private Encoder encoder;
    private SharpenAdapter sharpenAdapter;
    
    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter(new LegacySharpen());
    }
    
    // Constructor for dependency injection\
    public VideoPipelineFacade(Decoder decoder, FilterEngine filterEngine, Encoder encoder, SharpenAdapter sharpenAdapter) {
        this.decoder = Objects.requireNonNull(decoder, "decoder cannot be null");
        this.filterEngine = Objects.requireNonNull(filterEngine, "filterEngine cannot be null");
        this.encoder = Objects.requireNonNull(encoder, "encoder cannot be null");
        this.sharpenAdapter = Objects.requireNonNull(sharpenAdapter, "sharpenAdapter cannot be null");
    }
    
    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        // Input validation
        Objects.requireNonNull(src, "src cannot be null");
        Objects.requireNonNull(out, "out cannot be null");
        
        // Step 1: Decode
        Frame[] frames = decoder.decode(src);
        
        // Step 2: Optional grayscale
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }
        
        // Step 3: Optional scale
        if (scale != null && scale > 0) {
            frames = filterEngine.scale(frames, scale);
        }
        
        // Step 4: Optional sharpen using adapter
        if (sharpenStrength != null && sharpenStrength > 0) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }
        
        // Step 5: Encode
        Path result = encoder.encode(frames, out);
        
        return result;
    }
}