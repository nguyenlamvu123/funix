package com.learnJava;

import java.util.ArrayList;

public class Branch {  // Chi nhánh – lớp Branch có thể thêm khách hàng mới và khởi tạo số tiền giao dịch ban đầu và cũng có thể thêm các giao dịch bổ sung cho khách hàng trong chi nhánh đó

	private String name;
	private ArrayList<Customer> customerList;  // 

	// Constructor
	public Branch(String name) {  // xây dựng hàm constructor khởi tạo chi nhánh với trường name
		this.name = name;
		this.customerList = new ArrayList<Customer>();
	}
	
	// Methods
	public boolean newCustomer(String customerName, double initialAmount) {  // Tạo phương thức newCustomer để thêm mới khách hàng vào chi nhánh, phương thức nhận đầu vào là tên khách hàng và khoản tiền giao dịch ban đầu
		if(findCustomer(customerName) == null) {
			this.customerList.add(new Customer(customerName, initialAmount));
			return true;
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String customerName, double amount) {  // Tạo phương thức addCustomerTransaction để thêm giao dịch mới cho khách hàng có trong chi nhánh
		Customer existingCustomer = findCustomer(customerName);  // trước khi thêm giao dịch mới cho khách hàng cần kiểm tra xem khách hàng đó đã có trong chi nhánh hay chưa
		if(existingCustomer != null) {
			existingCustomer.addTransaction(amount);
			return true;
		}
		return false;
	}
	
	public Customer findCustomer(String customerName) {  // trước khi thêm khách hàng mới vào mảng cần kiểm tra người dùng đó đã tồn tại trong chi nhánh hay chưa thông qua name
		for(int i = 0; i < this.customerList.size(); i++) {
			if(this.customerList.get(i).getName().equals(customerName)) {
				return this.customerList.get(i);
			}
		}
		return null;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
}
