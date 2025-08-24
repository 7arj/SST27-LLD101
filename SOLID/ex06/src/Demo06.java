public class Demo06 {
    public static void main(String[] args) {
        System.out.println("---- Aviary Demo ----");
        
        Aviary aviary = new Aviary();
        
        // Release flying bird
        Bird eagle = new Eagle();
        aviary.release(eagle);
        
        // Handle non-flying bird
        Bird penguin = new Penguin();
        aviary.handleBird(penguin);
        
        System.out.println("\n---- Flying Demo ----");
        // Demo flying capability
        if (eagle instanceof Flyable) {
            ((Flyable) eagle).fly();
        }
        
        if (penguin instanceof Flyable) {
            ((Flyable) penguin).fly();
        } else {
            System.out.println("Penguin cannot fly");
        }
    }
}