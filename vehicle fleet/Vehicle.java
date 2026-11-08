public abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private Engine engine;

    public abstract void move();

    public Vehicle(String brand, String model, int year, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    // final: наследники не могут переопределить этот метод, вывод информации
    // одинаков для всех видов транспорта
    public final void printInfo() {
        System.out.printf("%s %s (%d)%n", brand, model, year);
        engine.printEngineInfo();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public static class Engine {
        private int power;
        private String type;

        public Engine(int power, String type) {
            this.type = type;
            this.power = power;
        }

        public void printEngineInfo() {
            System.out.println("Тип мотора: " + type + ". Мощность: " + power);
        }
    }

}
