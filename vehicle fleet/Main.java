public class Main {
    public static void main(String[] args) {

        // Восходящее преобразование (upcasting): переменная типа Vehicle
        // хранит объект наследника. Приведение выполняется автоматически,
        // потому что любой Car — это Vehicle.
        // Engine вложен в Vehicle, поэтому снаружи к нему обращаемся через
        // Vehicle.Engine
        Vehicle car = new Car("Lada", "Vesta", 2020, new Vehicle.Engine(106, "бензин"), 5);
        Vehicle moto = new Motorcycle("Yamaha", "R1", 2022, new Vehicle.Engine(200, "бензин"), false);
        Vehicle truck = new Truck("КАМАЗ", "5490", 2019, new Vehicle.Engine(428, "дизель"), 20.0);

        // Анонимный класс: безымянный наследник Vehicle, объявленный и созданный прямо
        // здесь.
        // Сам Vehicle абстрактный, но анонимный класс реализует move(), поэтому объект
        // создать можно
        Vehicle scooter = new Vehicle("Xiaomi", "Pro 2", 2023, new Vehicle.Engine(1, "электро")) {
            @Override
            public void move() {
                System.out.println(getBrand() + " " + getModel() + " тихо едет по тротуару");
            }
        };

        Vehicle[] vehicles = { car, moto, truck, scooter };

        System.out.println("===== Автопарк =====");
        for (Vehicle vehicle : vehicles) {
            System.out.println("-".repeat(40));
            vehicle.printInfo();
            vehicle.move(); // Полиморфизм: вызывается move() фактического класса объекта

            // Нисходящее преобразование: сначала проверяю тип через instanceof, потом
            // привожу
            if (vehicle instanceof Car) {
                Car c = (Car) vehicle;
                c.openTrunk();
            } else if (vehicle instanceof Truck) {
                Truck t = (Truck) vehicle;
                t.loadCargo(5.0);
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle m = (Motorcycle) vehicle;
                m.doWheelie();
            }
        }

        /*
         * Пример неправильного нисходящего преобразования:
         *
         * Car c = (Car) moto; // Компилятор это пропустит, т.к. в переменной типа
         * Vehicle может лежать и Car
         * c.openTrunk();
         *
         * При запуске программа упадёт уже на строке с приведением, до openTrunk() дело
         * не дойдёт:
         * java.lang.ClassCastException: class Motorcycle cannot be cast to class Car
         * Приведение не превращает мотоцикл в машину, оно только меняет тип ссылки,
         * поэтому Java проверяет реальный объект, видит что это Motorcycle и
         * выбрасывает исключение.
         *
         * Чтобы такого не было, я перед каждым приведением проверяю тип через
         * instanceof (см. цикл выше):
         * если vehicle instanceof Car вернёт false, блок с (Car) просто не выполнится и
         * программа не упадёт.
         */
    }
}
