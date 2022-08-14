package entities;

public class Individual extends TaxPayer {
	
	private Double healthSpending;
	
	public Individual(String name, Double annualIncome, Double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}
	
	@Override
	public Double tax() {
		if(getAnnualIncome() < 20000.0) {
			return getAnnualIncome() * 0.15 - healthSpending * 0.5;			
		}
		else {
			return getAnnualIncome() * 0.25 - healthSpending * 0.5;	
		}
	}

}
