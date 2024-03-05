public class Entry {
	public static void main(String[] args) {
		IEmployee employee1 = new PartTimeEmployee("Trung", 45000, 7);
		System.out.println("Name: " + employee1.getName());
		System.out.println("Salary per day: " + employee1.calculateSalary());

		IEmployee employee2 = new FullTimeEmployee("Linh", 65000);
		System.out.println("Name: " + employee2.getName());
		System.out.println("Salary per day: " + employee2.calculateSalary());
	}
}


interface IEmployee {
	int calculateSalary();
	String getName();
}


class Employee implements IEmployee {
	private String name;
	private int paymentPerHour;

    Employee(String name, int paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }
    
    void setName(String name) {
    	this.name = name;
    }
    
    String getName() {
    	return name;
    }
    
    void setPaymentPerHour(int paymentPerHour) {
    	this.paymentPerHour = paymentPerHour;
    }
    
    int getPaymentPerHour() {
    	return paymentPerHour;
    }
}


class PartTimeEmployee extends Employee {
    private int workingHours;

    PartTimeEmployee(String name, int paymentPerHour, int workingHours) {
        super(name, paymentPerHour);
        this.workingHours = workingHours;
    }

    @Override
    public int calculateSalary() {
        return workingHours * getPaymentPerHour();
    }
}


class FullTimeEmployee extends Employee {
    private int workingHours;

    FullTimeEmployee() {
    	super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() {
        return 8 * paymentPerHour;
    }
}
