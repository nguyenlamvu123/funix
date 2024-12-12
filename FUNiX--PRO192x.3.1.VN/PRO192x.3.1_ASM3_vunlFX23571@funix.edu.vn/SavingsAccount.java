class SavingsAccount extends Account implements ReportService, Withdraw {
	static int SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

	SavingsAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}
	
	public void addAcount(String customerId, Account account) {
		for (Customer: customer) {
			if (customer.getCustomerId().equals(customerId)) {
				customer.addAccount(account);
				break;
			}
		}
	}

	@Override
	public boolean isAccepted(double amount) {  // Số tiền rút phải lớn hơn hoặc bằng 50.000đ
		if (amount < 50000) return false;
		return true;
	}

	@Override
	public boolean setBalance(double amount, Customer cu) {  // Số dư còn lại sau khi rút phải lớn hơn hoặc bằng 50.000đ
		double sodu = cu.get_debit_Balance() - amount;
		if (sodu < 50000) return false;
		else return true;
	}

	@Override
	public boolean withdraw(double amount, Customer cu) {
		if (isAccepted(amount)) {
			if (setBalance(amount, cu)) return true;
		}
		return false;	
	}
}