
public class Car extends Vehicle {

    private int passengerCount;

    public Car(String brand, String model, int year, Engine engine, int passengerCount) {
        super(brand, model, year, engine);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " " + getModel() + " едет по дороге, пассажиров: " + getPassengerCount());
    }

    public void openTrunk() {
        System.out.println("Багажник " + getBrand() + " " + getModel() + " открыт");
    }
}