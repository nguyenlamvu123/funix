class Entry {
	public static void main(String[] args) {
		Employee e = new Employee(1, "Kien", "Hoang", 1000);
		System.out.println("Id: " + e.getId());
		System.out.println("Name: " + e.getFullName());
		System.out.println("Salary: " + e.getSalary());
	}
}


class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.salary = salary;
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String id) {
        this.firstName = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSalary(int id) {
        this.salary = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setLastName(String id) {
        this.lastName = id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
    	return firstName + lastName;
    }
}
