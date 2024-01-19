public class Student() {
    private String gender;
    private String name;
    private int age;
    private double gpa;
    public Student(String name, String gender, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.gender = gender;
    }
    public void display() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("gender: " + gender);
        System.out.println("gpa: " + gpa);
    }
}
