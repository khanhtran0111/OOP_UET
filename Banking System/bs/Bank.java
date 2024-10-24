

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<Customer>();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Class method.
     */
    public void readCustomerList(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            Customer customer = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[0].matches("\\d{10}") && customer != null) {
                    long accountNumber = Long.parseLong(data[0]);
                    String accType = data[1];
                    double balance = Double.parseDouble(data[2]);
                    if (accType.equals("CHECKING")) {
                        customer.addAccount(new CheckingAccount(accountNumber, balance));
                    } else if (accType.equals("SAVINGS")) {
                        customer.addAccount(new SavingsAccount(accountNumber, balance));
                    }
                } else {
                    String fullName = line.substring(0, line.lastIndexOf(" "));
                    long idNumber = Long.parseLong(data[data.length - 1]);
                    customer = new Customer(idNumber, fullName);
                    customerList.add(customer);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Class method.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return Long.compare(c1.getIdNumber(), c2.getIdNumber());
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customerList) {
            stringBuilder.append(customer.getCustomerInfo()).append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Class method.
     */
    public String getCustomersInfoByNameOrder() {
        customerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return c1.getFullName().compareTo(c2.getFullName());
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customerList) {
            stringBuilder.append(customer.getCustomerInfo()).append("\n");
        }
        return stringBuilder.toString();
    }
}
