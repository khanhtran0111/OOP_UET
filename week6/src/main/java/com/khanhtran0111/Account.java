package com.khanhtran0111;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    private void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
        else {
            System.out.print("So tien ban nap vao khong hop le!");
        }
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
            return;
        }

        transitionList.add(new Transaction(operation, amount, balance));
    }

    /**
     * An especially short bit of Javadoc.
     */
    public void printTransaction() {
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < transitionList.size(); i++) {
            Transaction transaction = transitionList.get(i);
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transaction.getOperation().equals("deposit")) {
                System.out.println("Nap tien" + " $" + df.format(transaction.getAmount())
                        + ". So du luc nay: $" + df.format(transaction.getBalance()) + ".");
            } else {
                System.out.println("Rut tien" + " $" + df.format(transaction.getAmount())
                        + ". So du luc nay: $" + df.format(transaction.getBalance()) + ".");
            }
        }
    }

    public static void main(String[] args){
        Account acc= new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
