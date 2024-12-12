class LoansAccount extends Account implements ReportService, Withdraw {  // định nghĩa cho class quản lý tài khoản của khách hàng
	// static float LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;  // định nghĩa phí rút tiền cho tài khoản
	// static float LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;  // định nghĩa phí rút tiền tài khoản premium
	static double LOAN_ACCOUNT_MAX_BALANCE = 100000000;  // định nghĩa hạn mức tối đa cho loại tài khoản này

	LoansAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

	@Override
	public boolean isAccepted(double amount) {  // Hạn mức không được quá giới hạn 100.000.000đ
		if (amount > 100000000) return false;
		return true;
	}

	@Override
	public boolean setBalance(double amount, Customer cu) {  // Hạn mức còn lại sau khi rút tiền không được nhỏ hơn 50.000đ
		double sodu = cu.get_credit_Balance() - amount;
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