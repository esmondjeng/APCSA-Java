package APCSA.FRQ._2022;

/**
 * This is superclass + subclass to practice inheritance
 * @author esmondjeng
 */

//Test for 2022 FRQ 2 to wite the whole subclass
public class FrqAns2022Q2 {
	public static void main(String[] args) {
		Textbook bio2015 = new Textbook("Biology" , 49.75, 2);
		Textbook bio2019 = new Textbook("Biology" , 39.75, 3);
		// Test for 2022 FRQ 2.(a1)
		System.out.println(bio2019.getEdition());
		// Test for 2022 FRQ 2.(a2)
		System.out.println(bio2019.getBookInfo());
		System.out.println();
		
		// Test for 2022 FRQ 2.(b)
		System.out.println(bio2019.canSubstituteFor(bio2015));
		
		Textbook math = new	Textbook("Calculus" , 45.25, 1);
		System.out.println(bio2015.canSubstituteFor(math));
	}
}

class Book {
	/** The title of the book */
	private String title;
	/** The price of the book */
	private double price;

	/** Creates a new Book with given title and price */
	public Book(String bookTitle, double bookPrice) {
		title = bookTitle;
		price = bookPrice;
	}

	/** Returns the title of the book */
	public String getTitle() {
		return title;
	}

	/** Returns a string containing the title and price of the Book */
	public String getBookInfo() {
		return title + "-" + price;
	}
}
// There may be instance variables, constructors, and methods that are not shown. }

// Answer for 2022 FRQ 2 to wite the whole subclass
class Textbook extends Book {
	// positive, version of the books
	private int editionNo;

	public Textbook(String bookTitle, double bookPrice, int editionNo) {
		super(bookTitle, bookPrice);
		this.editionNo = editionNo;
	}
	
	// Answer for 2022 FRQ 2.(a1)
	public int getEdition() {
		return this.editionNo;
	}
	
	// Answer for 2022 FRQ 2.(a2)
	@Override
	public String getBookInfo() {
		String str = super.getBookInfo() + "-" + this.getEdition();
		return str;
	}
	
	// Answer for 2022 FRQ 2.(b)
	public boolean canSubstituteFor(Textbook forBook) {
		// System.out.println(super.getTitle());
		// System.out.println(this.getEdition());
		// System.out.println(forBook.getTitle());
		// System.out.println(forBook.getEdition());
		if (super.getTitle().equals(forBook.getTitle())) {
			if(forBook.getEdition() < this.getEdition()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}