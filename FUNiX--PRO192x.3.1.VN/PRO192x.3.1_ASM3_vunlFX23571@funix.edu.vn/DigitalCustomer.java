class DigitalCustomer extends Customer {  // định nghĩa cho class quản lý thông tin khách hàng tiềm năng
	static float LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;  // định nghĩa phí rút tiền cho tài khoản
	static float LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;  // định nghĩa phí rút tiền tài khoản premium
	static double LOAN_ACCOUNT_MAX_BALANCE = 100000000;  // định nghĩa hạn mức tối đa cho loại tài khoản này

	void withdraw(String accountNumber, double amount) {
		for (Account acc: accounts) {
			if (accountNumber.equals(acc.getAccountNumber())) {
				acc.withdraw();
			}
		};
	}
}