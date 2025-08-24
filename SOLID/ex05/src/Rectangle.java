public class Rectangle implements Shape {
    protected int w, h;
    
    public Rectangle() {
        this(0, 0);
    }
    
    public Rectangle(int width, int height) {
        this.w = width;
        this.h = height;
    }
    
    public void setWidth(int w) { 
        this.w = w; 
    }
    
    public void setHeight(int h) { 
        this.h = h; 
    }
    
    public int getWidth() { 
        return w; 
    }
    
    public int getHeight() { 
        return h; 
    }
    
    @Override
    public int area() { 
        return w * h; 
    }
}