import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int id;
    String name;
    double balance;

    Account(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }
}

class Transaction {
    int accountId;
    String type;
    double amount;

    Transaction(int accountId, String type, double amount) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
    }
}

public class main {

    static HashMap<Integer, Account> accounts = new HashMap<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static int accountCounter = 1;

    public static void createAccount(String name) {
        Account acc = new Account(accountCounter, name);
        accounts.put(accountCounter, acc);
        System.out.println("Account created with ID: " + accountCounter);
        accountCounter++;
    }

    public static void deposit(int id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            acc.balance += amount;
            transactions.add(new Transaction(id, "DEPOSIT", amount));
            System.out.println("Deposited: " + amount);
        }
    }

    public static void withdraw(int id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            if (acc.balance >= amount) {
                acc.balance -= amount;
                transactions.add(new Transaction(id, "WITHDRAW", amount));
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient Balance");
            }
        }
    }

    public static void showTransactions(int id) {
        for (Transaction t : transactions) {
            if (t.accountId == id) {
                System.out.println(t.type + " : " + t.amount);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Transaction History");
            System.out.println("5.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    createAccount(name);
                    break;

                case 2:
                    System.out.print("Account ID: ");
                    int id = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    deposit(id, amt);
                    break;

                case 3:
                    System.out.print("Account ID: ");
                    int id2 = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt2 = sc.nextDouble();
                    withdraw(id2, amt2);
                    break;

                case 4:
                    System.out.print("Account ID: ");
                    int id3 = sc.nextInt();
                    showTransactions(id3);
                    break;

                case 5:
                    return;
            }
        }
    }
}
