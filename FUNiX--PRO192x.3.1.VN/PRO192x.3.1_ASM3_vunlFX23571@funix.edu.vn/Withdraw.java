public interface Withdraw {
	boolean withdraw(double amount, Customer cu);
	boolean isAccepted(double amount);
	boolean setBalance(double amount, Customer cu);
}