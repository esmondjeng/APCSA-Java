package APCSA.FRQ._2022;

/**
 * This is 1-to-1 Class as Data Type like Date/Time/String classes
 * @author esmondjeng
 */
public class FrqAns2022Q1 {
	public static void main(String[] args) {
		Game g1 = new Game(100, 200, 500, true);
		Game g2 = new Game(50, 150, 200, false);
		System.out.println(g1);
		System.out.println(g2);
		
		// Test for 2022 FRQ 1.(a)
		g1.play();
		System.out.println(g1);
		System.out.println("Score:" + g1.getScore() + "\n");
		g2.play();
		System.out.println(g2);
		System.out.println("Score:" + g2.getScore() + "\n");
		
		// Test for 2022 FRQ 1.(b)
		System.out.printf("Game1 plays %d times to get score %d\n", 4, g1.playManyTimes(4));
		System.out.printf("Game2 plays %d times to get score %d\n", 6, g2.playManyTimes(6));

	}
} // End of FrqAns2022Q1 main()

class Level {
	int points;
	int levelPoints;
	/**
	 * Returns true if the player reached the goal on this level and returns false
	 * otherwise
	 */
	public Level(int initialPoints, int levelPoints) {
		this.points = initialPoints;
		this.levelPoints = levelPoints;		
	}
	
	public boolean goalReached() {
		if (this.points >= this.levelPoints)
			return true;
		else
			return false;
	}

	/** Returns the number of points (a positive integer) recorded for this level */
	public int getPoints() {
		return this.points;
	}
	
	/** Returns the number of points (a positive integer) recorded for this level */
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Level Point: " + levelPoints + "\n" +
				"Point: " + points + "; Goal: " + (goalReached()?"Success":"Failure");
	}
} // End of Class Level

class Game {
	private Level levelOne;
	private Level levelTwo;
	private Level levelThree;
	boolean bonus;

	/** Postcondition: All instance variables have been initialized. */
	public Game(int one, int two, int three, boolean bonus) {
		levelOne = new Level(0, one);
		levelTwo = new Level(0, two);
		levelThree = new Level(0, three);
		this.bonus = bonus;
	}

	/** Returns true if this game is a bonus game and returns false otherwise */
	public boolean isBonus() {
		return this.bonus;
	}

	/**
	 * Simulates the play of this Game (consisting of three levels) and updates all
	 * relevant game data
	 */
	public void play() {
		/* implementation not shown */
		int score1 = ((int) (Math.random()*200) + 1);
		int score2 = ((int) (Math.random()*300) + 1);
		int score3 = ((int) (Math.random()*600) + 1);
		
		levelOne.setPoints(score1);
		levelTwo.setPoints(score2);
		levelThree.setPoints(score3);
	}

	/**
	 * Returns the score earned in the most recently played game, as described in
	 * part (a)
	 */
	// Answer for 2022 FRQ 1.(a)
	public int getScore() {
		int sumScore = 0;
		if (levelOne.goalReached()) {
			sumScore = sumScore + levelOne.getPoints();
			 if (levelTwo.goalReached()) {
					sumScore = sumScore + levelTwo.getPoints();
					if (levelThree.goalReached()) {
						sumScore = sumScore + levelThree.getPoints();
					}
			 }			
		}
		
		return (this.bonus? sumScore*3: sumScore);
	}

	/**
	 * Simulates the play of num games and returns the highest score earned, as
	 * described in part (b) 
	 * Precondition: num > 0
	 */
	// Answer for 2022 FRQ 1.(b)
	public int playManyTimes(int num) {
		int maxScore = 0;
		for (int i=0; i < num; i++) {
			play();
			int currentScore = getScore();
			System.out.printf("%d - %d\n", i+1, currentScore);
			if (currentScore > maxScore)
				maxScore = currentScore;
		}
		
		return maxScore;
	}

	@Override
	public String toString() {
		String str;
		str = String.format("1. %s\n", this.levelOne);
		str = str + String.format("2. %s\n", this.levelTwo);
		str = str + String.format("3. %s\n", this.levelThree);
		str = str + String.format("Bonus: %s\n", (this.bonus?"Yes":"No"));
		return str;
	}
} // End of Game