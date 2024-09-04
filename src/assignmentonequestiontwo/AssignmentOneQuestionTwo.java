package assignmentonequestiontwo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kgothatso Magwaza ST10456830
 */
public class AssignmentOneQuestionTwo {

   
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
    
        System.out.println("Receipt Management Application");
        System.out.println("**********************************");
        System.out.println("Enter (1) to launch menu or enter any other to exit");

        String choices = input.next();
        if (choices.equals("1")) {
            boolean isMenu = false;
            while (!isMenu) {
                isMenu = true;
                System.out.println("Please Select one of the following menu items:\n"
                    + "1) Capture a new receipt. \n"
                    + "2) Search for a receipt. \n"
                    + "3) Delete a receipt. \n"
                    + "4) Print receipt report. \n"
                    + "5) Exit Application.");

                String options = input.next();

                if (options.equals("1")) { // Capture a new receipt
                    Receipts newReceipt = new Receipts();

                    System.out.println("Enter the receipt number");
                    String number = input.next();
                    newReceipt.setReceiptNumber(number);

                    System.out.println("Enter the receipt amount");
                    String amount = input.next();
                    newReceipt.setAmount(amount);

                    System.out.println("Enter the receipt date (YYYY-MM-DD)");
                    String date = input.next();
                    newReceipt.setDate(date);

                    System.out.println("Enter the payer name");
                    String payerName = input.next();
                    newReceipt.setPayerName(payerName);

                    Receipts receiptHandler = new Receipts();
                    boolean exists = receiptHandler.saveReceipt(newReceipt);

                    if (!exists) {
                        System.out.println("Receipt information saved successfully");
                    } else {
                        System.out.println("Receipt already exists");
                    }

                    System.out.println("*********************************************************");
                    System.out.println("Captured Receipt Details:");
                    System.out.println("*********************************************************");
                    System.out.println("Receipt Number: " + newReceipt.getReceiptNumber());
                    System.out.println("Amount: " + newReceipt.getAmount());
                    System.out.println("Date: " + newReceipt.getDate());
                    System.out.println("Payer Name: " + newReceipt.getPayerName());
                    System.out.println("*********************************************************");

                    System.out.println("Enter (1) to launch menu or enter any other to exit");
                    int launch = input.nextInt();
                    if (launch == 1) {
                        isMenu = false;
                    } else {
                        System.exit(0);
                    }

                } else if (options.equals("2")) { // Search for a receipt
                    Receipts receiptHandler = new Receipts();
                    System.out.print("Enter the receipt number to search: ");
                    String number = input.next();
                    Receipts search = receiptHandler.searchReceipt(number);

                    if (search != null) {
                        System.out.println("*************************************");
                        System.out.println("Receipt Number: " + search.getReceiptNumber());
                        System.out.println("Amount: " + search.getAmount());
                        System.out.println("Date: " + search.getDate());
                        System.out.println("Payer Name: " + search.getPayerName());
                        System.out.println("*************************************");
                    } else {
                        System.out.println("*************************************");
                        System.out.println("Receipt with number " + number + " was not found");
                        System.out.println("*************************************");
                    }

                    System.out.println("Enter (1) to launch menu or enter any other to exit");
                    int launch = input.nextInt();
                    if (launch == 1) {
                        isMenu = false;
                    } else {
                        System.exit(0);
                    }

                } else if (options.equals("3")) { // Delete a receipt
                    Receipts receiptHandler = new Receipts();
                    System.out.print("Enter the receipt number to delete: ");
                    String number = input.next();
                    System.out.println("Are you sure you want to delete receipt from the system? Yes(y) to delete");
                    String press = input.next();

                    if (press.equals("y")) {
                        boolean delete = receiptHandler.deleteReceipt(number);
                        if (delete) {
                            System.out.println("*************************************");
                            System.out.println("Receipt with number " + number + " was deleted");
                            System.out.println("*************************************");
                        }
                    } else {
                        System.out.println("Receipt " + number + " was not deleted");
                    }

                    System.out.println("Enter (1) to launch menu or enter any other to exit");
                    int launch = input.nextInt();
                    if (launch == 1) {
                        isMenu = false;
                    } else {
                        System.exit(0);
                    }

                } else if (options.equals("4")) { // Print receipt report
                    Receipts receiptHandler = new Receipts();
                    ArrayList<Receipts> results = receiptHandler.printReceipts();

                    if (!results.isEmpty()) {
                        for (int i = 0; i < results.size(); i++) {
                            Receipts receipt = results.get(i);
                            System.out.println("Receipt " + (i + 1));
                            System.out.println("*******************************************************");
                            System.out.println("Receipt Number: " + receipt.getReceiptNumber());
                            System.out.println("Amount: " + receipt.getAmount());
                            System.out.println("Date: " + receipt.getDate());
                            System.out.println("Payer Name: " + receipt.getPayerName());
                            System.out.println("*******************************************************");
                        }
                    } else {
                        System.out.println("No receipts found in the list.");
                    }

                    System.out.println("Enter (1) to launch menu or enter any other to exit");
                    int launch = input.nextInt();
                    if (launch == 1) {
                        isMenu = false;
                    } else {
                        System.exit(0);
                    }

                } else if (options.equals("5")) { // Exit Application
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
    
}
