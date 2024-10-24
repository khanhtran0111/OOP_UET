

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<Account>();

    public Customer() {

    }

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Class getter.
     */
    public List<Account> getAccountList() {
        return accountList;
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
    }

    /**
     * Class method.
     */
    public void addAccount(Account account) {
        if (account != null) {
            accountList.add(account);
        }
    }

    /**
     * Class method.
     */
    public void removeAccount(Account account) {
        if (account != null) {
            accountList.remove(account);
        }
    }
}

