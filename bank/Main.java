import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount[] accounts = {
                new BankAccount("Egor", "000001", 1000),
                new BankAccount("Alina", "000002", 0),
                new BankAccount("Oleg", "000003"),
                new BankAccount("Nikita", "000004", -100)
        };

        System.out.println("Количество счетов: " + BankAccount.getAccountsCount());

        int choice;
        BankAccount selected = accounts[0];
        do {
            clearScreen();
            System.out.println("-".repeat(40));
            printAccountInfo(selected);
            System.out.print("""
                    ╔══════════════════════════════╗
                    ║            МЕНЮ              ║
                    ╠══════════════════════════════╣
                    ║  1 │ Информация о счёте      ║
                    ║  2 │ Список всех счетов      ║
                    ║  3 │ Пополнить               ║
                    ║  4 │ Снять                   ║
                    ║  5 │ Сменить счёт            ║
                    ║  0 │ Выход                   ║
                    ╚══════════════════════════════╝
                    Ваш выбор:\s""");
            choice = readInt(scanner);

            switch (choice) {
                case 1 -> {
                    printAccountInfo(selected);
                    System.out.printf(" Баланс: %.2f%n", selected.getBalance());
                }
                case 2 -> {
                    listAccounts(accounts);
                }
                case 3 -> {
                    System.out.println("На какую сумму хотите пополнить баланс?");
                    selected.deposit(readDouble(scanner));
                }
                case 4 -> {
                    System.out.println("Какую сумму хотите снять?");
                    selected.withdraw(readDouble(scanner));
                }
                case 5 -> {
                    listAccounts(accounts);
                    System.out.print("Введите номер счёта: ");
                    String accNumber = scanner.nextLine().trim(); 
                    BankAccount found = findAccount(accounts, accNumber);
                    if (found == null) {                                   
                        System.out.println("Счёт с номером " + accNumber + " не найден");
                    } else {
                        selected = found;
                        System.out.println("Выбран счёт " + selected.getAccountNumber());
                    }
                }
                case 0 -> {
                    System.out.println("До связи!");
                }
                default -> {
                    System.out.println("Нет такого пункта");
                }
            }

            if (choice != 0) {  
                pause(scanner);
            }

        } while (choice != 0);

    }

    static void printAccountInfo(BankAccount account) {
        System.out.printf("Текущий счёт:%n Номер счета: %s%n Владелец: %s%n", account.getAccountNumber(),
                account.getOwner());
    }

    static void listAccounts(BankAccount[] accounts) {
        System.out.printf("%-12s | %-12s | %s%n", "Номер счёта", "Владелец", "Баланс");
        System.out.println("-".repeat(40));
        for (BankAccount bankAccount : accounts) {
            System.out.printf("%-12s | %-12s | %.2f%n", bankAccount.getAccountNumber(),
                bankAccount.getOwner(),
                bankAccount.getBalance());
        }
    }

    static BankAccount findAccount(BankAccount[] accounts, String number) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                return account;        
            }
        }
        return null;                   
    }

    static double readDouble(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim().replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("ERROR 4001: введено не число, повторите ввод: ");
            }
        }
    }

        static int readInt(Scanner scanner) {
        try{
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        }  catch (NumberFormatException e) {
            return -1;
        }
    }
    static void pause(Scanner scanner) {
        System.out.print("\nНажмите Enter, чтобы продолжить...");
        scanner.nextLine();          
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");   // специальная последовательность «очистить экран»
        System.out.flush();
    }
}
