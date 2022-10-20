package L06DefiningClasses.lab.P3BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            //•	Create
            //•	Deposit {Id} {Amount}
            //•	SetInterest {Interest}
            //•	GetInterest {ID} {Years}
            //•	End

            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    int key = account.getId();
                    bankAccounts.put(key, account);
                    System.out.println("Account ID" + account.getId() + " created");
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);

                    BankAccount acc = bankAccounts.get(id);
                    if(acc != null) {
                        acc.deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n",amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int ID = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    BankAccount acc1 = bankAccounts.get(ID);
                    if(acc1 != null) {
                        System.out.printf("%.2f%n", acc1.getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
