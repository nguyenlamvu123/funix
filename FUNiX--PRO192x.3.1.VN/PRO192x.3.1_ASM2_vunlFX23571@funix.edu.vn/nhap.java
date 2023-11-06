import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Array {
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static int choice = 1;
	static Bank[] banks = new Bank[100];
	static int arr_b = 0;
	static User[] users = new User[100];
	static int arr_u = 0;
	static Customer[] cus_s = new Customer[100];
	static int arr_c = 0;
	static Account[] acc_s = new Account[100];
	static int arr_a = 0;
	public static void main(String[] args) {
		docfile("nganhangsophienban2.txt");
		while (choice != 0) {
			System.out.print("Chon chuc nang: ");
			choice = sc.nextInt();
			System.out.println("Chuc nang: " + choice);

			if (choice == 1) {
				String tenkhach = "";
				tenkhach = sc.nextLine();
				while (tenkhach.equals("")) {
					System.out.print("Nhap ten khach hang: ");
					tenkhach = sc.nextLine();
				}
				String cccdstr = "1";
				while (!cccdstr.equals("0")) {
					cccdstr = whileloop();
					if (cccdstr.equals("0")) {  // thoat vong lap while
						choice = 0;  // thoat han chuong trinh
					} else if (cccdstr.equals("1")) {  // tiep tuc vong lap while
						continue;
					} else {
						cus_s[arr_c] = new Account(tenkhach, cccdstr);
						arr_c += 1;
						System.out.println("Da them khach hang " + cccdstr + " vao danh sach!");
						break;
					}
				}
			} else if (choice == 2) {
			} else if (choice == 3) {
			} else if (choice == 4) {
			} else if (choice == 5) {
			} else if (choice == 0) {
				continue;
			} else {
				System.out.println("Chon lai chuc nang!");
				choice = 1;
			}
		}
	}

	public static String whileloop() {
		System.out.print("Nhap so CCCD: ");
		String cccdstr = sc.nextLine();
		if (cccdstr.equals("0")) {
			return cccdstr;  // thoat han chuong trinh
		} else {
			boolean hople = kiemtracancuoccongdanhople(cccdstr);
			if (!hople) {
				System.out.println("So CCCD khong hop le. Vui long nhap lai hoac nhap No de thoat");
				return "1";  // nhap lai
			}
			return cccdstr;
		}
	}

	public static void docfile(String filename) {
		int c;
		try {
			FileReader in = new FileReader(filename);
			int i = 0;
			while ((c = in.read()) != -1) {
				while ((c = in.read()) != -1) {
					System.out.print((char) c);
				}
			}
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean kiemtracancuoccongdanhople(Long cccd) {
		int nhieuhon11so = cccd.compareTo(99999999999L);
		if (nhieuhon11so > 0) {
			int ithon13so = cccd.compareTo(1000000000000L);
			if (ithon13so < 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean kiemtracancuoccongdanhople(String cccd) {
		int nhieuhon11so = cccd.length();
		if (nhieuhon11so == 12) {
			return true;
		}
		return false;
	}

	public static void kiemtranamsinhgioitinh(String gioitinhtheki_, String namsinh) {
		int beginofcentury;
		int gioitinhtheki = Integer.parseInt(gioitinhtheki_);
		int fromyear = 19;
		int gttk;
		int yearofbirth;
		String gender = "Nam";
		if ((int) gioitinhtheki % 2 == 0) {
			gttk = gioitinhtheki / 2;
		} else {
			gender = "Nu";
			gttk = (gioitinhtheki - 1) / 2;
		}
		beginofcentury = (fromyear + gttk) * 100;
		yearofbirth = beginofcentury + Integer.parseInt(namsinh);
		System.out.println("Gioi tinh: " + gender + "| Nam sinh: " + yearofbirth);}
}

class Bank {  // quản lý thông tin ngân hàng
	private String name;

	Bank(String name) {
		this.name = name;
	}
}

public abstract class User {  // quản lý thông tin người dùng của hệ thống
	private String name;
	private String customerId;

	public User(String name, String customerId) {
		this.name = name;
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String cutomerId) {
		this.customerId = customerId;
	}
}

class Customer extends User {  // quản lý thông tin khách hàng
}

class Account {  // quản lý thông tin tài khoản khách hàng
	private String accountNumber;
	private double balance;

	void Account(String accountNumber, double balance) {
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
		if (this.balance > 10000000) {
			return true;
		} else {
			return false;
		}
	}

	public void toString(String accountNumber) {
		System.out.println(accountNumber + " |              " + )
	}
}
