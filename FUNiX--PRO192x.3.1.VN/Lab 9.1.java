class Person{
	public String name;
	public int dob;
	public Person(String name, int dob) {
		this.name = name;
		this.dob = dob;
	}
}

class Student extends Person {
    private double gpa;

    public Student (String name, int dob, double gpa) {
        super(name, dob);
        this.gpa = gpa;
    }

	public String getName() {
        return this.name;
    }

	public int getDob() {
        return this.dob;
	}
	public double getGpa() {
        return this.gpa;
    }
}

public class Entry {
	public static void main(String[] args) {
		Student s = new Student("Hai", 1999, 8.8);
		System.out.println("Name: " + s.getName());
		System.out.println("Date of birth: " + s.getDob());
		System.out.println("GPA: " + s.getGpa());
	}
}
