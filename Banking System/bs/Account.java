

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account {
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<Transaction>();
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    public Account() {

    }

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Class method.
     */
    public void doWithdrawing(double amount)
            throws InsufficientFundsException, InvalidFundingAmountException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        balance -= amount;
    }

    /**
     * Class method.
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        balance += amount;
    }

    /**
     * Class method.
     */
    public String getTransactionHistory() {
        StringBuilder builder = new StringBuilder("Lịch sử giao dịch của tài khoản ");
        builder.append(accountNumber).append(":\n");
        if (transactionList.isEmpty()) {
            builder.append("No transactions found");
        } else {
            for (Transaction transaction : transactionList) {
                builder.append(transaction.getTransactionSummary()).append("\n");
            }
        }
        return builder.toString();
    }

    /**
     * Class method.
     */
    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionList.add(transaction);
        }
    }

    /**
     * Class method.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}
