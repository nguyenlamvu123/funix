import java.util.UUID;
import java.util.ArrayList;

class Bank {  // quản lý thông tin ngân hàng
	private String id = String.valueOf(UUID.randomUUID());
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	void Bank() {
		this.id = id;
	}

	void addCustomerToBank(ArrayList<Customer> customers, Customer newCustomer) {
		boolean datontai = false;
		for (Customer cus: customers) {
			if (cus.getCustomerId().equals(newCustomer.getCustomerId())) {
				System.out.println("So CCCD da ton tai!");
				datontai = true;
				break;
			}
		}
		if (!datontai) {
			customers.add(newCustomer);
		}
	}

	void addCustomer(Customer newCustomer) {
		addCustomerToBank(customers, newCustomer);
	}

	boolean isCustomerExisted(String customerId) {
		for (Customer cu: customers) {
			if (cu.getCustomerId().equals(customerId)) {
				return true;
			}
		}
		return false;
	}

	void setId(String id) {
		this.id = id;
	}

	String getId() {
		return id;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
}