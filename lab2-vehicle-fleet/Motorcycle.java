
public class Motorcycle extends Vehicle {

    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, Engine engine, boolean hasSidecar) {
        super(brand, model, year, engine);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " " + getModel() + " мчится, лавируя между машинами");
    }

    public void doWheelie() {
        if (hasSidecar) {
            System.out.println(getBrand() + " " + getModel() + ": с коляской на заднее колесо не встать");
        } else {
            System.out.println(getBrand() + " " + getModel() + " встаёт на заднее колесо!");
        }
    }
}
