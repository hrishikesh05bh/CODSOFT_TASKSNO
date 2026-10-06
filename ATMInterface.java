import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.");
        }
    }

    double checkBalance() {
        return balance;
    }
}

class ATM {
    private final BankAccount account;

    ATM(BankAccount account) {
        this.account = account;
    }

    void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    private double readAmount(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double amount = sc.nextDouble();
                if (amount > 0) {
                    return amount;
                }
            } else {
                sc.next();
            }
            System.out.println("Please enter a valid positive amount.");
        }
    }

    private int readChoice(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid choice. Please select a number from 1 to 4.");
            System.out.print("Enter your choice: ");
        }
    }

    void start() {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            do {
                showMenu();
                System.out.print("Enter your choice: ");
                choice = readChoice(sc);

                switch (choice) {
                    case 1 -> System.out.println("Current Balance: ₹" + account.checkBalance());
                    case 2 -> {
                        double depositAmount = readAmount(sc, "Enter amount to deposit: ₹");
                        account.deposit(depositAmount);
                    }
                    case 3 -> {
                        double withdrawAmount = readAmount(sc, "Enter amount to withdraw: ₹");
                        account.withdraw(withdrawAmount);
                    }
                    case 4 -> System.out.println("Thank you for using the ATM.");
                    default -> System.out.println("Invalid choice.");
                }

            } while (choice != 4);
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        ATM atm = new ATM(account);
        atm.start();
    }
}

