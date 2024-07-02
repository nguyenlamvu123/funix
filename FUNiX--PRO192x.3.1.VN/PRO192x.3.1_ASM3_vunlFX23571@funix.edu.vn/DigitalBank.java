import java.util.UUID;
import java.util.ArrayList;

class DigitalBank extends Bank {  // định nghĩa cho class quản lý ngân hàng tiềm năng
	private String id = String.valueOf(UUID.randomUUID());
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	void DigitalBank() {}

	Customer getCustomerById(String CCCD) {
		boolean datontai = false;
		for (Customer cus: customers) {
			if (cus.getCustomerId().equals(CCCD)) {
				return cus;
			}
		}
		return null;
	}

	void addCustomer(String customerId, String name) {
		Customer cu = new Customer(name, customerId);
		this.addCustomer(cu);
	}

	void withdraw(String customerId, String accountNumber, double amount) {
		Customer cus = getCustomerById(customerId);
		if (cus != null) {
			cus.withdraw();
		}
	}
}