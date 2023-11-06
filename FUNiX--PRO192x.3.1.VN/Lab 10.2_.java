class Printer {
	private int tonerLevel;
	private double duplex;
	
	void Printer(int tonerLevel, double duplex) {
		if (tonerLevel >= 0 && tonerLevel <= 100) {
			this.tonerLevel = tonerLevel;
		} else {
			this.tonerLevel = -1;
		}
		this.duplex = duplex;
	}
	
	int addToner(int luongmucdovao) {
		if (luongmucdovao >= 0 && luongmucdovao <= 100) {
			int tonerLevel_ = this.tonerLevel + luongmucdovao;
			if (tonerLevel_ < 100) {
				this.tonerLevel = tonerLevel_;
			} else {
				tonerLevel_ = -1;
			}
		} else {
			tonerLevel_ = -1;
		}
		return tonerLevel_;
	}
	
	int printPages(int pagesPrinted) {
		int sotocanin;
		if (this.duplex) {
			sotocanin = pagesPrinted / 2;
		} else {
			sotocanin = pagesPrinted;
		}
		return sotocanin;
	}
	
	void getPagePrinted(int sotocanin) {
		for (int pp = 0; pp < sotocanin; pp++) {
			System.out.println("Đang in tờ số" + pp);
		}
	}
}
