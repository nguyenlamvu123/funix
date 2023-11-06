class Person{
	private int id;
	private String name;
	private int age;
	private String address;

    void setID(int id) {
        this.id = id;
    }

    void setName(String id) {
        this.name = id;
    }

    void setAge(int id) {
        this.age = id;
    }

    void setAddress(String id) {
        this.address = id;
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
		Person p = new Person();
        p.setID(1001);
        p.setName("Quynh");
        p.setAge(24);
        p.setAddress("Ha Noi");
		System.out.println("Id: " + p.getId());
		System.out.println("Name: " + p.getName());
		System.out.println("Age: " + p.getAge());
		System.out.println("Address: " + p.getAddress());
	}
}
