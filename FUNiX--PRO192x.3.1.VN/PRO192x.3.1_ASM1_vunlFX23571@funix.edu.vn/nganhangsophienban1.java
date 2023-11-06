import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Array {
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static int choice = 1;
	public static void main(String[] args) {
		System.out.println("Chon che do: EASY hoac HARD");
		String chedo = sc.nextLine();
		docfile("nganhangsophienban1.txt");
		while (choice != 0) {
			System.out.print("Chon chuc nang: ");
			choice = sc.nextInt();
			System.out.println("Chuc nang: " + choice);

			if (choice == 1) {
				if (chedo.equals("EASY")) {
					int ranNum = rand.nextInt(900)+100;
					System.out.println("Nhap ma xac thuc: " + ranNum);
					int maxacthuc = 0;
					boolean first = true;
					while (maxacthuc != ranNum) {
						if (!first) {
							System.out.println("Ma xac thuc khong dung, vui long thu lai!");
						}
						maxacthuc = sc.nextInt();
						first = false;
					}
					first = true;
					while (choice != 0) {					
						choice = whileloop(first);
						first = false;
					}
				} else if ((chedo.equals("HARD"))) {
					String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
					StringBuilder sb = new StringBuilder();
					int length = 6;
					for(int i = 0; i < length; i++) {
						int index = rand.nextInt(alphabet.length());
						char randomChar = alphabet.charAt(index);
						sb.append(randomChar);
					}
					String ranNum = sb.toString();
					System.out.println("Nhap ma xac thuc: " + ranNum);
					String maxacthuc = "none";
					boolean first = true;
					while (!maxacthuc.equals(ranNum)) {
						// System.out.println("%%%___%%%%" + first);
						if (!first) {
							System.out.println("Ma xac thuc khong dung, vui long thu lai!");
						}
						maxacthuc = sc.nextLine();
						first = false;
					}
					first = true;
					while (choice != 0) {					
						choice = whileloop(first);
						first = false;
					}
				}
			} else if (choice == 2) {
				choice = 0;
			} else {
				System.out.println("Chon lai chuc nang!");
				choice = 1;
			}
		}
	}

	public static int whileloop(boolean first) {
		System.out.print("Nhap so CCCD: ");
		String cccdstr = sc.nextLine();
		// System.out.println("%%%%%%%" + first);
		// Long cccd = Long.parseLong(cccdstr);
		if (cccdstr.equals("0")) {
			return 0;
		} else {
			boolean hople = kiemtracancuoccongdanhople(cccdstr);
			if (!hople) {
				if (!first) {
					System.out.println("So CCCD khong hop le. Vui long nhap lai hoac nhap 0 de thoat");
				}
			} else {
				int chonchucnang  = 1;
				while (chonchucnang != 0) {
					docfile("nganhangsophienban1_.txt");
					System.out.println("");
					chonchucnang = sc.nextInt();
					System.out.println("Chon chuc nang: " + chonchucnang);

					if (chonchucnang == 1) {
						System.out.print("Noi sinh: ");
						kiemtranoisinh(cccdstr.substring(0,3));
					} else if (chonchucnang == 2) {										kiemtranamsinhgioitinh(cccdstr.substring(3, 4), cccdstr.substring(4, 6));
					} else if (chonchucnang == 3) {
						System.out.println("So ngau nhien: " + cccdstr.substring(6, 12));
					} else if (chonchucnang == 0) {
						continue;
					} else {
						System.out.println("Yeu cau khong hop le!");
					}
				}
			}
			return 1;
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
		System.out.println("Gioi tinh: " + gender + "| Nam sinh: " + yearofbirth);
	}

	public static void kiemtranoisinh(String noisinh) {
		switch (noisinh) {
                        case "001":
                                System.out.println("Hà Nội");
                                break;
                        case "002":
                                System.out.println("Hà Giang");
                                break;
                        case "004":
                                System.out.println("Cao Bằng");
                                break;
                        case "006":
                                System.out.println("Bắc Kạn");
                                break;
                        case "008":
                                System.out.println("Tuyên Quang");
                                break;
                        case "010":
                                System.out.println("Lào Cai");
                                break;
                        case "011":
                                System.out.println("Điện Biên");
                                break;
                        case "012":
                                System.out.println("Lai Châu");
                                break;
                        case "014":
                                System.out.println("Sơn La");
                                break;
                        case "015":
                                System.out.println("Yên Bái");
                                break;
                        case "017":
                                System.out.println("Hòa Bình");
                                break;
                        case "019":
                                System.out.println("Thái Nguyên");
                                break;
                        case "020":
                                System.out.println("Lạng Sơn");
                                break;
                        case "022":
                                System.out.println("Quảng Ninh");
                                break;
                        case "024":
                                System.out.println("Bắc Giang");
                                break;
                        case "025":
                                System.out.println("Phú Thọ");
                                break;
                        case "026":
                                System.out.println("Vĩnh Phúc");
                                break;
                        case "027":
                                System.out.println("Bắc Ninh");
                                break;
                        case "030":
                                System.out.println("Hải Dương");
                                break;
                        case "031":
                                System.out.println("Hải Phòng");
                                break;
                        case "033":
                                System.out.println("Hưng Yên");
                                break;
                        case "034":
                                System.out.println("Thái Bình");
                                break;
                        case "035":
                                System.out.println("Hà Nam");
                                break;
                        case "036":
                                System.out.println("Nam Định");
                                break;
                        case "037":
                                System.out.println("Ninh Bình");
                                break;
                        case "038":
                                System.out.println("Thanh Hóa");
                                break;
                        case "040":
                                System.out.println("Nghệ An");
                                break;
                        case "042":
                                System.out.println("Hà Tĩnh");
                                break;
                        case "044":
                                System.out.println("Quảng Bình");
                                break;
                        case "045":
                                System.out.println("Quảng Trị");
                                break;
                        case "046":
                                System.out.println("Thừa Thiên Huế");
                                break;
                        case "048":
                                System.out.println("Đà Nẵng");
                                break;
                        case "049":
                                System.out.println("Quảng Nam");
                                break;
                        case "051":
                                System.out.println("Quảng Ngãi");
                                break;
                        case "052":
                                System.out.println("Bình Định");
                                break;
                        case "054":
                                System.out.println("Phú Yên");
                                break;
                        case "056":
                                System.out.println("Khánh Hòa");
                                break;
                        case "058":
                                System.out.println("Ninh Thuận");
                                break;
                        case "060":
                                System.out.println("Bình Thuận");
                                break;
                        case "062":
                                System.out.println("Kon Tum");
                                break;
                        case "064":
                                System.out.println("Gia Lai");
                                break;
                        case "066":
                                System.out.println("Đắk Lắk");
                                break;
                        case "067":
                                System.out.println("Đắk Nông");
                                break;
                        case "068":
                                System.out.println("Lâm Đồng");
                                break;
                        case "070":
                                System.out.println("Bình Phước");
                                break;
                        case "072":
                                System.out.println("Tây Ninh");
                                break;
                        case "074":
                                System.out.println("Bình Dương");
                                break;
                        case "075":
                                System.out.println("Đồng Nai");
                                break;
                        case "077":
                                System.out.println("Bà Rịa - Vũng Tàu");
                                break;
                        case "079":
                                System.out.println("Hồ Chí Minh");
                                break;
                        case "080":
                                System.out.println("Long An");
                                break;
                        case "082":
                                System.out.println("Tiền Giang");
                                break;
                        case "083":
                                System.out.println("Bến Tre");
                                break;
                        case "084":
                                System.out.println("Trà Vinh");
                                break;
                        case "086":
                                System.out.println("Vĩnh Long");
                                break;
                        case "087":
                                System.out.println("Đồng Tháp");
                                break;
                        case "089":
                                System.out.println("An Giang");
                                break;
                        case "091":
                                System.out.println("Kiên Giang");
                                break;
                        case "092":
                                System.out.println("Cần Thơ");
                                break;
                        case "093":
                                System.out.println("Hậu Giang");
                                break;
                        case "094":
                                System.out.println("Sóc Trăng");
                                break;
                        case "095":
                                System.out.println("Bạc Liêu");
                                break;
                        case "096":
                                System.out.println("Cà Mau");
                                break;
		}
	}
}