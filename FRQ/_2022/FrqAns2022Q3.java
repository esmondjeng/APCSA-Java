package APCSA.FRQ._2022;

import java.util.ArrayList;

/**
 * This is typical 1-to-M object Array. One ReviewAnalysis object to Many Review
 * objects.
 * @author esmondjeng
 */
public class FrqAns2022Q3 {
	public static void main(String[] args) {
		Review r1 = new Review (4, "Good! Thx");
		Review r2 = new Review (3, "Ok Site");
		Review r3 = new Review (5, "Great!");
		Review r4 = new Review (2, "Poor! Bad");
		Review r5 = new Review (3, "");
		
		ReviewAnalysis site1 = new ReviewAnalysis(5);
		site1.setReview(0, r1);
		site1.setReview(1, r2);
		site1.setReview(2, r3);
		site1.setReview(3, r4);
		site1.setReview(4, r5);
		site1.display();
		
		// Test for 2022 FRQ 3.(a)
		System.out.println(site1.getAverageRating());
		System.out.println(site1.getAverageRating2());
		System.out.println();
		
		// Test for 2022 FRQ 3.(b)
		System.out.println(site1.collectComments());
		System.out.println();
	}
}

class Review {
	private int rating;
	private String comment;

	/**
	 * Precondition: r>= 0 c is not null.
	 */
	public Review(int r, String c) {
		rating = r;
		comment = c;
	}

	public int getRating() {
		return rating;
	}

	public String getComment() {
		return comment;
	}
// There may be instance variables, constructors, and methods that are not shown.
}

class ReviewAnalysis {
	/** All user reviews to be included in this analysis */
	private Review[] allReviews;

	/** Initializes allReviews to contain all the Review objects to be analyzed */
	public ReviewAnalysis(int num) {
		allReviews =  new Review[num];
	}
	
	public void setReview(int index, Review r) {
		allReviews[index] = r;
	}

	/**
	 * Returns a double representing the average rating of all the Review objects to
	 * be analyzed, as described in part (a) Precondition: allReviews contains at
	 * least one Review. No element of allReviews is null.
	 */
	// Answer for 2022 FRQ 3.(a)
	public double getAverageRating() { 
		double sum = 0.0;
		for (Review e: allReviews) {
			sum = sum + e.getRating();
		}
		
		return (double) (sum / allReviews.length);
	}

	public double getAverageRating2() {
		double sum = 0.0;
		for (int i=0; i<allReviews.length; i++) {
			sum = sum + allReviews[i].getRating();
		}
		
		return (double) (sum / allReviews.length);
	}

	
	/**
	 * Returns an ArrayList of String objects containing formatted versions of
	 * selected user comments, as described in part (b) Precondition: allReviews
	 * contains at least one Review. No element of allReviews is null.
	 * Postcondition: allReviews is unchanged.
	 */
	// Answer for 2022 FRQ 3.(b)
	public ArrayList<String> collectComments() { 
		/* to be implemented in part (b) */
		ArrayList<String> strArr = new ArrayList<String>();
		
		for (int i=0; i < allReviews.length; i++) {
			if (allReviews[i].getComment().indexOf("!")!=-1) {
				String str = i + "-" +  allReviews[i].getComment();
				strArr.add(str);
				// System.out.println(str + "-->" + allReviews[i].getComment().indexOf("!"));
			}
		}
		
		return strArr;
	}
	
	public void display() {
		for (int i=0; i<allReviews.length; i++) {
			System.out.printf("Rating: %d; %s\n", allReviews[i].getRating(), allReviews[i].getComment());
		}
		System.out.println();
		for (Review e: allReviews) {
			System.out.printf("Rating: %d; %s\n", e.getRating(), e.getComment());
		}
		System.out.println();
	}
}