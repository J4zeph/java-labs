public class BankAccount {
    private String owner;
    private String accountNumber;
    private double balance;
    private static int accountsCount = 0;


    public BankAccount(String owner, String accountNumber) {
        this(owner, accountNumber, 0);
    }

    public BankAccount(String owner, String accountNumber, double balance) {
        String message;
        this.owner = owner;
        this.accountNumber = accountNumber;
        if (balance < 0) {
            message = "ERROR 1001: указанный баланс меньше нуля для счета, поэтому счет " + accountNumber + " будет создан с балансом = 0";
        } else {
            this.balance = balance;
            message = "Счет успешно создать, номер счета " + accountNumber;
        }
        accountsCount++;
        System.out.println(message);
    }

    public double deposit(double amount){
        String message;
        if (amount < 0){
            message = "ERROR 2001: сумма пополнения меньше 0, поэтому операция пополнения не будет произведена.";
        } else if (amount == 0){
            message = "ERROR 2002: сумма пополнения равна 0, поэтому операция пополнения не будет произведена.";
        } else {
            balance = balance + amount;
            message = "Баланс счета успешно пополнен.";
        }

        System.out.printf("%s Баланс: %.2f%n", message, balance);
        return balance;
    }

    public double withdraw(double amount){
        String message;
        if (amount < 0) {
            message = "ERROR 3001: сумма снятия меньше 0, поэтому операция снятия не будет произведена.";
        } else if (amount == 0) {
            message = "ERROR 3002: сумма снятия равна 0, поэтому операция снятия не будет произведена.";
        } else if (amount > balance) {
            message = "ERROR 3003: сумма снятия превышает сумму баланс, поэтому операция снятия не будет произведена.";
        } else {
            balance = balance - amount;
            message = "Операция успешно выполнена.";    
        }
        System.out.printf("%s Баланс: %.2f%n", message, balance);
        return balance;
    }  

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public static int getAccountsCount() {
        return accountsCount;
    }
}