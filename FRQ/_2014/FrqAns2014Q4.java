package APCSA.FRQ._2014;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2014Q4 {
	public static void main(String[] args) {
		// Declare Sandwitch objects
		Sandwich sw1 = new Sandwich("Cheeseburger", 2.75);
		Sandwich sw2 = new Sandwich("Club Sandwich", 2.75);
		
		// Declare Salad ArrayList
		ArrayList<Salad> s = new ArrayList<Salad>();
		s.add(new Salad("Spinach Salad", 1.25));
		s.add(new Salad("Coleslaw", 1.35));
		
		// Declare Drink Array
		Drink[] d = new Drink[2];
		d[0] = new Drink("Orange Soda", 1.25);
		d[1] = new Drink("Cappuccino", 3.50);
		
		// Print out objects, ArrayList, Array
		System.out.println(sw1);
		System.out.println(sw2);
		System.out.println(s);
		System.out.println(s.get(0));
		System.out.println(s.get(1));
		System.out.println(d[0]);
		System.out.println(d[1]);
		
		// Test for 1st & 2nd Optional Answers for 2014 FRQ 4
		Trio1 t1 = new Trio1(sw1, s.get(0), d[0]);
		Trio2 t2 = new Trio2(sw2, s.get(1), d[1]);
		Trio1 tt1 = new Trio1(sw2, s.get(0), d[1]);
		Trio2 tt2 = new Trio2(sw1, s.get(1), d[0]);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(tt1);
		System.out.println(tt2);
	}
}

interface MenuItem {
	/** @return the name of the menu item */
	String getName();

	/** @return the price of the menu item */
	double getPrice();
}

class Sandwich implements MenuItem {
	String name;
	double price;
	
	public Sandwich(String name, double price) {
		this.name = name;
		this.price = price;
	}
	// follow interface MenuItem's getter
	public String getName() {
		return this.name;
	}
	// follow interface MenuItem's getter
	/** @return the price of the menu item */
	public double getPrice() {
		return this.price;
	}
	@Override
	public String toString() {
		return ("Sandwitch: " + this.getName() + "\n" + "Price: "+ this.getPrice());
	}
}

class Salad implements MenuItem {
	String name;
	double price;
	// Construct
	public Salad(String name, double price) {
		this.name = name;
		this.price = price;
	}
	// follow interface MenuItem's getter
	public String getName() {
		return this.name;
	}
	// follow interface MenuItem's getter
	/** @return the price of the menu item */
	public double getPrice() {
		return this.price;
	}
	@Override
	public String toString() {
		return ("Salad: " + this.getName() + "\n" + "Price: "+ this.getPrice());
	}
}

class Drink implements MenuItem {
	String name;
	double price;
	// Construct
	public Drink(String name, double price) {
		this.name = name;
		this.price = price;
	}
	// follow interface MenuItem's getter
	public String getName() {
		return this.name;
	}
	// follow interface MenuItem's getter
	/** @return the price of the menu item */
	public double getPrice() {
		return this.price;
	}
	@Override
	public String toString() {
		return ("Drink: " + this.getName() + "\n" + "Price: "+ this.getPrice());
	}
}

// 1st Optional Answer for 2014 FRQ 4
class Trio1 implements MenuItem {
	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;

	public Trio1(Sandwich s, Salad sal, Drink d) {
		sandwich = s;
		salad = sal;
		drink = d;
	}

	public String getName() {
		return sandwich.getName() + "/" + salad.getName() + "/" + drink.getName();
	}

	public double getPrice() {
		double sandwichPrice = sandwich.getPrice();
		double saladPrice = salad.getPrice();
		double drinkPrice = drink.getPrice();
		if (sandwichPrice <= saladPrice && sandwichPrice <= drinkPrice)
			return saladPrice + drinkPrice;
		else if (saladPrice <= sandwichPrice && saladPrice <= drinkPrice)
			return sandwichPrice + drinkPrice;
		else
			return sandwichPrice + saladPrice;
	}
	@Override
	public String toString() {
		return ("Trio: " + this.getName() + "\n" + "Price: "+ this.getPrice());
	}
}

// 2nd Optional Answer for 2014 FRQ 4
class Trio2 implements MenuItem {
	private String name;
	private double price;

	public Trio2(Sandwich s, Salad sal, Drink d) {
		double sandwichPrice = s.getPrice();
		double saladPrice = sal.getPrice();
		double drinkPrice = d.getPrice();
		if (sandwichPrice <= saladPrice && sandwichPrice <= drinkPrice)
			price = saladPrice + drinkPrice;
		else if (saladPrice <= sandwichPrice && saladPrice <= drinkPrice)
			price = sandwichPrice + drinkPrice;
		else
			price = sandwichPrice + saladPrice;
		name = s.getName() + "/" + sal.getName() + "/" + d.getName() + " Trio";
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return ("Trio: " + this.getName() + "\n" + "Price: "+ this.getPrice());
	}
}
