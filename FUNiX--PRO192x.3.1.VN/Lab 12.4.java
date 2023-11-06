public class Entry {
	public static void main(String[] args) {
		Customer customer1 = new Customer(1000, "Tuan", 20);
		Invoice invoice1 = new Invoice(1000, customer1, 100000);
		System.out.println("Customer name: " + invoice1.getCustomerName());
		System.out.println("Invoice after discount: " + invoice1.getAmountAfterDiscount());
	}
}

class Customer {
    private String name;
    private int id;
    private int discount;

    Customer(int id, String name, int discount) {
        this.name = name;
        this.discount = discount;
        this.id = id;
    }

    void setName(String x) {
        this.name = x;
    }

    void setDiscount(int x) {
        this.discount = x;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getDiscount() {
        return discount;
    }
}

class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    int getId() {
        return id;
    }

    void setCustomer(Customer x) {
        this.customer = x;
    }

    void setAmount(int x) {
        this.amount = x;
    }

    Customer getCustomer() {
        return customer;
    }

    double getAmount() {
        return amount;
    }

    String getCustomerName() {
        return customer.getName();
    }
    
    double getAmountAfterDiscount() {
    	// System.out.println(amount);
    	// System.out.println(customer.discount);
    	return amount - amount * customer.getDiscount()/100;
    }
}
