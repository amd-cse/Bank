
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    String accountNumber;
    String accountName;
    long balance;
    String accountType;
    static long numberOfAccounts = 0;
    public static String GenerateAccountNumber(){

        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        return df.format(new Date())+"0x"+numberOfAccounts;
    }
    public BankAccount(String accountNumber, String accountName, long balance, String accountType){
    this.accountNumber = accountNumber;
    this.accountName = accountName;
    this.balance = balance;
    this.accountType = accountType;
    numberOfAccounts++;
    }
    public void deposit(){
        long toAdd = Long.parseLong(showInputFor(" Amount: "));
        this.balance += toAdd;
        showMessage("Transaction Successful");

    }
    public void showBalance(){
        showMessage("Balance For Account " + this.accountNumber + " is " + this.balance);
    }
    public void withdraw(){
        long toSubtract = Long.parseLong(showInputFor(" Amount: "));
        if(toSubtract <= this.balance){
            showMessage("Transaction Successful");
            this.balance -= toSubtract;
        }
        else {
            showMessage("Transaction Failed");
        }

    }
    public void details(){
        String message = "Account Name: " + this.accountName + "\n Account Number: " + this.accountNumber;
        message += "\n Account Type: " + this.accountType;
        message += "\n Balance: " + this.balance;
        JOptionPane.showMessageDialog(null, message, "Account Details", JOptionPane.INFORMATION_MESSAGE);
    }
    public static BankAccount createAccount(){
        String accName = showInputFor("Account Name: ");
        String accType = showInputFor("Account Type: ");
        long balance = Long.parseLong(showInputFor("Balance: "));
        String accNumber = GenerateAccountNumber();
        return new BankAccount(accNumber, accName, balance, accType);
    }

    public static String showInputFor(String a){
        return JOptionPane.showInputDialog(null,"Enter "+ a);
    }
    public static BankAccount searchAccount(ArrayList<BankAccount> accounts){
        String accountName = showInputFor("Account Name: ");
        for(BankAccount ba : accounts){
            System.out.println("AccountName: " + ba.accountName);
            if(ba.accountName.equals(accountName)){
                return ba;
            }
        }
        return null;
    }
    public static void showAll(ArrayList<BankAccount> accounts){
        StringBuilder message = new StringBuilder();
        for(BankAccount ba : accounts){
            message.append("Account Name: ").append(ba.accountName).append(" Account Number: ").append(ba.accountNumber).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
