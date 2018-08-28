package com.capgemini.bankaccount;

public class SavingBankAccount extends BankAccount {

	public static final double MIN_BALANCE = 10000;
	private boolean salaryAccount;

	public SavingBankAccount() {
		super();
	}

	public SavingBankAccount(String accHolderName, double balance, boolean salaryAccount) {
		super(accHolderName, "SAVING", balance);
		this.salaryAccount = salaryAccount;
	}

	public boolean isSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(boolean salaryAccount) {
		this.salaryAccount = salaryAccount;
	}

	@Override
	public double withdraw(double amount) {
		if(salaryAccount) 
			return super.withdraw(amount);
		else {
			if(getBalance() - amount >= MIN_BALANCE)
				setBalance(getBalance() -  amount);
			else
				System.out.println("You don't have sufficient balance.");
		}
		return getBalance();
	}
	
	@Override
	public void displayBankAccountDetails() {
		super.displayBankAccountDetails();
		System.out.println("Salary Account?: " + salaryAccount);
	}

}
