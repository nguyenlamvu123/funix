import java.util.ArrayList;

class User {  // quản lý thông tin người dùng của hệ thống
	private String name;
	private String customerId;

	public User(String name, String customerId) {
		this.name = name;
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String cutomerId) {
		this.customerId = customerId;
	}
}