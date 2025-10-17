package com.pluralsight;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AccountingLedger {
    private static final String FILE_NAME = "transactions.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public AccountingLedger() throws IOException {
    }

    public static void main(String[] args) {

        System.out.println("|************************************************|");
        System.out.println("|Welcome To Your Personalized Accounting Ledger! |");
        System.out.println("|************************************************|");

        boolean running = true;
        while (running) {
            System.out.println("\nHome Screen:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exiting: Goodbye!");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "D":
                    addTransaction(true);
                    break;
                case "P":
                    addTransaction(false);
                    break;
                case "L":
                    ledgerMenu();
                    break;
                case "X":
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    //------------ ADD DEPOSIT ------------

    private static <Transaction> void addTransaction(boolean isDeposit) {
        try {
            System.out.print("Enter description: ");
            String description = scanner.nextLine();
            System.out.print("Enter vendor: ");
            String vendor = scanner.nextLine();
            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (!isDeposit) {
                amount = -Math.abs(amount);
            }

        } catch (Exception e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    private static <Transaction> void saveTransaction(Transaction t) {
    }


    //============ LEDGER MENU ============
    private static <Transaction> void ledgerMenu() {
        boolean backToHome = false;
        while (!backToHome) {
            System.out.println("\nLedger Menu:");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits Only");
            System.out.println("P) Payments Only");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            ArrayList<Transaction> transactions = new ArrayList<>();

            switch (choice) {
                case "A":
                    new displayTransactions(transactions);
                    break;
                case "D":
                    int getTransactions = 0;
                    new displayTransactions(transactions.stream().filter(t -> (getTransactions) > 0).toList());
                    break;
                case "P":
                    getTransactions = 0;
                    new displayTransactions(transactions.stream().filter(t -> (getTransactions) < 0).toList());
                    break;
                case "R":
                    reportMenu(transactions);
                    break;
                case "H":
                    backToHome = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }  // ============ Reports Menu ============
    private static <Transaction> void reportMenu(List<Transaction> transactions) {
        boolean back = false;
        while (!back) {
            System.out.println("\nReports Menu:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            String choice = AccountingLedger.scanner.nextLine().trim();



        }
    } BufferedReader reader = new BufferedReader
            (new FileReader("C:\\Users\\Student\\pluralsight\\capstone-1\\untitled\\src\\main\\resources"));
}














