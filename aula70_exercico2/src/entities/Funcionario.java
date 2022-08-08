package entities;

public class Funcionario {
	
	public String nome;
	public double salBruto;
	public double imposto;
	
	public void aumentarSalario(double porcentagem) {
		salBruto += salBruto * (porcentagem/100); 
		
	}
	public double netSalario() {
		return salBruto - imposto;
			
	}
	@Override
	public String toString() {
		return "Funcion�rio: " + nome + "\nSal�rio Liquido: R$ " + String.format("%.2f", netSalario());
		
	}
}
