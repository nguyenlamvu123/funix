public class Entry {
	public static void main(String[] args) {
		Student s = new Student(1001, "Trung", 24, "Ha Noi", 5);
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getAddress());
		System.out.println(s.getScore());
		s.setScore(-7);
		System.out.println(s.getScore());
		s.setScore(15);
		System.out.println(s.getScore());
	}
}


class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private int score;

    public Student() {}

    Student(int id, String name, int age, String address, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        if (score < 0) {
            this.score = 0;
        } else if (score > 10) {
            this.score = 10;
        } else {
            this.score = score;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String id) {
        this.name = id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int id) {
        this.age = id;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String id) {
        this.address = id;
    }

    public String getAddress() {
        return address;
    }

    public void setScore(int id) {
        this.score = id;
    }

    public int getScore() {
        if (score > 0 && score < 10) {
            return score;
        } else if (score > 10) {
            return 10;
        } else {
            return 0;
        }        
    }
}
