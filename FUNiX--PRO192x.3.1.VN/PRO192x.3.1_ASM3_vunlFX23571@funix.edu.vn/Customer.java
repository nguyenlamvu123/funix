import java.util.ArrayList;

class Customer extends User {  // quản lý thông tin khách hàng
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private ArrayList<SavingsAccount> debit_accounts = new ArrayList<SavingsAccount>();
	private ArrayList<LoansAccount> credit_accounts = new ArrayList<LoansAccount>();

	Customer(String name, String customerId) {
		super(name, customerId);
		this.accounts = accounts;
	}

	ArrayList<Account> getAccounts() {
		return accounts;
	}

	ArrayList<SavingsAccount> getdebitAccounts() {
		return debit_accounts;
	}

	ArrayList<LoansAccount> getcreditAccounts() {
		return credit_accounts;
	}

	String isPremiumAccount() {
		for (Account acc: accounts) {
			if (acc.isPremiumAccount()) {
				return "Premium";
			}
		}
		return "Normal";
	}

	void addAccount(Account newAccount) {
		boolean flag = true;
		String newAccountnumber = newAccount.getAccountNumber();
		for (Account acc: accounts) {
			if (newAccountnumber.equals(acc.getAccountNumber())) {
				System.out.println("so tai khoan da ton tai!");
				flag = false;
				break;
			}
		}
		if (flag) {
			credit_accounts.add(newAccount);
			System.out.println("Da them khach hang " + newAccountnumber + " vao danh sach!");
		}
	}

	void add_debit_Account(SavingsAccount newAccount) {
		boolean flag = true;
		String newAccountnumber = newAccount.getAccountNumber();
		for (Account acc: accounts) {
			if (newAccountnumber.equals(acc.getAccountNumber())) {
				System.out.println("so tai khoan da ton tai!");
				flag = false;
				break;
			}
		}
		if (flag) {
			debit_accounts.add(newAccount);
			System.out.println("Da them khach hang " + newAccountnumber + " vao danh sach!");
		}
	}

	void add_credit_Account(LoansAccount newAccount) {
		boolean flag = true;
		String newAccountnumber = newAccount.getAccountNumber();
		for (Account acc: accounts) {
			if (newAccountnumber.equals(acc.getAccountNumber())) {
				System.out.println("so tai khoan da ton tai!");
				flag = false;
				break;
			}
		}
		if (flag) {
			credit_accounts.add(newAccount);
			System.out.println("Da them khach hang " + newAccountnumber + " vao danh sach!");
		}
	}

	double get_debit_Balance() {
		double sodu = 0;
		String name = "";
		name = this.getName();
		for (SavingsAccount da: debit_accounts) {
			sodu += da.getBalance();
		}
		return sodu;
	}

	double get_credit_Balance() {
		double sodu = 0;
		String name = "";
		name = this.getName();
		for (LoansAccount acc: credit_accounts) {
			sodu += acc.getBalance();
		}
		return sodu;
	}

	double getBalance() {
		double sodu = 0;
		String name = "";
		name = this.getName();
		for (Account acc: accounts) {
			sodu += acc.getBalance();
		}
		sodu += this.get_debit_Balance();
		sodu += this.get_credit_Balance();
		// System.out.println("Khach hang" + name + " co so du la " + sodu);
		return sodu;
	}

	void displayInformation() {
		int thutu = 1;
		String p = this.isPremiumAccount();
		System.out.println(this.getCustomerId() + "|" + this.getName() + "  |" + p + "   |" + this.getBalance());
		for (LoansAccount la: credit_accounts) {
			System.out.println(thutu + "     " + la.getAccountNumber() + "| LOANS         |         " + la.getBalance());
			thutu += 1;
		}
		for (SavingsAccount da: debit_accounts) {
			System.out.println(thutu + "     " + da.getAccountNumber() + "| SAVINGS       |         " + da.getBalance());
			thutu += 1;
		}
	}
}	