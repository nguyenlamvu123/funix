class Person {
	public String name;
	public String gender;

	public Person(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Gender: " + gender);
	}
}

class Student extends Person {	
    private int sal;

    public Student(String name, String gender, int sal) {
        super(name, gender);
        this.sal = sal;
    }

	public void display() {
		System.out.println("Name: " + this.name);
		System.out.println("Gender: " + super.gender);
		System.out.println("Salary: " + this.sal);
	}
}

public class Entry {
	public static void main(String[] args) {
		Student s = new Student("Trung", "Male", 1700);
		s.display();
	}
}
