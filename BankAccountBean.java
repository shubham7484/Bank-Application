package bank_application;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BankAccountBean implements Serializable {
	private long acno;
	private String name;
	private double balance;

	public BankAccountBean() {

	}

	public long getAcno() {
		return acno;
	}

	public void setAcno(long acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}