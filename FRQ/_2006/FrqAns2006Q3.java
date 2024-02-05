package APCSA.FRQ._2006;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2006Q3 {
	public static void main(String[] args) {
		Customer c1 = new Customer("Smith", 1001);
		Customer c2 = new Customer("Anderson", 1002);
		Customer c3 = new Customer("Smith", 1003);
		// Test for 2006 FRQ 3.(a)
		System.out.println(c1.compareCustomer(c1));
		System.out.println(c1.compareCustomer(c2));
		System.out.println(c1.compareCustomer(c3));
		System.out.println("**********\n");
		
		Customer[] list1 = {new Customer("Arthur", 4290),
							new Customer("Burton", 3911),
							new Customer("Burton", 4944),
							new Customer("Franz", 1692),
							new Customer("Horton", 9221),
							new Customer("Jones", 5554),
							new Customer("Miller", 9360),
							new Customer("Nguyen", 4339)};
		Customer[] list2 = {new Customer("Aaron", 1729),
							new Customer("Baker", 2921),
							new Customer("Burton", 3911),
							new Customer("Dillard", 6552),
							new Customer("Jones", 5554),
							new Customer("Miller", 9360),
							new Customer("Noble", 3335)};
		Customer[] result = new Customer[Math.min(list1.length, list2.length)-1];
		// Test for 2006 FRQ 3.(b)
		Customer.prefixMerge(list1, list2, result);
		prind1D(list1);
		prind1D(list2);
		prind1D(result);
		
	}
	
	public static void prind1D(Customer[] c) {
		for(Customer element : c) {
			System.out.println(element);
		}
		System.out.println("\n**********\n");
	}
}

class Customer {
	String name;
	int idNum;

	// constructs a Customer with given name and ID number
	public Customer(String name, int idNum) {
		this.name = name;
		this.idNum = idNum;
	}

	// returns the customer's name
	public String getName() {
		return this.name;
	}

	// returns the customer's id
	public int getID() {
		return this.idNum;
	}

	/*
	 * // returns 0 when this customer is equal to other; a positive integer when
	 * this customer is greater than other; a negative integer when this customer is
	 * less than other
	 */
	// Answer for 2006 FRQ 3.(a)
	public int compareCustomer(Customer other) {
		int nameCompare = getName().compareTo(other.getName());
		if (nameCompare != 0) {
			return nameCompare;
		} else {
			return this.getID() - other.getID();
		}
	}

	// Answer for 2006 FRQ 3.(b)
	public static void prefixMerge(Customer[] list1, Customer[] list2, Customer[] result) {
		int front1 = 0;
		int front2 = 0;
		for (int i = 0; i < result.length; i++) {
			int comparison = list1[front1].compareCustomer(list2[front2]);
			if (comparison < 0) {
				result[i] = list1[front1];
				front1++;
			} else if (comparison > 0) {
				result[i] = list2[front2];
				front2++;
			} else {
				result[i] = list1[front1];
				front1++;
				front2++;
			}
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s (%d)", this.getName(), this.getID());
	}
}