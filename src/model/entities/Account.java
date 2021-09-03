package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	// Methods
	public void deposit(double ammount) {
		balance += ammount;
	}

	public void withdraw(double ammount) {
		validateWithdraw(ammount);
		balance -= ammount;
	}

	public void validateWithdraw(double ammount) {
		if (ammount > getWithdrawLimit()) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (ammount > getBalance()) {
			throw new DomainException("Not enough balance");
		}
	}
}
