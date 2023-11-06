public class Entry {
	public static void main(String[] args) {
		Date d = new Date(1, 1, 1997);
		d.display();
		d.setDate(12, 12, 2004);
		d.display();
		d.setMonth(3);
		d.display();
	}
}


class Date {
    private int day;
    private int month;
    private int year;

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void display() {
        System.out.println(dinhdanglaingaythang(day) + "/" + dinhdanglaingaythang(month) + "/" + year);
    }
    
    String dinhdanglaingaythang(int day) {
	String day_;
    	if (day < 10) {
    		day_ = "0" + String.valueOf(day);
    	} else {
    		day_ = String.valueOf(day);
    	}
    	return day_;
    }

    public void setDay(int id) {
        this.day = id;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int id) {
        this.month = id;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int id) {
        this.year = id;
    }

    public int getYear() {
        return year;
    }
}
