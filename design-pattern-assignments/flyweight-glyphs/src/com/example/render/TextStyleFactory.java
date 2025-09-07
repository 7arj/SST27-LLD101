package com.example.render;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private static final TextStyleFactory instance = new TextStyleFactory();
    private final Map<String, TextStyle> styleCache;
    
    private TextStyleFactory() {
        this.styleCache = new HashMap<>();
    }
    
    public static TextStyleFactory getInstance() {
        return instance;
    }
    
    public TextStyle getTextStyle(String font, int size, boolean bold) {
        //Create key for caching
        String key = createKey(font, size, bold);
        
        // check if style already exists in cache
        TextStyle style = styleCache.get(key);
        if (style == null) {
            // Create new style and cache it
            style = new TextStyle(font, size, bold);
            styleCache.put(key, style);
            System.out.println("Created new TextStyle: " + key); // debug output
        }
        
        return style;
    }
    
    private String createKey(String font, int size, boolean bold) {
        return font + "|" + size + "|" + (bold ? "B" : "R");
    }
    
    //check cache size
    public int getCacheSize() {
        return styleCache.size();
    }
}