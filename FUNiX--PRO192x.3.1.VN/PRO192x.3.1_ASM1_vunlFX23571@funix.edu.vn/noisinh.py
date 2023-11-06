import os


with open("nganhangsophienban1.java", encoding="utf8") as n:
	noisinh = n.read()

"""import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Array {
        static Scanner sc = new Scanner(System.in);
        static Random rand = new Random();
        static int choice = 1;
        public static void main(String[] args) {
                docfile("nganhangsophienban1.txt");
                while (choice != 0) {
                        choice = sc.nextInt();
                        System.out.println("Chuc nang: " + choice);

                        if (choice == 1) {
                                int ranNum = rand.nextInt(900)+100;
                                System.out.println("Nhap ma xac thuc: " + ranNum);
                                int maxacthuc = -1;
                                while (maxacthuc != ranNum) {
                                        if (maxacthuc != -1) {
                                                System.out.println("Ma xac thuc khong dung, vui long thu lai!");
                                        }
                                        maxacthuc = sc.nextInt();
                                }
                                while (choice != 0) {
                                        System.out.print("Nhap so CCCD: ");
                                        String cccdstr = sc.nextLine();
                                        // Long cccd = Long.parseLong(cccdstr);
                                        if (cccdstr == "0") {
                                                choice = 0;
                                        } else {
                                                boolean hople = kiemtracancuoccongdanhople(cccdstr);
                                                if (!hople) {
                                                        System.out.println("So CCCD khong hop le. Vui long nhap lai hoac nhap 0 de thoat");
                                                } else {
                                                        int chonchucnang  = 1;
                                                        while (chonchucnang != 0) {
                                                                docfile("nganhangsophienban1_.txt");
                                                                chonchucnang = sc.nextInt();
                                                                System.out.println("Chon chuc nang: " + chonchucnang);

                                                                if (chonchucnang == 1) {
                                                                        kiemtranoisinh(cccdstr.substring(0,3));
                                                                } else if (chonchucnang == 2) {
                                                                        kiemtranamsinhgioitinh(cccdstr.charAt(3), cccdstr.substring(4,6));
                                                                } else if (chonchucnang == 3) {
                                                                        System.out.println("So ngau nhien: " + cccdstr.substring(6, 12));
                                                                }
                                                        }
                                                }
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

        public static void kiemtranoisinh(String noisinh) {
                switch (noisinh) {
                        1       Hà Nội  001
2       Hà Giang        002
3       Cao Bằng        004
4       Bắc Kạn 006
5       Tuyên Quang     008
6       Lào Cai 010
7       Điện Biên       011
8       Lai Châu        012
9       Sơn La  014
10      Yên Bái 015
11      Hòa Bình        017
12      Thái Nguyên     019
13      Lạng Sơn        020
14      Quảng Ninh      022
15      Bắc Giang       024
16      Phú Thọ 025
17      Vĩnh Phúc       026
18      Bắc Ninh        027
19      Hải Dương       030
20      Hải Phòng       031
21      Hưng Yên        033
22      Thái Bình       034
23      Hà Nam  035
24      Nam Định        036
25      Ninh Bình       037
26      Thanh Hóa       038
27      Nghệ An 040
28      Hà Tĩnh 042
29      Quảng Bình      044
30      Quảng Trị       045
31      Thừa Thiên Huế  046
32      Đà Nẵng 048
33      Quảng Nam       049
34      Quảng Ngãi      051
35      Bình Định       052
36      Phú Yên 054
37      Khánh Hòa       056
38      Ninh Thuận      058
39      Bình Thuận      060
40      Kon Tum 062
41      Gia Lai 064
42      Đắk Lắk 066
43      Đắk Nông        067
44      Lâm Đồng        068
45      Bình Phước      070
46      Tây Ninh        072
47      Bình Dương      074
48      Đồng Nai        075
49      Bà Rịa - Vũng Tàu       077
50      Hồ Chí Minh     079
51      Long An 080
52      Tiền Giang      082
53      Bến Tre 083
54      Trà Vinh        084
55      Vĩnh Long       086
56      Đồng Tháp       087
57      An Giang        089
58      Kiên Giang      091
59      Cần Thơ 092
60      Hậu Giang       093
61      Sóc Trăng       094
62      Bạc Liêu        095
63      Cà Mau  096
                }
        }

        public static void kiemtranamsinhgioitinh(char gioitinhtheki, String namsinh) {
        }
}"""

batdau = noisinh.find("switch (noisinh) {") + len("switch (noisinh) {");print(batdau)
ketthuc = noisinh.find("096\n") + len("096\n");print(ketthuc)
for stt, dong in enumerate(noisinh[batdau: ketthuc].split("\n")):
	tinh_maso: list = dong.strip().split("\t")
	if not len(tinh_maso) == 3:
		continue
	print(f"""			case "{tinh_maso[2]}":
				System.out.println("{tinh_maso[1]}");
				break;""")
