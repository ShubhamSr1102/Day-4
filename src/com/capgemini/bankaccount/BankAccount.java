package com.capgemini.bankaccount;

public class BankAccount {

	private long accId;
	private String accHolderName;
	private String accType;
	private double balance;

	public static final String BANK_NAME = "ICICI Bank";
	private static long totalAccounts;
	private static long accIdValues = 1000;

	public BankAccount() {
		super();
		accId = accIdValues++;
		totalAccounts++;
	}

	public BankAccount(String accHolderName, String accType, double balance) {
		this();		
		this.accHolderName = accHolderName;
		this.accType = accType;
		this.balance = balance;		
	}

	public double withdraw(double amount) {
		if (balance - amount >= 0)
			balance = balance - amount;
		else
			System.out.println("You don't have sufficient balance.");
		return balance;
	}

	public double deposit(double amount) {
		balance = balance + amount;
		return balance;
	}

	public double getBalance() {
		return balance;
	}

	public void displayBankAccountDetails() {
		System.out.println("Account Id : " + accId + "\nAccount holder name: " + accHolderName + "\nAccount type: "
				+ accType + "\nAccount balance: " + balance);
	}

	public static long totalBankAccounts() {
		return totalAccounts;
	}

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
