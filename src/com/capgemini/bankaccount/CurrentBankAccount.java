package com.capgemini.bankaccount;

public class CurrentBankAccount extends BankAccount {

	private double overdraftLimit;
	private double borrowedAmount;

	public CurrentBankAccount() {
	}

	public CurrentBankAccount(String accHolderName, double balance, double overdraftLimit) {
		super(accHolderName, "CURRENT", balance);
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public double withdraw(double amount) {
		double tempBalance = getBalance() - amount;
		if (tempBalance >= 0)
			return super.withdraw(amount);
		else if (Math.abs(tempBalance) <= (overdraftLimit - borrowedAmount)) {
			setBalance(0);
			borrowedAmount += Math.abs(tempBalance);
		} else
			System.out.println("Overdraft limit exceeds");
		return getBalance();
	}

	@Override
	public double deposit(double amount) {
		if (borrowedAmount == 0)
			return super.deposit(amount);
		else {
			if (amount <= borrowedAmount)
				borrowedAmount -= amount;
			else {
				setBalance(amount - borrowedAmount);
				borrowedAmount = 0;
			}
		}
		return getBalance();
	}

	@Override
	public void displayBankAccountDetails() {
		super.displayBankAccountDetails();
		System.out.println("Overdraft limit: " + overdraftLimit + "\nBorrowed amount: " + borrowedAmount);
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public double getBorrowedAmount() {
		return borrowedAmount;
	}

	public void setBorrowedAmount(double borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}


}
