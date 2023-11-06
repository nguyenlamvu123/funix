class Person {
    private String name, address;
    private int age;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int name) {
        this.age = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String name) {
        this.address = name;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}


class Student extend Person {
    private double gpa;

    public Student(String name, int age, String address, double gpa) {
        super(name, age, address);
        this.gpa = gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void display() {
        super.display();
        System.out.prinln("GPA: " + gpa);
    }
}


class Teacher extend Person {
    private int salary;

    public Teacher(String name, int age, String address) {
        super(name, age, address);
        this.salary = salary;
    }

    public void Salary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void display() {
        super.display();
        System.out.prinln("Salary: " + salary);
    }
}
 
