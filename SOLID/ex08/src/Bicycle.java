public class Bicycle implements PedalVehicle {
    @Override
    public void move() {
        System.out.println("Bicycle is moving by pedaling");
    }
    
    @Override
    public void pedal(int effort) {
        System.out.println("Pedal effort " + effort);
    }
}