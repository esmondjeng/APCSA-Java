package APCSA.FRQ._2009;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2009Q3 {
	public static void main(String[] args) {
		// Test for 2009 FRQ 3.(a)
		BatteryCharger c1 = new BatteryCharger();
		System.out.println(c1.getChargingCost(12, 1));
		System.out.println(c1.getChargingCost(0, 2));
		System.out.println(c1.getChargingCost(22, 7));
		System.out.println(c1.getChargingCost(22, 30));
		System.out.println("*****************");
		
		// Test for 2009 FRQ 3.(b)
		int x = 1;
		System.out.println("Hours: " + x + "; Starting: " + c1.getChargeStartTime(x));
		System.out.println("Hours: " + x + "; Cost: " + c1.getChargingCost(c1.getChargeStartTime(x), x));
		x = 2;
		System.out.println("Hours: " + x + "; Starting: " + c1.getChargeStartTime(x));
		System.out.println("Hours: " + x + "; Cost: " + c1.getChargingCost(c1.getChargeStartTime(x), x));
		x = 7;
		System.out.println("Hours: " + x + "; Starting: " + c1.getChargeStartTime(x));
		System.out.println("Hours: " + x + "; Cost: " + c1.getChargingCost(c1.getChargeStartTime(x), x));
		x = 30;
		System.out.println("Hours: " + x + "; Starting: " + c1.getChargeStartTime(x));
		System.out.println("Hours: " + x + "; Cost: " + c1.getChargingCost(c1.getChargeStartTime(x), x));
	}
}

class BatteryCharger {
	/**
	 * rateTable has 24 entries representing the charging costs for hours 0 through 23.
	 */
	private int[] rateTable;
	
	public BatteryCharger() {
		int[] r = {50, 60, 160, 60, 80, 100, 100, 120, 150, 150, 150, 200, 
				40, 240, 220, 220, 200, 200, 180, 180, 140, 100, 80, 60};
		this.rateTable = r;
	}

	/**
	 * Determines the total cost to charge the battery starting at the beginning of startHour.
	 * 
	 * @param startHour  the hour at which the charge period begins Precondition: 0 ≤ startHour ≤ 23
	 * @param chargeTime the number of hours the battery needs to be charged
	 * 
	 * Precondition: chargeTime > 0
	 * @return the total cost to charge the battery
	 */
	// Answer for 2009 FRQ 3.(a)
	public int getChargingCost(int startHour, int chargeTime) {
		int cost = 0;
		for (int h = startHour; h < (startHour + chargeTime); h++) {
			cost = cost + rateTable[h % 24]; // h could exceed 23
		}
		return cost;
	}

	/**
	 * Determines start time to charge the battery at the lowest cost for the given charge time.
	 * 
	 * @param chargeTime the number of hours the battery needs to be charged
	 * 
	 * Precondition: chargeTime > 0
	 * @return an optimal start time, with 0 ≤ returned value ≤ 23
	 */
	// Answer for 2009 FRQ 3.(b)
	public int getChargeStartTime(int chargeTime) {
		int cheapestHour = 0;
		for (int h=1; h<=23; h++) {
			if (getChargingCost(cheapestHour, chargeTime) > getChargingCost(h, chargeTime)) {
				cheapestHour = h;
			}
		}
		return cheapestHour;
	}
}