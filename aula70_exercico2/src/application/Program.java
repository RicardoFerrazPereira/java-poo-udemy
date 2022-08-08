package application;

import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Funcionario f = new Funcionario();

		System.out.print("Nome: ");
		f.nome = sc.nextLine();
		System.out.print("Sal�rio Bruto: R$");
		f.salBruto = sc.nextDouble();
		System.out.print("Imposto: R$");
		f.imposto = sc.nextDouble();

		System.out.println("Aumentar o sal�rio em quanto %: ");
		f.aumentarSalario(sc.nextDouble());

		// f.aumentarSalario(10);

		System.out.println(f.toString());

		sc.close();

	}
}
