import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        System.out.println(BankAccount.GenerateAccountNumber());
        mainLoop(bankAccounts);

    }

    public static void mainLoop(ArrayList<BankAccount> bankAccounts) {
        execute(showPrompt(), bankAccounts);

    }

    public static int showPrompt() {
        Object[] options = {"Add an Account", "Show Account Details", "Make Deposit", "Withdraw Balance", "Check Balance", "Show All Account Name" ,"Exit"};
        return JOptionPane.showOptionDialog(null, "Choose an Option", "Bank Account", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void execute(int option, ArrayList<BankAccount> bankAccounts){
      switch (option){
          case 0:
              bankAccounts.add(BankAccount.createAccount());
              mainLoop(bankAccounts);
              break;
          case 1:
              BankAccount temp = BankAccount.searchAccount(bankAccounts);
              if(temp != null){
                  temp.details();
              }
              else {
                  showMessage("No Account Found");
              }
              mainLoop(bankAccounts);
              break;
          case 2:
              temp = BankAccount.searchAccount(bankAccounts);
              if(temp != null){
                  temp.deposit();
              }
              else {
                  showMessage("No Account Found");
              }
              mainLoop(bankAccounts);
              break;
          case 3:
              temp = BankAccount.searchAccount(bankAccounts);
              if(temp != null){
                  temp.withdraw();
              }
              else {
                showMessage("No Account Found");
              }
              mainLoop(bankAccounts);
              break;
          case 4:
              temp = BankAccount.searchAccount(bankAccounts);
              if(temp != null){
                  temp.showBalance();
              }
              else {
                  showMessage("No Account Found");
              }
              mainLoop(bankAccounts);
              break;
          case 5:
              BankAccount.showAll(bankAccounts);
              mainLoop(bankAccounts);
              break;
          default:
              break;
      }

    }
}