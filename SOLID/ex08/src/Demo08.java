public class Demo08 {
    public static void main(String[] args) {
        System.out.println("---- Vehicle Demo ----");
        
        // Bicycle with pedal power
        Bicycle bicycle = new Bicycle();
        bicycle.pedal(5);
        
        // Car with engine
        Car car = new Car();
        car.startEngine();
        
        // Electric car with engine and recharging
        ElectricCar eCar = new ElectricCar();
        eCar.startEngine();
        eCar.recharge(50);
        
        System.out.println("\n---- Polymorphic Demo ----");

        Vehicle[] vehicles = {bicycle, car, eCar};
        for (Vehicle v : vehicles) {
            v.move(); // All vehicles can move
        }
        
        if (car instanceof EngineVehicle) {
            ((EngineVehicle) car).startEngine();
        }
        
        if (bicycle instanceof PedalVehicle) {
            ((PedalVehicle) bicycle).pedal(3);
        }
    }
}