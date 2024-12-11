class LoansAccount extends Account implements ReportService, Withdraw {  // định nghĩa cho class quản lý tài khoản của khách hàng
	// static float LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;  // định nghĩa phí rút tiền cho tài khoản
	// static float LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;  // định nghĩa phí rút tiền tài khoản premium
	static double LOAN_ACCOUNT_MAX_BALANCE = 100000000;  // định nghĩa hạn mức tối đa cho loại tài khoản này

	LoansAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

	// @Override
	// public boolean withdraw(double amount) {
	// 	double newBalance = 0.0;
	// 	// maybe more
	// 	if (isAccepted(newBalance)) {
	// 		setBalance(newBalance);
	// 		// maybe more
	// 		return true;
	// 	}
	// 	// maybe more
	// 	return false;	
	// }
}