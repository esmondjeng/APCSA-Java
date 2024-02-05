package APCSA.FRQ._2004;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2004Q2 {
	public static void main(String[] args) {
		Dog ddog = new Dog("Esmond");
		Cat ccat = new Cat("Ethan");
		LoudDog loudDDog = new LoudDog("Jack");
		// Test for 2004 FRQ 2.(a)
		// Test for 2004 FRQ 2.(b)
		System.out.println(ddog.speak());
		System.out.println(ccat.speak());
		System.out.println(loudDDog.speak());
	}
}

abstract class Pet {
	private String myName;

	public Pet(String name) {
		myName = name;
	}

	public String getName() {
		return myName;
	}

	public abstract String speak();
}

class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}

	public String speak() {
		return "Wang";
	}
}

// Answer for 2004 FRQ 2.(a)
class Cat extends Pet {
	public Cat(String name) {
		super(name);
		/* implementation not shown */
	}

	public String speak() { /* implementation not shown */
		return "Meow";
	}
}

// Answer for 2004 FRQ 2.(b)
class LoudDog extends Dog {
	public LoudDog(String name) {
		super(name);
	}

	public String speak() {
		return super.speak() + " " + super.speak();
	}
}