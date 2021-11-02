package pizzeria;

import java.util.Objects;

public class Customer {
    private String name;
    private int customerNumber;

    public Customer() {

    }

    public Customer(String name) {
        this.name = name;


    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(customerNumber, customer.customerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customerNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}