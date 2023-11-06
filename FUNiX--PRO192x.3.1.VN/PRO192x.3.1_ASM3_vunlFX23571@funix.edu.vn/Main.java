import java.io.*;
import java.util.Scanner;
// import java.util.Random;
import java.util.ArrayList;


class Main {
	private static int EXIT_COMMAND_CODE = 0;
	private static int EXIT_ERROR_CODE = -1;
	private static String CUSTOMER_ID = "001093008393";  // CCCD
	private static String CUSTOMER_NAME = "Nguyễn Lâm Vũ";  // tên
	static Scanner sc = new Scanner(System.in);
	static int choice = 1;  // điểm xuất phát
	static DigitalBank activeBank = new DigitalBank();

	public static void main(String[] args) {
		docfile("nganhangsophienban3.txt");
		while (choice != 0) {
			System.out.print("Chon chuc nang: ");
			choice = sc.nextInt();
			System.out.println("Chuc nang: " + choice);

			if (choice == 1) {
				xemthongtinkhachhang();
				// themkhachhangvaonganhang();
			} else if (choice == 2) {
				ArrayList<Customer> cuss = bank.getCustomers();
				boolean thanhcong = false;
				while (!thanhcong) {
					thanhcong = themtaikhoanchokhachhang(cuss);
				}
				choice = 1;  // chỉ có tác dụng quay về điểm xuất phát
			} else if (choice == 3) {
				hienthidanhsachkhachhang("");
			} else if (choice == 4) {
				while (true) {
					sc.nextLine();
					System.out.print("Nhập CCCD khách hàng: ");
					String cc_cd = sc.nextLine();
					if (kiemtracancuoccongdanhople(cc_cd)) {
						hienthidanhsachkhachhang(cc_cd);
						break;
					} else {
						System.out.println("So CCCD khong hop le. Vui long nhap lai hoac nhap No de thoat");
					}
				}
			} else if (choice == 5) {
				sc.nextLine();
				System.out.print("Nhập tên khách hàng: ");
				String ten = sc.nextLine();
				hienthikhachhangtheoten(ten);
			} else if (choice == 0) {
				continue;
			} else {
				System.out.println("Chon lai chuc nang!");
				choice = 1;  // chỉ có tác dụng quay về điểm xuất phát
			}
		}
	}

	public static String whileloop() {
		System.out.print("Nhap so CCCD hoac nhap 0 de thoat: ");
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

	public static boolean kiemtracancuoccongdanhople(String cccd) {
		int nhieuhon11so = cccd.length();
		if (nhieuhon11so == 12) {
			return true;
		}
		return false;
	}

	public static void xemthongtinkhachhang() {
		Customer cu = activeBank.getCustomerById(CUSTOMER_ID);
		if (cu != null) {
			cu.displayInformation();
		}
	}

	public static void hienthikhachhang(Customer cus, String cccd) {
		String ten = cus.getName();
		String loaikhachhang = cus.isPremiumAccount();
		double sodu = cus.getBalance();
		System.out.println(cccd + " | " + ten + " | " + loaikhachhang + " | " + sodu);
		int thutu = 0;
		ArrayList<Account> accs = cus.getAccounts(cccd);
		for (Account acc: accs) {
			// String masotaikhoan = acc.getAccountNumber();
			// double sodu_ = acc.getBalance();
			String thongtin = acc.toString();
			System.out.println(thutu + " | " + thongtin);
			thutu += 1;
		}
	}

	public static void hienthikhachhangtheoten(String ten) {
		ArrayList<Customer> cuss = bank.getCustomers();
		boolean taikhoankhongtontai = true;
		for (Customer cus: cuss) {
			String ten_ = cus.getName();
			if (ten.equals(ten_)) {
				String cccd = cus.getCustomerId();
				hienthikhachhang(cus, cccd);
				taikhoankhongtontai = false;
				break;
			}
		}
		if (taikhoankhongtontai) {
			System.out.println("Tài khoản không tồn tại!");
		}
	}

	public static void hienthidanhsachkhachhang(String cc_cd) {
		System.out.println("-------------- BANKID: " + bank.getId() + " --------------");
		ArrayList<Customer> cuss = bank.getCustomers();
		boolean taikhoankhongtontai;
		if (cc_cd.equals("")) {
			taikhoankhongtontai = false;
		} else {
			taikhoankhongtontai = true;
		}		
		for (Customer cus: cuss) {
			String cccd = cus.getCustomerId();
			if (cc_cd.equals("")) {
				hienthikhachhang(cus, cccd);
			} else {
				if (cc_cd.equals(cccd)) {
					hienthikhachhang(cus, cccd);
					taikhoankhongtontai = false;
					break;
				}
			}
		}
		if (taikhoankhongtontai) {
			System.out.println("Tài khoản không tồn tại!");
		}
	}

	public static boolean themtaikhoanchokhachhang(ArrayList<Customer> cuss) {
		sc.nextLine();
		System.out.print("Xac nhan can cuoc cong dan: ");
		String cccd_ = sc.nextLine();
		for (Customer cu: cuss) {
			if (cu.getCustomerId().equals(cccd_)) {
				ArrayList<Account> accs = cu.getAccounts(cccd_);
				boolean tontai = true;
				while (tontai) {
					System.out.print("Nhap ma stk gom 6 chu so: ");
					String accountNumb = sc.nextLine();
					if (accountNumb.length() == 6) {
						boolean tontai_ = false;
						for (Account acc_: accs) {
							if (accountNumb.equals(acc_.getAccountNumber())) {
								System.out.println("STK đã tồn tại. Yêu cầu nhập lại!");
								tontai_ = true;
								break;
							}
						}
						if (!tontai_) {
							tontai = false;
							boolean tren50k = false;
							while (!tren50k) {
								System.out.print("Nhập số dư tk khách hàng: ");
								double sodutk = sc.nextDouble();
								if (sodutk > 50000) {
									tren50k = true;
									Account a_ = new Account(accountNumb, sodutk);
									cu.addAccount(a_);
									return true;
								} else {
									System.out.println("Số dư phải trên 50k");
								}
							}
						}
					} else {
						System.out.println("Mã stk cần có đúng 6 chữ số");
					}
				}
				break;
			}
		}
		System.out.println("CCCD không tồn tại trong hệ thống ngân hàng. Yêu cầu nhập lại!");
		return false;
	}
}
