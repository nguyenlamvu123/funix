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
}