// Square class implementing Shape interface independently (LSP compliance)
public class Square implements Shape {
    private int side;
    
    public Square() {
        this(0);
    }
    
    public Square(int side) {
        this.side = side;
    }
    
    public void setSide(int side) {
        this.side = side;
    }
    
    public int getSide() {
        return side;
    }
    
    @Override
    public int area() {
        return side * side;
    }
}