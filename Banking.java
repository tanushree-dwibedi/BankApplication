import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("✅ Amount deposited successfully!");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("✅ Amount withdrawn successfully!");
        } else {
            System.out.println("❌ Insufficient balance!");
        }
    }

    void display() {
        System.out.println("Account No: " + accNo + " | Name: " + name + " | Balance: ₹" + balance);
    }
}

public class Banking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[100]; // max 100 accounts
        int count = 0;
        int choice;

        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ₹");
                    double bal = sc.nextDouble();
                    accounts[count++] = new Account(accNo, name, bal);
                    System.out.println("✅ Account Created!");
                }

                case 2 -> {
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter Deposit Amount: ₹");
                    double amt = sc.nextDouble();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (accounts[i].accNo == accNo) {
                            accounts[i].deposit(amt);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ Account not found!");
                }

                case 3 -> {
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter Withdraw Amount: ₹");
                    double amt = sc.nextDouble();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (accounts[i].accNo == accNo) {
                            accounts[i].withdraw(amt);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ Account not found!");
                }

                case 4 -> {
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (accounts[i].accNo == accNo) {
                            accounts[i].display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ Account not found!");
                }

                case 5 -> {
                    if (count == 0) System.out.println("No accounts available!");
                    else {
                        System.out.println("\n=== All Accounts ===");
                        for (int i = 0; i < count; i++) accounts[i].display();
                    }
                }

                case 6 -> System.out.println("👋 Exiting...");

                default -> System.out.println("❌ Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
