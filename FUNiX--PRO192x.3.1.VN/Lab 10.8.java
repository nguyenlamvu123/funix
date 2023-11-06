class Entry {
	public static void main(String[] args) {
		Time t = new Time(12, 1, 1);
		t.display();
		t.setTime(23, 59, 59);
		t.display();
		t.nextSecond();
		t.display();
		t.nextSecond();
		t.display();
		t.setTime(7, 0, 0);
		t.display();
		t.previousSecond();
		t.display();
	}
}


class Time {
    private int hour;
    private int minute;
    private int second;

    Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void display() {
        System.out.println(dinhdanglaingaythang(hour) + ":" + dinhdanglaingaythang(minute) + ":" + dinhdanglaingaythang(second));
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

    public void setHour(int id) {
        this.hour = id;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int id) {
        this.minute = id;
    }

    public int getMinute() {
        return minute;
    }

    public void setSecond(int id) {
        this.second = id;
    }

    public int getSecond() {
        return second;
    }

    public void nextSecond() {
        int second = this.second + 1;
        if (second >= 60) {
        	int minute = this.minute + 1;
		if (minute >= 60) {
			int hour = this.hour + 1;
			if (hour >= 24) {
				this.hour = 0;
			} else {
				this.hour = hour;
			}
			this.minute = 0;
		} else {
			this.minute = minute;
		}
		this.second = 0;
	} else {
		this.second = second;
	}
    }

    public void previousSecond() {
        int second = this.second - 1;
        if (second < 0) {
        	int minute = this.minute - 1;
		if (minute < 0) {
			int hour = this.hour - 1;
			if (hour < 0) {
				this.hour = 23;
			} else {
				this.hour = hour;
			}
			this.minute = 59;
		} else {
			this.minute = minute;
		}
		this.second = 59;
	} else {
		this.second = second;
	}
    }
}
