package APCSA.FRQ._2008;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2008Q4 {
	public static void main(String[] args) {
		// Test for 2008 FRQ 4.(a)
		Checker broccoliChecker = new SubstringChecker("broccoli");
		System.out.println(broccoliChecker.accept("broccoli"));
		System.out.println(broccoliChecker.accept("I like broccoli"));
		System.out.println(broccoliChecker.accept("carrots are great"));
		System.out.println(broccoliChecker.accept("Broccoli Bonanza"));
		System.out.println();
		Checker EsmondChecker = new SubstringChecker("Esmond");
		System.out.println(EsmondChecker.accept("He is Esmond."));
		System.out.println(EsmondChecker.accept("Esmond is great."));
		System.out.println(EsmondChecker.accept("I don't like esmond."));
		System.out.println(EsmondChecker.accept("Ethan is his son"));
		System.out.println("**********");
		
		// Test for 2008 FRQ 4.(b) plus AndChecker class
		Checker aChecker = new SubstringChecker("artichokes");
		Checker bChecker = new SubstringChecker("beets");
		Checker cChecker = new SubstringChecker("carrots");
		Checker bothChecker = new AndChecker(bChecker, cChecker);
		Checker veggies = new AndChecker(bothChecker, aChecker);
		// DEBUG: System.out.println(bothChecker);
		// DEBUG: System.out.println(veggies);
		System.out.println(bothChecker.accept("I love beets and carrots"));
		System.out.println(bothChecker.accept("beets are great"));
		System.out.println(veggies.accept("artichokes, beets, and carrots"));	
		System.out.println("**********");
		
		// Test for Not Checker class
		Checker n = new NotChecker(EsmondChecker);
		System.out.println(n.accept("He is Esmond."));
		System.out.println(n.accept("Esmond is great."));
		System.out.println(n.accept("I don't like esmond."));
		System.out.println(n.accept("Ethan is his son"));
		System.out.println("**********");

		// Answer and Test for 2008 FRQ 4.(c)	
		Checker aaChecker = new SubstringChecker("artichokes");
		Checker kkChecker = new SubstringChecker("kale");
		Checker yummyChecker;
		/* code to construct and assign to yummyChecker */
		yummyChecker = new AndChecker(new NotChecker(aaChecker), new NotChecker(kkChecker));
		System.out.println(yummyChecker.accept("chocolate truffles"));
		System.out.println(yummyChecker.accept("kale is great"));
		System.out.println(yummyChecker.accept("Yuck: artichokes & kale"));
	}
}

interface Checker {
	/**
	 * @param text a string to consider for acceptance
	 * @return true if this Checker accepts text; false otherwise
	 */
	boolean accept(String text);
}


// Answer for 2008 FRQ 4.(a) SubstringChecker class
class SubstringChecker implements Checker {
	private String checkStr;

	public SubstringChecker(String str) {
		this.checkStr = str;
	}
	
	@Override
	public boolean accept(String text) {
		if (text.indexOf(this.checkStr) != -1)
			return true;
		else
			return false;
	}
}

// Answer for 2008 FRQ 4.(b) AndChecker class
class AndChecker implements Checker {
	Checker a;
	Checker b;
	
	public AndChecker(Checker a, Checker b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public boolean accept(String text) {
		if(this.a.accept(text) && this.b.accept(text))
			return true;
		else
			return false;
	}
}

class NotChecker implements Checker {
	Checker a;

	public NotChecker(Checker a) {
		this.a = a;
	}
	
	@Override
	public boolean accept(String text) {
		if(this.a.accept(text))
			return false;
		else
			return true;
	}
}