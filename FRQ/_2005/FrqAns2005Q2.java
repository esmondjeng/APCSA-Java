package APCSA.FRQ._2005;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2005Q2 {
	public static void main(String[] args) {
		// Test for 2005 FRQ 2.(a)
		Advance adv1 = new Advance(3); // Try to change this to 10 and 13
		Advance adv2 = new Advance(13);
		System.out.println(adv1);
		System.out.println(adv2);
		
		// Test for 2005 FRQ 2.(b)
		StudentAdvance stuAdv1 = new StudentAdvance(3);
		StudentAdvance stuAdv2 = new StudentAdvance(13);
		System.out.println(stuAdv1);
		System.out.println(stuAdv2);
	}
}

abstract class Ticket {
	private int serialNumber; // unique ticket id number
	private static int sequence;

	public Ticket() {
		serialNumber = getNextSerialNumber();
	}

	// returns the price for this ticket
	public abstract double getPrice();

	// returns a string with information about the ticket
	public String toString() {
		return "Number: " + serialNumber + "\nPrice: " + getPrice();
	}

	// returns a new unique serial number
	private static int getNextSerialNumber() {
		return ++sequence;
	}
}

// Answer for 2005 FRQ 2.(a)
class Advance extends Ticket {
	private double price;
	
	public Advance(int daysInAdvance) {
		if(daysInAdvance > 9)
			this.price = 30;
		else
			this.price = 40;
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
}

// Answer for 2005 FRQ 2.(b)
class StudentAdvance extends Advance {
	private double price;
	
	public StudentAdvance(int daysInAdvance) {
		super(daysInAdvance);
		this.price = (super.getPrice()/2.0);
	}
	@Override
	public double getPrice() {
		return this.price;
	}
	
	public String toString() {
		return super.toString() + " (Student ID required!)";
	}
}