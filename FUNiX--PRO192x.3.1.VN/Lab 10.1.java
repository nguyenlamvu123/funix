class Lamp {
	private String style;
	private boolean battery;
	private int globRating;
	
	void Lamp(String style, boolean battery, int globRating) {
		this.style = style;
		this.battery = battery;
		this.globRating = globRating;
	}
	
	
	void turnOn() {  // không có kiểu trả về và sẽ in ra thông báo rằng đèn đang được bật; 
		System.out.println("đèn đang được bật");
	}
	
	
	String getStyle() {  // trả về kiểu đèn; 
		return this.style;
	}
	
	
	boolean isBattery() {  // trả về giá trị của pin;
		return this.battery;
	}
	
	
	int getGlobRating() {  // trả về tỷ lệ chiếu sáng của đèn.
		return this.globRating;
	}
}


class Bed {
	private String style;
	private int pillows;
	private int height;
	private int sheets;
	private int quilt;
	
	void Bed (String style, int pillows, int height, int sheets, int quilt) {
		this.pillows = pillows;
		this.style = style;
		this.height = height;
		this.sheets = sheets;
		this.quilt = quilt;
	}
	
	void make() {  // không có kiểu trả về và in ra một thông báo về hiệu ứng rằng chiếc giường đang được tạo ra; 
		System.out.println("chiếc giường đang được tạo ra");
	}
	
	
	String getStyle() {  // trả về giá trị của style; 
		return this.style;
	}
	
	
	int getPillows() {  // trả về số gối; 
		return this.pillows;
	}
	
	
	int getHeight() {  // trả về chiều cao của giường; 
		return this.height;
	}
	
	
	int getSheets() {  // trả về số tấm trên giường; 
		return this.sheets;
	}
	
	
	int getQuilt() {  // trả về giá trị của chăn.
		return this.quilt;
	}
}


class Ceiling {
	private int height;
	private int paintedColor;
	
	void Ceiling (int height, int paintedColor) {
		this.height = height;
		this.paintedColor = paintedColor;
	}
	
	
	int getHeight() {
		return this.height;
	}
	
	
	int getPaintedColor() {
		return this.paintedColor;
	}
}


class Wall {
	private String direction;
	
	void Wall (int height, int paintedColor) {
		this.direction = direction;
	}
	
	
	String getDirection() {
		return this.direction;
	}
}


class Bedroom {
	private String name; 
	private Wall wall1, wall2, wall3, wall4;
	private Celling ceiling; 
	private Bed bed;
	private Lamp lamp;

	
	void Bedroom (String style, int pillows, int height, int sheets, int quilt) {
		this.wall1 = wall1;
		this.wall2 = wall2;
		this.wall3 = wall3;
		this.wall4 = wall4;
		this.name = name;
		this.ceiling = ceiling;
		this.bed = bed;
		this.lamp = lamp;
	}
	
	Lamp getLamp() {  // trả về một đối tượng kiểu Đèn 
		return this.lamp;
	}	
	
	void makeBed() {  // in thông báo rằng Bed đang được tạo ra và cũng gọi phương thức make () trong lớp Bed
		bed.make();
	}
}


public static void main(String[] args) {  // Bedroom challenge
	Wall wall1 = new Wall("West");
	Wall wall2 = new Wall("East");
	Wall wall3 = new Wall("South");
	Wall wall4 = new Wall("North");

	Ceiling ceiling = new Ceiling(12, 55);

	Bed bed = new Bed("Modern", 4, 3, 2,1);

	Lamp lamp = new Lamp("Classic", false, 75);

	Bedroom bedroom = new Bedroom("Alberts", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
	bedroom.makeBed();

	bedroom.getLamp().turnOn();
}

