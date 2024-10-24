

import java.text.DecimalFormat;

public class InvalidFundingAmountException extends BankException {
    public InvalidFundingAmountException(double amount) {
        super("Số tiền không hợp lệ: $" + new DecimalFormat("#.00").format(amount));
    }
}

