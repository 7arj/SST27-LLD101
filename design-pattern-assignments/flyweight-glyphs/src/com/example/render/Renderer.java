package com.example.render;

public class Renderer {
    private final TextStyleFactory styleFactory;
    
    public Renderer() {
        this.styleFactory = TextStyleFactory.getInstance();
    }
    
    public int render(String text) {
        int cost = 0;
        for (char c : text.toCharArray()) {
            // Get shared TextStyle from factory instead of creating new one
            TextStyle style = styleFactory.getTextStyle("Inter", 14, (c % 7 == 0));
            Glyph g = new Glyph(c, style);
            cost += g.drawCost();
        }
        
        //p rint cache size for demonstration
        System.out.println("Total cached styles: " + styleFactory.getCacheSize());
        return cost;
    }
}