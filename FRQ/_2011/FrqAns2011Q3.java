package APCSA.FRQ._2011;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.List;

public class FrqAns2011Q3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

interface FuelTank {
	/** @return an integer value that ranges from 0 (empty) to 100 (full) */
	int getFuelLevel();
}

class FuelTankX implements FuelTank {
	private int level;
	
	public FuelTankX() {
		this.level = 0;
	}
	
	public FuelTankX(int level) {
		if(level >= 0 && level <= 100)
			this.level = level;
	}
	
	@Override
	public int getFuelLevel() {
		return this.level;
	}
}

interface FuelRobot {
	/** @return the index of the current location of the robot */
	int getCurrentIndex();

	/**
	 * Determine whether the robot is currently facing to the right
	 * 
	 * @return true if the robot is facing to the right (toward tanks with larger
	 *         indexes) false if the robot is facing to the left (toward tanks with
	 *         smaller indexes)
	 */
	boolean isFacingRight();

	/** Changes the current direction of the robot */
	void changeDirection();

	/**
	 * Moves the robot in its current direction by the number of locations
	 * specified.
	 * 
	 * @param numLocs the number of locations to move. A value of 1 moves the robot
	 *                to the next location in the current direction. Precondition:
	 *                numLocs > 0
	 */
	void moveForward(int numLocs);
}

class FuelRobotX implements FuelRobot {
	private int index;
	private boolean faceDirection; // false->Left; true->Right

	@Override
	public int getCurrentIndex() {
		return this.index;
	}

	@Override
	public boolean isFacingRight() {
		// false->Left; true->Right
		return this.faceDirection;
	}

	@Override
	public void changeDirection() {
		this.faceDirection = (this.faceDirection? false: true);
	}

	@Override
	public void moveForward(int numLocs) {
		this.index = this.index + numLocs;
	}
}

class FuelDepot {
	/** The robot used to move the filling mechanism */
	private FuelRobotX filler;
	/** The list of fuel tanks */
	private List<FuelTankX> tanks;

	/**
	 * Determines and returns the index of the next tank to be filled.
	 * 
	 * @param threshold fuel tanks with a fuel level £ threshold may be filled
	 * @return index of the location of the next tank to be filled Postcondition:
	 *         the state of the robot has not changed
	 */
	// Answer for 2011 FRQ 3.(a)
	public int nextTankToFill(int threshold) {
		int nextTank = filler.getCurrentIndex();
		FuelTankX tank;
		int lowestLevel = threshold;
		
		for(int i=0; i < tanks.size(); i++) {
			tank = tanks.get(i);
			if(tank.getFuelLevel() <= lowestLevel) {
				lowestLevel = tank.getFuelLevel();
				nextTank = i;
			}
		}
		
		return nextTank;
	}

	/**
	 * Moves the robot to location locIndex.
	 * 
	 * @param locIndex the index of the location of the tank to move to
	 *                 Precondition: 0 £ locIndex < tanks.size() Postcondition: the
	 *                 current location of the robot is locIndex
	 */
	// Answer for 2011 FRQ 3.(b)
	public void moveToLocation(int locIndex) {
		int currentBotPos = filler.getCurrentIndex();
		int movement = locIndex - currentBotPos;
		// If positive move right; if negative, move left
		if(movement > 0) {
			// make sure it is facing right
			if(filler.isFacingRight()) {
				filler.changeDirection(); 
			} else if (movement < 0) {
				if(filler.isFacingRight())
					 filler.changeDirection();
			} else { //movement ==0
				// does't not need to move
				return;
			}
		}
		filler.moveForward(Math.abs(movement));
		
	}
	// There may be instance variables, constructors, and methods that are not shown.
}