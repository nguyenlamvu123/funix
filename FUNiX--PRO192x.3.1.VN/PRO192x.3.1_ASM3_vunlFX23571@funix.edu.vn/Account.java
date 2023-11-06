import java.util.ArrayList;

class Account {  // quản lý thông tin tài khoản khách hàng
	private String accountNumber;
	private double balance;

	public Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isPremiumAccount() {
		return this.balance > 10000000;
	}

	@Override
	public String toString() {
		return accountNumber + " |                 " + balance;
	}
}