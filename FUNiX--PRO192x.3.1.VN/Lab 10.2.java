class main {
	public static void main(String[] args) {
		Printer bedroom = new Printer(12, true);
		int luongmuchientai = bedroom.addToner(30);
		System.out.println("lượng mực hiện tại: " + luongmuchientai);
		bedroom.getPagePrinted(31);
		Printer bedoom = new Printer(112, true);
		int luongmuc_hientai = bedoom.addToner(30);
		System.out.println("lượng mực hiện tại: " + luongmuc_hientai);
		bedoom.getPagePrinted(31);
	}
}


class Printer {
	private int tonerLevel;
	private int pagesPrinted;
	private boolean duplex;
	
	Printer(int tonerLevel, boolean duplex) {
		if (tonerLevel >= 0 && tonerLevel <= 100) {
			this.tonerLevel = tonerLevel;
		} else {
			this.tonerLevel = -1;
		}
		this.duplex = duplex;
	}
	
	int addToner(int luongmucdovao) {
		if (luongmucdovao >= 0) {
			int tonerLevel_ = this.tonerLevel + luongmucdovao;
			if (tonerLevel_ >= 0 && tonerLevel_ <= 100) {
				this.tonerLevel = tonerLevel_;
				return tonerLevel_;
			}
		}
		return -1;
	}
	
	int printPages(int soluongtrangin) {
		int sotocanin;
		if (this.duplex) {
			if (soluongtrangin % 2 == 0) {
				sotocanin = soluongtrangin / 2;
			} else {
				sotocanin = soluongtrangin / 2 + 1;
			}
		} else {
			sotocanin = soluongtrangin;
		}
		return sotocanin;
	}
	
	void getPagePrinted(int soluongtrangin) {
		int sotocanin = printPages(soluongtrangin);
		for (int trangdangin = 1; trangdangin <= sotocanin; trangdangin++) {
			System.out.println("trang đang in: " + trangdangin);
		}
	}
}
