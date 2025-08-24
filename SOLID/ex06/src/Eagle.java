public class Eagle extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flap!");
    }
    
    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }
}