package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.bankaccount.BankAccount;
import com.capgemini.bankaccount.SavingBankAccount;

class BankAccountTest {

	BankAccount account;
	BankAccount account1;
	
	@BeforeEach
	void setUp() {
		account = new SavingBankAccount("John", 50000, true);
		account1 = new SavingBankAccount("John", 50000, true);
	}

	@Test
	void testWithdraw() {
		assertEquals(45000.0, account.withdraw(5000), 0.04);
		assertEquals(38000.0, account.withdraw(7000), 0.04);
		assertEquals(33432.66, account.withdraw(4567.34), 0.04);
		assertEquals(33432.66, account.withdraw(120000), 0.04);
	}

	@Test
	void totalBankAcounts() {
		assertEquals(2, BankAccount.totalBankAccounts());
	}

	@AfterEach
	void tearDown() {
		BankAccount.setTotalAccounts(0);
	}

}
