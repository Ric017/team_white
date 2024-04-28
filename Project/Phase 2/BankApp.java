package Phase2;
/*
 * You will write a Java application to simulate a simple (unrealistic) bank system. This 
 * bank supports three different kinds of accounts: Checking, Gold, and Regular. 
 * Information common to all account types include account number, balance, and 
 * customer information (customer ID, customer name, etc) of the customer who owns 
 * the account.
 * 
 * The Checking account is interest free and charges transaction fees. The first two 
 * monthly transactions are free. It charges a $3 fee for every extra transaction (deposit, 
 * withdrawal).
 * 
 * The Gold account gives a fixed interest at 5% while the Regular account gives fixed 
 * interest at 6%. Regular accounts are charged $10 monthly as a maintenance fee.
 * 
 * Whenever a withdrawal from a Regular or a Checking account is attempted and the 
 * given value is higher than the account's current balance, only the money currently 
 * available on the account is withdrawn. Unlike all other accounts, a Gold account 
 * holder can withdraw indefinitely. There is no transaction fee for customers with Gold 
 * or Regular accounts.
 * 
 * The system is host-centered program currently supporting only one kind of user – a 
 * bank operator who accesses the system to perform regular system administrative work.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp extends Application {
    private List<Account> accounts = new ArrayList<>();
    private TextArea outputArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bank System");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Text Fields and Labels
        TextField nameField = new TextField();
        TextField idField = new TextField();
        TextField accNumField = new TextField();
        TextField amountField = new TextField();

        grid.add(new Label("Customer Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Customer ID:"), 0, 1);
        grid.add(idField, 1, 1);
        grid.add(new Label("Account Number:"), 0, 2);
        grid.add(accNumField, 1, 2);
        grid.add(new Label("Amount:"), 0, 3);
        grid.add(amountField, 1, 3);

        // Buttons
        Button createCheckingButton = new Button("Create Checking Account");
        Button createGoldButton = new Button("Create Gold Account");
        Button createRegularButton = new Button("Create Regular Account");
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button displayInfoButton = new Button("Display Account Info");
        Button removeAccountButton = new Button("Remove Account");
        Button applyMonthEndButton = new Button("Apply End of Month");
        Button displayStatsButton = new Button("Display Bank Statistics");

        // Buttons to Grid
        grid.add(createCheckingButton, 2, 0);
        grid.add(createGoldButton, 2, 1);
        grid.add(createRegularButton, 2, 2);
        grid.add(depositButton, 2, 3);
        grid.add(withdrawButton, 2, 4);
        grid.add(displayInfoButton, 2, 5);
        grid.add(removeAccountButton, 2, 6);
        grid.add(applyMonthEndButton, 2, 7);
        grid.add(displayStatsButton, 2, 8);

        // Output Area
        grid.add(outputArea, 0, 9, 3, 1);

        // Button events
        createCheckingButton.setOnAction(e -> createCheckingAccount(nameField.getText(), idField.getText()));
        createGoldButton.setOnAction(e -> createGoldAccount(nameField.getText(), idField.getText()));
        createRegularButton.setOnAction(e -> createRegularAccount(nameField.getText(), idField.getText()));
        depositButton.setOnAction(e -> deposit(Integer.parseInt(accNumField.getText()), Double.parseDouble(amountField.getText())));
        withdrawButton.setOnAction(e -> withdraw(Integer.parseInt(accNumField.getText()), Double.parseDouble(amountField.getText())));
        displayInfoButton.setOnAction(e -> displayAccountInfo(Integer.parseInt(accNumField.getText())));
        removeAccountButton.setOnAction(e -> removeAccount(Integer.parseInt(accNumField.getText())));
        applyMonthEndButton.setOnAction(e -> applyEndOfMonth());
        displayStatsButton.setOnAction(e -> displayBankStatistics());

        // Setup scene and stage
        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createCheckingAccount(String customerName, String customerId) {
        Customer customer = new Customer(customerId, customerName);
        Account account = new Checking(0, customer);
        accounts.add(account);
        outputArea.setText("Checking account created for " + customerName + " with ID " + customerId);
    }

    private void createGoldAccount(String customerName, String customerId) {
        Customer customer = new Customer(customerId, customerName);
        Account account = new Gold(0, customer);
        accounts.add(account);
        outputArea.setText("Gold account created for " + customerName + " with ID " + customerId);
    }

    private void createRegularAccount(String customerName, String customerId) {
        Customer customer = new Customer(customerId, customerName);
        Account account = new Regular(0, customer);
        accounts.add(account);
        outputArea.setText("Regular account created for " + customerName + " with ID " + customerId);
    }

    private void deposit(int accountNumber, double amount) {
        Account account = accounts.stream()
                                  .filter(a -> a.getAccountNumber() == accountNumber)
                                  .findFirst()
                                  .orElse(null);
        if (account != null) {
            account.deposit(amount);
            outputArea.setText("Deposited $" + amount + " to account #" + accountNumber);
        } else {
            outputArea.setText("Account not found");
        }
    }

    private void withdraw(int accountNumber, double amount) {
        Account account = accounts.stream()
                                  .filter(a -> a.getAccountNumber() == accountNumber)
                                  .findFirst()
                                  .orElse(null);
        if (account != null) {
            account.withdraw(amount);
            outputArea.setText("Withdrew $" + amount + " from account #" + accountNumber);
        } else {
            outputArea.setText("Account not found");
        }
    }

    private void displayAccountInfo(int accountNumber) {
        Account account = accounts.stream()
                                  .filter(a -> a.getAccountNumber() == accountNumber)
                                  .findFirst()
                                  .orElse(null);
        if (account != null) {
            outputArea.setText(account.toString());
        } else {
            outputArea.setText("Account not found");
        }
    }

    private void removeAccount(int accountNumber) {
        Account account = accounts.stream()
                                  .filter(a -> a.getAccountNumber() == accountNumber)
                                  .findFirst()
                                  .orElse(null);
        if (account != null) {
            accounts.remove(account);
            outputArea.setText("Removed account #" + accountNumber);
        } else {
            outputArea.setText("Account not found");
        }
    }

    private void applyEndOfMonth() {
        accounts.forEach(Account::applyEndOfMonth);
        outputArea.setText("Applied end of month processing");
    }

    private void displayBankStatistics() {
        double totalBalance = accounts.stream().mapToDouble(Account::getBalance).sum();
        int zeroBalanceAccounts = (int) accounts.stream().filter(a -> a.getBalance() == 0).count();
        double maxBalance = accounts.stream().mapToDouble(Account::getBalance).max().orElse(0);
        int maxBalanceAccountNumber = accounts.stream()
                                              .max((a1, a2) -> Double.compare(a1.getBalance(), a2.getBalance()))
                                              .map(Account::getAccountNumber)
                                              .orElse(-1);

        outputArea.setText(
        		"Total balance: $" + totalBalance + "\n" + 
        		"Zero balance accounts: " + zeroBalanceAccounts + "\n" +
        		"Number of accounts: " + accounts.size() + "\n" +
        		"Highest balance account: #" + maxBalanceAccountNumber + " : $" + maxBalance + "");
    }
}
