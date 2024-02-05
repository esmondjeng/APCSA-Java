package APCSA.FRQ._2004;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2004Q4 {
	public static void main(String[] args) {
		int[] initialHall1 = {1, 0, 2, 2};
		int[] initialHall2 = {1, 0, 2, 2};
		Robot emsondRobot = new Robot(initialHall1, 2);
		// Test for 2004 FRQ 4.(a)(b)
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		emsondRobot.move();
		emsondRobot.display();
		
		// Test for 2004 FRQ 4.(b)(c)
		Robot ethanRobot = new Robot(initialHall2, 2);
		ethanRobot.display();
		System.out.printf("Steps for Robot to clear hall: %d \n", ethanRobot.clearHall());
		ethanRobot.display();
		
	}
}

class Robot {
	private int[] hall;
	private int pos; // current position(tile number) of Robot
	private boolean facingRight; // true means this Robot is facing right

	public Robot(int[] initialHall, int initialPos) {
		this.hall = initialHall;
		this.pos = initialPos;
		this.facingRight = true;
	}

	/*
	 * Postcondition: returns true if this Robot has a wall immediately in
	 * front of it, so that it cannot move forward; otherwise, returns false
	 */
	// Answer for 2004 FRQ 4.(a)
	private boolean forwardMoveBlocked() {
		/* 1. Facing right and bottom (last = len-1) */ 
		if(facingRight && pos == hall.length-1) {
			return true;
		/* 2. Facing left and bottom (first=0) */
		} else if(!facingRight && pos == 0) {
			return true;
		/* 3. Right or Left but not at bottom position */
		} else {
			return false;
		}
	}

	/*
	 * Postcondition: one move has been made according to the
	 * specifications above and the state of this Robot has been updated
	 */
	// Answer for 2004 FRQ 4.(b)
	public void move() {
		/* 1. Not empty tile, then remove one item. No matter where it is */ 
		if(hall[pos]>0) {
			hall[pos] = hall[pos] -1;
		}
		
		/* 2. If empty tile && NOT reach bottom */ 
		if(hall[pos]==0 && forwardMoveBlocked() != true) {
			if(facingRight)
				pos = pos + 1;	// Facing right, move in one index
			else
				pos = pos - 1;;	// Facing left, decrease one index
		/* 3. If empty tile && reach bottom, so turn */ 
		} else if(hall[pos]==0 && forwardMoveBlocked() == true) {
			if(facingRight) // Toggle facingRight
				facingRight=false;
			else
				facingRight=true;
		}
	}
	/*
	 * Postcondition: no more items remain in the hallway;
	 * returns the number of moves made
	 */
	// Answer for 2004 FRQ 4.(c)
	public int clearHall() {
		int count = 0;
		while (hallIsClear() != true) {
			move();
			// display();
			count++;
		}
		return count;
	}

	/*
	 * Postcondition: returns true if the hallway contains no items;
	 * otherwise, returns false
	 */
	private boolean hallIsClear() {
		for(int element:  this.hall) {
			if (element != 0)
				return false;
		}
		return true;
	}
	
	public void display() {
		for (int i=0; i < this.hall.length; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		for (int element: this.hall) {
			System.out.printf("%3d", element);
		}
		System.out.println();
		
		for (int i=0; i < this.hall.length; i++) {
			if (pos == i && facingRight)
				System.out.printf("%3s", ">");
			else if (pos == i && !facingRight)
				System.out.printf("%3s", "<");
			else
				System.out.printf("%3s", " ");
		}
		System.out.println("\n**************\n");
	}
}