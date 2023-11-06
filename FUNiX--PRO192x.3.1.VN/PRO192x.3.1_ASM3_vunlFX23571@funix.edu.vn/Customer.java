import java.util.ArrayList;

class Customer extends User {  // quản lý thông tin khách hàng
	private ArrayList<Account> accounts = new ArrayList<Account>();

	Customer(String name, String customerId) {
		super(name, customerId);
		this.accounts = accounts;
	}

	ArrayList<Account> getAccounts(String customerId) {
		return accounts;
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
			accounts.add(newAccount);
			System.out.println("Da them khach hang " + newAccountnumber + " vao danh sach!");
		}
	}

	double getBalance() {
		double sodu = 0;
		String name = "";
		name = this.getName();
		for (Account acc: accounts) {
			sodu += acc.getBalance();
		}
		// System.out.println("Khach hang" + name + " co so du la " + sodu);
		return sodu;
	}

	void displayInformation() {
		String p = this.isPremiumAccount();
		System.out.println(this.getCustomerId() + "    |" + this.getName() + "  |" + p + "   |" + this.getBalance());
	}
}	