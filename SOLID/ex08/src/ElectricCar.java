public class ElectricCar implements EngineVehicle, ElectricVehicle {
    @Override
    public void move() {
        System.out.println("Electric car is moving");
    }
    
    @Override
    public void startEngine() {
        System.out.println("Electric motor started");
    }
    
    @Override
    public void recharge(int kWh) {
        System.out.println("Charging battery with " + kWh + " kWh");
    }
}