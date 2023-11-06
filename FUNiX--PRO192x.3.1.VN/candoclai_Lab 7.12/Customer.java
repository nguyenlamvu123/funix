package com.learnJava;

import java.util.ArrayList;

public class Customer {  // Class Customer bao gồm: name và mảng doubles
	
	private String name;
	private ArrayList<Double> transactions;  // Mỗi Customer phải có một danh sách các giao dịch – mảng transactions

	// Constructor
	public Customer(String name, double initialAmount) {  // xây dựng hàm constructor bao gồm tên khách hàng và số tiền giao dịch ban đầu
		this.name = name;
		this.transactions = new ArrayList<Double>();
		addTransaction(initialAmount);  // Sau đó sửa lại constructor để thêm giao dịch đầu tiên vào mảng
	}
	
	// Methods
	public void addTransaction(double amount) {  // Thêm phương thức addTransaction() nhận đầu vào là số tiền giao dịch
		this.transactions.add(amount);
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Double> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Double> transactions) {
		this.transactions = transactions;
	}
	
}
