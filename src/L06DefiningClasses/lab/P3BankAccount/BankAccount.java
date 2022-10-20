package L06DefiningClasses.lab.P3BankAccount;

public class BankAccount {
    private static double interest = 0.02;
    private static int nextId = 1;

    private double balance;
    private int id;

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }

    public static void setInterestRate(double newInterest) {
        interest = newInterest;
    }

    public double getInterest(int years) {
        return interest * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance +=  amount;
    }

    public int getId() {
        return this.id;
    }
}
