package APCSA.FRQ._2004;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2004Q1 {
	public static void main(String[] args) {
		WordList animal = new WordList();
		animal.addList("cat");
		animal.addList("mouse");
		animal.addList("frog");
		animal.addList("dog");
		animal.addList("dog");
		// Test for 2004 FRQ 1.(a)
		System.out.println(animal.numWordsOfLength(4));
		System.out.println(animal.numWordsOfLength(3));
		System.out.println(animal.numWordsOfLength(2));
		
		// Test for 2004 FRQ 1.(b)
		animal.display();
		System.out.println("**********");
		animal.removeWordsOfLength(3);
		animal.display();
	}
}

class WordList {
	private ArrayList<String> myList; // contains Strings made up of letters


	public WordList() {
		this.myList = new ArrayList<String>();
	}

	public void addList(String str) {
		this.myList.add(str);
	}

	/*
	 * Postcondition: returns the number of words in this WordList that
	 * are exactly len letters long
	 */
	// Answer for 2004 FRQ 1.(a)
	public int numWordsOfLength(int len) {
		int count = 0;
		for (String element : myList) {
			if(element.length() == len)
				count++;
		}
		return count;
	}

	/*
	 * Postcondition: all words that are exactly len letters long have been removed
	 * from this WordList, with the order of the remaining words unchanged
	 */
	// Answer for 2004 FRQ 1.(b)
	public void removeWordsOfLength(int len) {
		// Build remove list
		ArrayList<Integer> removeList = new ArrayList<Integer>();
		for (int i=0; i < myList.size(); i++) {
			if(myList.get(i).length() == len)
				removeList.add(i);
		}
		// DEBUG: System.out.println(removeList);
		
		// Traverse the remove list reversely to remove element from myList
		for (int i=removeList.size()-1; i >= 0 ; i--) {
			myList.remove((int) removeList.get(i));
		}
	}
	
	public void display() {
		System.out.println(myList);
	}
}