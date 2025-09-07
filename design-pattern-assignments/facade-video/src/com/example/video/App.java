package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        // Use facade instead of individual components
        VideoPipelineFacade pipeline = new VideoPipelineFacade();
        
        // Process video with all options
        Path result = pipeline.process(
            Path.of("in.mp4"), 
            Path.of("out.mp4"), 
            true,    // grayscale
            0.5,     // scale factor
            5        // sharpen strength
        );
        
        System.out.println("Wrote " + result);
    }
}