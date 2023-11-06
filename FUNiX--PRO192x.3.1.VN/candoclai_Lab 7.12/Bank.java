package com.learnJava;

import java.util.ArrayList;

public class Bank {  // Tạo class Bank bao gồm trường name và mảng branches


	private String name;
	private ArrayList<Branch> branchList;

	// Constructor
	public Bank(String name) {  // Xây dựng constructor nhận đầu vào là tên chi nhánh
		this.name = name;
		this.branchList = new ArrayList<Branch>();  // Class Bank có một danh sách các chi nhánh – mảng branches
	}
	
	// Methods
	public boolean addBranch(String branchName) {  // Tạo phương thức addBranch nhận đầu vào là tên chi nhánh
		if(findBranch(branchName) == null) {  // đảm bảo chi nhánh chưa tồn tại trong mảng thì mới được thêm
			this.branchList.add(new Branch(branchName));
			return true;
		}
		return false;  // Nếu tồn tại chi nhánh thì ta gọi tiếp hàm addCustomer của chi nhánh đó
	}
	
	public boolean addCustomerToBranch(String branchName, String customerName, double initialAmount) {  // Tạo phương thức addCustomer nhận đầu vào là tên khách hàng, tên chi nhánh và  giao dịch ban đầu
		Branch existingBranch = findBranch(branchName);  // kiểm tra chi nhánh đã tồn tại hay chưa, nếu chưa thì không thêm được
		if(existingBranch != null) {
			return existingBranch.newCustomer(customerName, initialAmount);  // Nếu tồn tại chi nhánh thì gọi tiếp hàm newCustomer của chi nhánh đó
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String branchName, String customerName, double amount) {  // Tạo phương thức addCustomerTransaction – thêm giao dịch cho người dùng trong chi nhánh, phương thức nhận đầu vào là tên khách hàng, tên chi nhánh và giao dịch
		Branch existingBranch = findBranch(branchName);  // kiểm tra chi nhánh đã tồn tại hay chưa, nếu chưa thì không thêm được
		if(existingBranch != null) {
			return existingBranch.addCustomerTransaction(customerName, amount);  // Nếu tồn tại chi nhánh thì gọi tiếp hàm addCustomerTransaction của chi nhánh đó
		}
		return false;
	}
	
	public boolean listCustomer(String branchName, boolean showTransaction) {  // Tạo phương thức listCustomer – hiển thị danh sách khách hàng, nhận đầu vào là tên chi nhánh và trường showTransactions kiểu boolean
		Branch existingBranch = findBranch(branchName);  // kiểm tra chi nhánh đã tồn tại hay chưa, nếu có thì mới lấy danh sách khách hàng
		if(existingBranch != null) {
			System.out.println("/*--- Customer details for branch " + existingBranch.getName() + " ---*/");
			ArrayList<Customer> branchCustomers = existingBranch.getCustomerList();
			for(int i = 0; i < branchCustomers.size(); i++) {
				System.out.println("Customer: " + branchCustomers.get(i).getName() + "[" + (i+1) + "]");
				if(showTransaction) {  // Dựa vào trường showTransactions = true thì mới hiển thị danh sách transactions cho từng khách hàng
					System.out.println("/*--- Transactions ---*/");
					ArrayList<Double> transactions = branchCustomers.get(i).getTransactions();
					for(int j = 0; j < transactions.size(); j++) {
						System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
					}
				}
			}
			return true;
			
		} else {
			return false;
		}
	}
	
	private Branch findBranch(String branchName) {
		for(int i = 0; i < this.branchList.size(); i++) {
			if(this.branchList.get(i).getName().equals(branchName)) {
				return this.branchList.get(i);
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
	
	public ArrayList<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(ArrayList<Branch> branchList) {
		this.branchList = branchList;
	}
	
}
