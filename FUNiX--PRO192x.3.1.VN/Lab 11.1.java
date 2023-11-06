public class Entry {
	public static void main(String[] args) {
		Car car = new Car(8, "Base car");
		System.out.println(car.startEngine());
		System.out.println(car.accelerate());
		System.out.println(car.brake());

		Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
		System.out.println(mitsubishi.startEngine());
		System.out.println(mitsubishi.accelerate());
		System.out.println(mitsubishi.brake());
	}
}


class Car {
    private int cylinders;  // xi lanh
    private String name;  // tên xe
    private int wheels;  // bánh xe
    private boolean engine;  // động cơ

    Car(int cylinders, String name) {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean getEngine() {
        return engine;
    }
    
    public String startEngine() {
    	return "ô tô khởi động động cơ!";
    }
    
    public String accelerate() {
    	return "ô tô tăng tốc!";
    }
    
    public String brake() {
    	return "ô tô phanh!";
    }
}


class Mitsubishi extends Car {
    Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }
        
    @Override
    public String startEngine() {
    	return "Mitsubishi khởi động động cơ!";
    }
    
    @Override
    public String accelerate() {
    	return "Mitsubishi tăng tốc!";
    }
    
    @Override
    public String brake() {
    	return "Mitsubishi phanh!";
    }
}


class Holden extends Car {
    Holden(int cylinders, String name) {
        super(cylinders, name);
    }
        
    @Override
    public String startEngine() {
    	return "Holden khởi động động cơ!";
    }
    
    @Override
    public String accelerate() {
    	return "Holden tăng tốc!";
    }
    
    @Override
    public String brake() {
    	return "Holden phanh!";
    }
}


class Ford extends Car {
    Ford(int cylinders, String name) {
        super(cylinders, name);
    }
        
    @Override
    public String startEngine() {
    	return "Ford khởi động động cơ!";
    }
    
    @Override
    public String accelerate() {
    	return "Ford tăng tốc!";
    }
    
    @Override
    public String brake() {
    	return "Ford phanh!";
    }
}
