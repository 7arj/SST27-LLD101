package com.example.render;

public class Glyph {
    private final char ch;          // extrinsic state
    private final TextStyle style;  // intrinsic state (shared flyweight)
    
    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = style;
    }
    
    public int drawCost() { 
        return style.getDrawCost(); 
    }
    
    public char getCh() { return ch; }
    public TextStyle getStyle() { return style; }
    
    // Convenience getters (delegate to style)
    public String getFont() { return style.getFont(); }
    public int getSize() { return style.getSize(); }
    public boolean isBold() { return style.isBold(); }
}