package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private LegacySharpen legacySharpen;
    
    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen cannot be null");
    }
    
    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames cannot be null");
        
        if (strength <= 0) {
            return frames; // No sharpening needed
        }
        
        // Convert frames to handle string (simulate serialization)
        String framesHandle = framesToHandle(frames);
        
        // Use legacy API
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);
        
        // Convert back to frames (simulate deserialization)
        return handleToFrames(resultHandle, frames.length);
    }
    
    // simulate converting frames to handle
    private String framesToHandle(Frame[] frames) {
        StringBuilder sb = new StringBuilder();
        sb.append("FRAMES[");
        for (int i = 0; i < frames.length; i++) {
            sb.append(frames[i].w).append("x").append(frames[i].h);
            if (i < frames.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    //simulate converting handle back to frames
    private Frame[] handleToFrames(String handle, int frameCount) {
        
        //pretend sharpened
        Frame[] result = new Frame[frameCount];
        for (int i = 0; i < frameCount; i++) {
            result[i] = new Frame(1920, 1080);
        }
        return result;
    }
}