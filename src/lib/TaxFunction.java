package lib;

public class TaxFunction {

	private static final int BASE_NON_TAXABLE_INCOME = 54000000;
	private static final int MARRIAGE_ALLOWANCE = 4500000;
	private static final int CHILD_ALLOWANCE = 1500000;
	private static final int MAX_CHILDREN_COUNT = 3;
	private static final double TAX_RATE = 0.05;

	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthsWorked, int deductible, boolean isSingle, int numberOfChildren) {
		if (monthsWorked > 12) {
			System.err.println("More than 12 months working per year");
			monthsWorked = 12;
		}

		
		int eligibleChildren = Math.min(numberOfChildren, MAX_CHILDREN_COUNT);

		
		int annualIncome = (monthlySalary + otherMonthlyIncome) * monthsWorked;
		int nonTaxableIncome = BASE_NON_TAXABLE_INCOME;

		if (!isSingle) {
			nonTaxableIncome += MARRIAGE_ALLOWANCE + (eligibleChildren * CHILD_ALLOWANCE);
		}

		int taxableIncome = annualIncome - deductible - nonTaxableIncome;
		int tax = (int) Math.round(TAX_RATE * Math.max(taxableIncome, 0));

		return tax;
	}
}
