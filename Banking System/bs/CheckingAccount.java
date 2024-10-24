

public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            addTransaction(new Transaction(1, amount, balance - amount, balance));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
            addTransaction(new Transaction(2, amount, balance + amount, balance));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
