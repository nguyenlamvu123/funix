class SavingsAccount extend Account implements ReportService implements Withdraw {
	static int SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

	public void addAcount(String customerId, Account account) {
		for (Customer: customer) {
			if (customer.getCustomerId().equals(customerId)) {
				customer.addAccount(account);
				break;
			}
		}
	}
}