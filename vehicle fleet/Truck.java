
public class Truck extends Vehicle {

    private double maxLoad; // грузоподъёмность в тоннах

    public Truck(String brand, String model, int year, Engine engine, double maxLoad) {
        super(brand, model, year, engine);
        this.maxLoad = maxLoad;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " " + getModel() + " медленно везёт груз по трассе.");
    }

    public void loadCargo(double weight) {
        if (weight <= 0) {
            System.out.println("ERROR: вес груза должен быть больше 0");
        } else if (weight > maxLoad) {
            System.out.printf("ERROR: %.1f т превышает грузоподъёмность %.1f т%n", weight, maxLoad);
        } else {
            System.out.printf("В %s %s загружено %.1f т из %.1f т%n", getBrand(), getModel(), weight, maxLoad);
        }
    }
}
