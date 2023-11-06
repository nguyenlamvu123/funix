public class Entry {
	public static void main(String[] args) {
		Author[] authors = new Author[3];
		authors[0] = new Author("Viet", "VietCV@codelearn.io");
		authors[1] = new Author("Tuan", "TuanLQ@codelearn.io");
		authors[2] = new Author("Kien", "KienNT@Codelearn.io");
		
		Book book1 = new Book("C++ for Beginners", authors, 210000);
		System.out.println(book1.getAuthorNames());
	}
}

class Author {
    private String name;
    private String email;

    Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    void setName(String x) {
        this.name = x;
    }

    void setEmail(String x) {
        this.email = x;
    }

    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }
}

class Book {
    private String name;
    private Author[] authors;
    private double price;

    Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    void setName(String x) {
        this.name = x;
    }

    void setPrice(double x) {
        this.price = x;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    String getAuthorNames() {
    	String ret = "";
    	for (int i = 0; i < authors.length; i++) {
    		if (i == authors.length - 1) {
    			ret += authors[i].getName();
    		} else {
    			ret += authors[i].getName() + ", ";
    		}    		
    	}
        return ret;
    }
}
