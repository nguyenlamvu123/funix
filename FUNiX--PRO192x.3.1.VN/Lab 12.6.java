public class Entry {
	public static void main(String[] args) {
		Person person1 = new Employee("Trung", "HN", 3300);
		Person person2 = new Customer("Linh", "BN", 10400);
		person1.display();
		person2.display();
	}
}

class Employee extends Person {
	private int salary;

	Employee(String name, String address, int salary) {
		super(name, address);
		this.salary = salary;
	}

	void display() {
		System.out.println("Employee name: " + getName());
		System.out.println("Employee address: " + getAddress());
		System.out.println("Employee salary: " + salary);
	}
}

class Customer extends Person {
	private int balance;

	Customer(String name, String address, int balance) {
		super(name, address);
		this.balance = balance;
	}

	void display() {
		System.out.println("Customer name: " + getName());
		System.out.println("Customer address: " + getAddress());
		System.out.println("Customer balance: " + balance);
	}
}

abstract class Person {
	private String name;
	private String address;

	Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	void setName(String x) {
		this.name = x;
	}

	void setAddress(String y) {
		this.address = y;
	}

	String getName() {
		return name;
	}

	String getAddress() {
		return address;
	}

	abstract void display();
}