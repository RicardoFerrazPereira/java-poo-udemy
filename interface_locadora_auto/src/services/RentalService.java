package services;

import entities.CarRental;
import entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;

	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	// gerar nota de pagamento do aluguel do carro
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		
		// Valor basico de pagamento
		double basicPayment;
		if (hours <= 12.0) {
			// arredondar o valor de horas para cima "Math.ceil".
			basicPayment = pricePerHour * Math.ceil(hours);
		} 
		else {
			// arredondar o valor de dias para cima "Math.ceil".
			basicPayment = pricePerDay * Math.ceil(hours / 24);
		}

		double tax = taxService.tax(basicPayment);
		
		// Criei um novo objeto de nota de pagamento e associei ele com o objeto aluguel
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

}
