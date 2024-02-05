package APCSA.FRQ._2010;

/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2010Q1a {
	public static void main(String[] args) {
		boolean test1 = false;
		boolean test2 = false;

		MasterOrder order = new MasterOrder();
		// Test for 2010 FRQ 1.(a)
		if (order.getTotalBoxes() == 0)
			test1 = true;
		else
			System.out.println(
					"Oops! Looks like your code doesn't properly check to see if the master order is empty.\n");

		order.addOrder(new CookieOrder("Raisin", 3));
		order.addOrder(new CookieOrder("Oatmeal", 8));
		// Test for 2010 FRQ 1.(a)
		if (order.getTotalBoxes() == 11)
			test2 = true;
		else
			System.out.println(
					"Oops! Looks like your code doesn't properly count the number of boxes in the master order.\n");
		// Test for 2010 FRQ 1.(a)
		if (test1 && test2)
			System.out.println("Looks like your code works well!"); // Test for 2010 FRQ 1.(a)
		else
			System.out.println("Make some changes to your code, please.");

		// Test for 2010 FRQ 1.(b)
		MasterOrder goodies = new MasterOrder();
		goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
		goodies.addOrder(new CookieOrder("Shortbread", 5));
		goodies.addOrder(new CookieOrder("Macaroon", 2));
		goodies.addOrder(new CookieOrder("Chocolate Chip", 3));
		goodies.display();
		System.out.println("Remove Index: " + goodies.removeVariety("Macaroon"));
		System.out.println("Remove Index: " + goodies.removeVariety("Chocolate Chip"));
		System.out.println("Remove Index: " + goodies.removeVariety("Chocolate Chip"));
		goodies.display();
	}
}

class CookieOrder {
	String variety;
	int numBoxes;

	/** Constructs a new CookieOrder object. */
	public CookieOrder(String variety, int numBoxes) {
		/* implementation not shown */
		this.variety = variety;
		this.numBoxes = numBoxes;
	}

	/**
	 * @return the variety of cookie being ordered
	 */
	public String getVariety() { /* implementation not shown */
		return this.variety;
	}

	/**
	 * @return the number of boxes being ordered
	 */
	public int getNumBoxes() { /* implementation not shown */
		return this.numBoxes;
	}
// There may be instance variables, constructors, and methods that are not shown.
}

class MasterOrder {
	/** The list of all cookie orders */
	private List<CookieOrder> orders;

	/** Constructs a new MasterOrder object. */
	public MasterOrder() {
		orders = new ArrayList<CookieOrder>();
	}

	/**
	 * Adds theOrder to the master order.
	 * 
	 * @param theOrder the cookie order to add to the master order
	 */
	public void addOrder(CookieOrder theOrder) {
		orders.add(theOrder);
	}

	/**
	 * @return the sum of the number of boxes of all of the cookie orders
	 */
	// Answer for 2010 FRQ 1.(a)
	public int getTotalBoxes() {
		int total = 0;
		int total2 = 0;
		// Option Answer 1: for i-loop
		for (int i = 0; i < orders.size(); i++) {
			total = total + orders.get(i).getNumBoxes();
			// DEBUG: System.out.println(orders.get(i).getVariety()+"
			// "+orders.get(i).getNumBoxes());
		}
		// Option Answer 2: enhanced for loop
		for (CookieOrder element : orders) {
			total2 = total2 + element.getNumBoxes();
			// DEBUG: System.out.println(element.getVariety()+" "+element.getNumBoxes());
		}
		return total;
	}

	/**
	 * Removes all cookie orders from the master order that have the same variety of
	 * cookie as cookieVar and returns the total number of boxes that were removed.
	 * 
	 * @param cookieVar the variety of cookies to remove from the master order
	 * @return the total number of boxes of cookieVar in the cookie orders removed
	 */
	// Answer for 2010 FRQ 1.(b)

	public int removeVariety(String cookieVar) {
		int numBoxesRemoved = 0;
		for (int i = this.orders.size() - 1; i >= 0; i--) {
			if (cookieVar.equals(this.orders.get(i).getVariety())) {
				numBoxesRemoved += this.orders.get(i).getNumBoxes();
				this.orders.remove(i);
			}
		}
		return numBoxesRemoved;
	}

	// Alternative solution (forward traversal direction):
	public int removeVariety2(String cookieVar) {
		int numBoxesRemoved = 0;
		int i = 0;
		while (i < this.orders.size()) {
			if (cookieVar.equals(this.orders.get(i).getVariety())) {
				numBoxesRemoved += this.orders.get(i).getNumBoxes();
				this.orders.remove(i);
			} else {
				i++;
			}
		}
		return numBoxesRemoved;
	}
	
	public int removeVariety3(String cookieVar) {
		int index = -1;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getVariety().equals(cookieVar)) {
				index = i;
				orders.remove(i);
				break;
			}
		}
		return index;
	}

	public void display() {
		for (CookieOrder element : orders) {
			System.out.println(element.getVariety() + " = " + element.getNumBoxes());
		}
		System.out.println("**********");
	}
} // End of MasterOrder class