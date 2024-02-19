/*
 * Assignment 2, Exercise 3
 * 
 * @author Team White
 * @date 2024-02-03
 */
import java.util.Scanner;

class UserAccounts {

    private Scanner input = new Scanner(System.in);
    private Account[] accounts = new Account[8];

    public static void main(String[] args) {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.run();
    }

    /*
     * Constructor that creates 8 accounts with ids 0 through 7 and initial balance of $50 for each account
     */
    public UserAccounts() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 50, 0);
        }
    }

    /*
     * Main menu
     * Asks the user to enter a specific id
     * Displays a menu for the user to select from
     * 
     * @return void
     */
    public void run() {
        while (true) {
            // Prompt user to enter an id
            System.out.print("Enter an id: ");

            int id = input.nextInt();

            if (id < 0 || id > 7) {
                System.out.println("Invalid id");
                continue;
            }

            // Get the requested account
            Account account = this.accounts[id];

            while (true && account != null) {
                System.out.println("Main menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("The balance is " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to withdraw: ");
                        account.withdraw(input.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter an amount to deposit: ");
                        account.deposit(input.nextDouble());
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                if (choice == 4) {
                    break;
                }
                System.out.println("");
            }
        }
    }
}