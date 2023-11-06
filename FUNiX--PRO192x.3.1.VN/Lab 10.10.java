public class Entry {
	public static void main(String[] args) {
		Account account1 = new Account(1000, "Tuan", 2000);
		account1.display();
		account1.withdraw(2100);
		account1.deposit(600);
		System.out.println("Balance: " + account1.getBalance());
		account1.withdraw(2100);
		System.out.println("Balance: " + account1.getBalance());
	}
}


class Account {
    private int id;
    private String name;
    private int balance;

    Account(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    Account(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public void display() {
        System.out.println("Id: "  + id);
        System.out.println("Name: "  + name);
        System.out.println("Balance: "  + balance);
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

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (this.balance - amount < 0) {
        	System.out.println("That amount exceeds your current balance.");
        } else {
        	this.balance -= amount;
        }        
    }
}
