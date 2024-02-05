package APCSA.FRQ._2010;

public class FrqAns2010Q1b {
	public static void main(String[] args) {
		boolean test1 = false;
		boolean test2 = false;

		MasterOrder2 order = new MasterOrder2(10);
		// Test for 2010 FRQ 1.(a)
		if (order.getTotalBoxes() == 0)
			test1 = true;
		else
			System.out.println("Oops! Looks like your code doesn't properly check to see if the master order is empty.\n");

		order.setOrder1(3, new CookyOrder("Raisin", 3));
		order.setOrder1(5, new CookyOrder("Oatmeal", 8));
		order.setOrder2(6, "Raisin", 2);
		order.setOrder2(8, "Tea", 1);

		// Test for 2010 FRQ 1.(a)
		if (order.getTotalBoxes() == 14) // 3+8+2+1=14
			test2 = true;
		else
			System.out.println("Oops! Looks like your code doesn't properly count the number of boxes in the master order.\n");
		// Test for 2010 FRQ 1.(a)
		if (test1 && test2)
			System.out.println("Looks like your code works well!"); // Test for 2010 FRQ 1.(a)
		else
			System.out.println("Make some changes to your code, please.");
	
		// Test for 2010 FRQ 1.(b)
		MasterOrder2 goodies = new MasterOrder2(4);
		goodies.setOrder1(0, new CookyOrder("Chocolate Chip", 1));
		goodies.setOrder1(1, new CookyOrder("Shortbread", 5));
		goodies.setOrder2(2, "Macaroon", 2);
		goodies.setOrder2(3, "Chocolate Chip", 3);
		goodies.display();
		System.out.println("Remove Index: " + goodies.removeVariety("Macaroon"));
		System.out.println("Remove Index: " + goodies.removeVariety("Chocolate Chip"));
		System.out.println("Remove Index: " + goodies.removeVariety("Chocolate Chip"));
		goodies.display();
	}
}

class CookyOrder {
	String variety;
	int numBoxes;

	/** Constructs a new CookieOrder object. */
	public CookyOrder(String variety, int numBoxes) {
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

class MasterOrder2 {
	/** The list of all cookie orders */
	private CookyOrder[] orders;

	/** Constructs a new MasterOrder object. */
	public MasterOrder2(int size) {
		orders = new CookyOrder[size];
	}

	/**
	 * Adds theOrder to the master order.
	 * 
	 * @param theOrder the cookie order to add to the master order
	 */
	public void setOrder1(int index, CookyOrder theOrder) {
		orders[index]=theOrder;
	}
	
	public void setOrder2(int index, String variety, int numBoxes) {
		orders[index]=new CookyOrder(variety, numBoxes);
	}

	/**
	 * @return the sum of the number of boxes of all of the cookie orders
	 */
	// Answer for 2010 FRQ 1.(a)
	public int getTotalBoxes() { 
		int total = 0;
		int total2 = 0;
		// Option Answer 1: for i-loop
		for (int i=0; i < orders.length; i++) {
			if(orders[i]!=null) {
				total = total + orders[i].getNumBoxes();
				// DEBUG: System.out.println(orders[i].getVariety()+"  "+orders[i].getNumBoxes());
			}
		}
		// Option Answer 2: enhanced for loop
		for (CookyOrder element : orders) {
			if (element!=null) {
				total2 = total2 + element.getNumBoxes();
				// DEBUG: System.out.println(element.getVariety()+"  "+element.getNumBoxes());
			}
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
		int index = -1;
		for (int i=0; i < orders.length; i++) {
			if (orders[i]!=null && orders[i].getVariety().equals(cookieVar)) {
				index = i;
				orders[i] = null;
				break;
			}
		}
		return index;
	}

	public void display() {
		for (CookyOrder element : orders) {
			if (element == null)
				System.out.println("NULL");
			else
				System.out.println(element.getVariety() + " = " + element.getNumBoxes());
		}
		System.out.println("**********");
	}
} // End of MasterOrder class