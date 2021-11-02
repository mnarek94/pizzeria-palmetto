
package pizzeria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Order extends Pizza {
    private static int orderNumber;

    private Customer customer;
    private final Map<Pizza, Integer> pizzas = new HashMap<>();


    public Order(Customer customer) {

        this.customer = customer;


    }

    public Order() {

    }



    void addCostumer(String name,int costumerNumber) {
        customer = new Customer(name);
        customer.setCustomerNumber(costumerNumber);
    }

    void addPizza(Integer quantity, Pizza pizza) {
        for (Map.Entry<Pizza, Integer> map : pizzas.entrySet()) {

            if (pizza.equals(map.getKey())) {
                pizzas.put(pizza, quantity);
            }
        }
        pizzas.put(pizza, quantity);
    }

    void printCheck() {
        double totalAmount = 0;
        System.out.println("Order: " + orderNumber);

        System.out.println("Client: " + customer.getCustomerNumber());


        for (Map.Entry<Pizza, Integer> map : pizzas.entrySet()) {
            double sum = 0d;
            System.out.println("Name: " + map.getKey().getName());
            System.out.println("---------------------------------");
            System.out.println("Pizza Base: " + "(" + map.getKey().getPizzaType().getName() + ")" + map.getKey().getPizzaType().getPrice());
            List<Ingredients> ingredients = map.getKey().getIngredients();
            for (Ingredients ingredient : ingredients) {
                System.out.println(ingredient.getName() + " " + ingredient.getPrice());
                sum += ingredient.getPrice();
            }
            System.out.println("---------------------------------");
            totalAmount += (sum + map.getKey().getPizzaType().getPrice()) * map.getValue();
            System.out.println("Amount: " + (sum + map.getKey().getPizzaType().getPrice()));
            System.out.println("Quantity: " + map.getValue());
            System.out.println("---------------------------------\n");

        }
        System.out.println("Total Amount: " + totalAmount);


    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Pizza, Integer> getPizza() {
        return pizzas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(customer, order.customer) && Objects.equals(pizzas, order.pizzas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, customer, pizzas);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customer=" + customer +
                ", pizza=" + pizzas +
                '}';
    }
}