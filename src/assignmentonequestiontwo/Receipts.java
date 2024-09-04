/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentonequestiontwo;

import java.util.ArrayList;

/**
 *
 * @author themb
 */
public class Receipts {
    static ArrayList<Receipts> receiptsList = new ArrayList<Receipts>();

    String receiptNumber;
    String amount;
    String date;
    String payerName;

    public Receipts() {
        receiptNumber = "";
        amount = "";
        date = "";
        payerName = "";
    }

    // Setters
    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    // Getters
    public String getReceiptNumber() {
        return receiptNumber;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getPayerName() {
        return payerName;
    }

    // Methods
    public boolean saveReceipt(Receipts receipt) {
        boolean exists = false;
        for (Receipts r : receiptsList) {
            if (r.getReceiptNumber().equals(receipt.getReceiptNumber())) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            receiptsList.add(receipt);
        }
        return exists;
    }

    public Receipts searchReceipt(String receiptNumber) {
        for (Receipts r : receiptsList) {
            if (r.getReceiptNumber().equals(receiptNumber)) {
                return r;
            }
        }
        return null;
    }

    public boolean deleteReceipt(String receiptNumber) {
        for (Receipts r : receiptsList) {
            if (r.getReceiptNumber().equals(receiptNumber)) {
                receiptsList.remove(r);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Receipts> printReceipts() {
        return receiptsList;
    }
}
