package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		// PARTE 1 - Dados de Leitura:

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			// Employee emp = new Employee(id, name, salary);
			// list.add(emp);
			list.add(new Employee(id, name, salary));

		}

		// PARTE 2 - Aumentar o salário:

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		// Chamar a função auxiliar - 2 formas:
		
		// Primeira forma
		
//		int idSalary = sc.nextInt();
//		Integer pos = position(list, idSalary);
//		if (pos == null) {
//			System.out.println("This id does not exist!");
//		}
//		else {
//			System.out.print("Enter the percentage: ");
//			double percentage = sc.nextDouble();
//			list.get(pos).increaseSalary(percentage);
//		}	

		// Segunda forma
		
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		// PARTE 3 - Lista de Funcionários

		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}

		sc.close();

	}

	// Função auxiliar pra ver se "ID" consta na lista - 2 FORMAS DE FAZER:

	// Primeira Forma:

	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	// Segunda Forma

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
