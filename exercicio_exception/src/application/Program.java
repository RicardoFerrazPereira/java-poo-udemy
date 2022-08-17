package application;

import java.util.Scanner;

import model.entities.Account;
import model.exception.BusinessException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe os dados da conta");

		System.out.println("Número da conta: ");
		int number = sc.nextInt();

		System.out.println("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();

		System.out.println("Saldo inicial: ");
		double balance = sc.nextDouble();

		System.out.println("Limite de Saque: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.println();
		System.out.println("Informe um quantia para sacar: ");
		double amount = sc.nextDouble();

		try {
			acc.withdraw(amount);
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		} 
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}

}
