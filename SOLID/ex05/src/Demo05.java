public class Demo05 {
    static int areaAfterResize(Rectangle r) {
        r.setWidth(5); 
        r.setHeight(4); 
        return r.area();
    }
    
    //separate method for squares
    static int areaAfterResize(Square s) {
        s.setSide(4); //side instead of width/height
        return s.area();
    }
    
    public static void main(String[] args) {
        System.out.println("---- Shape Area Demo ----");
        System.out.println("Rectangle area: " + areaAfterResize(new Rectangle())); // 20
        System.out.println("Square area: " + areaAfterResize(new Square()));       // 16
        
        // Demo polymorphism
        System.out.println("\n---- Polymorphic Shape Demo ----");
        Shape rectangle = new Rectangle(3, 2);
        Shape square = new Square(4);
        
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Square area: " + square.area());
    }
}