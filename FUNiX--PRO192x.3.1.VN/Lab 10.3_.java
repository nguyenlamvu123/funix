class Person{
	private int id;
	private String name;
	private int age;
	private String address;
	
    Person(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getAddress() {
        return address;
    }
}

public class Entry {
	public static void main(String[] args) {
		Person p = new Person(1001, "Quynh", 24, "Ha Noi");
		System.out.println("Id: " + p.getId());
		System.out.println("Name: " + p.getName());
		System.out.println("Age: " + p.getAge());
		System.out.println("Address: " + p.getAddress());
	}
}
