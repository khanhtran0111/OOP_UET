

public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            addTransaction(new Transaction(3, amount, balance - amount, balance));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 1000) {
                throw new Exception("");
            }
            if (balance < 5000) {
                throw new Exception("");
            }
            doWithdrawing(amount);
            addTransaction(new Transaction(4, amount, balance + amount, balance));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

