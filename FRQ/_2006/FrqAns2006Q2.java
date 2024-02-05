package APCSA.FRQ._2006;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2006Q2 {
	public static void main(String[] args) {
		Vehicle automobile = new Vehicle(10000.0, 3500.0, 0.06);
		System.out.println("List Price: " + automobile.getListPrice());
		System.out.println("Purchase Price in Shop: " + automobile.purchasePrice());
		System.out.println("Check: " + (10000.0+3500.0)*(1+0.06));
	}
}

interface Item {
	double purchasePrice();
}

abstract class TaxableItem implements Item {
	private double taxRate;

	public abstract double getListPrice();

	public TaxableItem(double rate) {
		this.taxRate = rate;
	}

	// returns the price of the item including the tax
	// Answer for 2006 FRQ 2.(a)
	public double purchasePrice() {
		/* to be implemented in part (a) */
		return (1 + taxRate) * getListPrice();
	}
}

// Answer for 2006 FRQ 2.(b)
class Vehicle extends TaxableItem {
	private double dealerCost;
	private double dealerMarkup;

	public Vehicle(double cost, double markup, double rate) {
		super(rate);
		this.dealerCost = cost;
		this.dealerMarkup = markup;
	}

	public void changeMarkup(double newMarkup) {
		dealerMarkup = newMarkup;
	}

	public double getListPrice() {
		return dealerCost + dealerMarkup;
	}
}