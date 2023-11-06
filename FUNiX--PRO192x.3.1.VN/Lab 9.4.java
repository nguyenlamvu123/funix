class Student {
    private String name;
    private char gender:

    public Student() {
        this.name = "Unknown";
        this.gender = 'u';
    }

    public Student(String name) {
        this.name = name;
        this.gender = 'u';
    }

    public Student(char name) {
        this.name = "Unknown";
        this.gender = name;
    }

    public Student(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }

    public void display() {
        System.out.println("Name: " + this.name);
        if (this.gender == 'm') {
            System.out.println("Gender: Male");
            } elif (this.gender == 'f') {
                System.out.println("Gender: Female");
            } else {
                System.out.println("Gender: Unknown");
            }
    }
}
