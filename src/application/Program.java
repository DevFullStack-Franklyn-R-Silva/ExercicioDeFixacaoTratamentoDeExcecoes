package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.println("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.println("Holder: ");
			String holder = sc.nextLine();
			System.out.println("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.println("Withdraw limit:");
			double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.println("Enter amount for withdraw:");
			double ammount = sc.nextDouble();
			account.withdraw(ammount);

			System.out.println("New balance: "+String.format("%.2f", account.getBalance()));
			
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());

		} catch (InputMismatchException e) {
			System.out.println("Enter numbers   " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();

	}

}
